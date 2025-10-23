package org.example;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    /**
     * Static variable to hold the Member ID (M_id) of the currently logged-in user.
     */
    public static int currentMemberId;

    /**
     * Main application entry point.
     * Launches the SplashScreen.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI.SplashScreen app = new GUI.SplashScreen();
            // Set a consistent size for the splash screen
            app.setSize(1000, 500);
            app.setResizable(false);
            app.setVisible(true);
        });
    }

    // --- Database Functionality ---

    /**
     * Attempts to log in a user.
     * @param username The user's first name (M_Fname).
     * @param password The user's password (as an int).
     * @return The M_id if login is successful, or -1 if it fails.
     */
    public static int performLogin(String username, int password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT M_id FROM member WHERE M_Fname = ? AND password = ?";

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, password);

            rs = ps.executeQuery();

            if (rs.next()) {
                // Login Successful
                int memberId = rs.getInt("M_id");
                currentMemberId = memberId; // Store the logged-in user's ID
                return memberId;
            } else {
                // Login Failed
                return -1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        } finally {
            DatabaseConnection.close(rs, ps, conn);
        }
    }

    /**
     * Registers a new member in the database.
     * @return true if registration is successful, false otherwise.
     */
    public static boolean registerMember(String fName, String lName, String contactNo, String address, int password) {
        Connection conn = null;
        PreparedStatement ps = null;
        // Assuming M_id is Auto-Increment
        String sql = "INSERT INTO member (M_Fname, M_Lname, M_contactNo, M_address, password) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, contactNo);
            ps.setString(4, address);
            ps.setInt(5, password);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            DatabaseConnection.close(ps, conn);
        }
    }

    /**
     * Registers a new vehicle in the database.
     * @return true if registration is successful, false otherwise.
     */
    public static boolean registerVehicle(String regNo, String engNo, String model, String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        // Assuming you added the M_id column to Vehicle
        String sql = "INSERT INTO vehicle (V_regNo, V_engNo, V_name, V_model, M_id) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, regNo);
            ps.setString(2, engNo);
            ps.setString(3, name);
            ps.setString(4, model);
            ps.setInt(5, currentMemberId); // Links the vehicle to the logged-in user

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            DatabaseConnection.close(ps, conn);
        }
    }

    /**
     * Books a parking spot by creating a new record in parkingtime.
     * @return 0=Success, 1=Format Error, 2=Vehicle Not Registered, 3=Spot Already Taken
     */
    public static int bookSpot(int m_id, String v_regNo, int slotNo, String inTimeStr) {
        Timestamp inTime;
        try {
            inTime = Timestamp.valueOf(LocalDateTime.parse(inTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid In-Time format. Use YYYY-MM-DD HH:MM:SS", "Error", JOptionPane.ERROR_MESSAGE);
            return 1; // Format Error
        }

        Connection conn = null;
        PreparedStatement psCheckVehicle = null;
        ResultSet rsVehicle = null;
        PreparedStatement psCheckSpot = null;
        ResultSet rsSpot = null;
        PreparedStatement psInsert = null;

        String sqlCheckVehicle = "SELECT V_regNo FROM vehicle WHERE V_regNo = ?";
        String sqlCheckSpot = "SELECT 1 FROM parkingtime WHERE Slot_No = ? AND OutTime IS NULL";
        String sqlInsert = "INSERT INTO parkingtime (M_id, V_regNo, Slot_No, InTime) VALUES (?, ?, ?, ?)";

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // Step 1: Check if Vehicle is registered
            psCheckVehicle = conn.prepareStatement(sqlCheckVehicle);
            psCheckVehicle.setString(1, v_regNo);
            rsVehicle = psCheckVehicle.executeQuery();
            if (!rsVehicle.next()) {
                conn.rollback();
                return 2; // Vehicle Not Registered
            }

            // Step 2: Check if Spot is already taken (has a record with no OutTime)
            psCheckSpot = conn.prepareStatement(sqlCheckSpot);
            psCheckSpot.setInt(1, slotNo);
            rsSpot = psCheckSpot.executeQuery();
            if (rsSpot.next()) {
                conn.rollback();
                return 3; // Spot Already Taken
            }

            // Step 3: Insert the new booking
            psInsert = conn.prepareStatement(sqlInsert);
            psInsert.setInt(1, m_id);
            psInsert.setString(2, v_regNo);
            psInsert.setInt(3, slotNo);
            psInsert.setTimestamp(4, inTime);

            int rowsAffected = psInsert.executeUpdate();

            if (rowsAffected > 0) {
                conn.commit();
                return 0; // Success
            } else {
                conn.rollback();
                return -1; // Unknown failure
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            try { if (conn != null) conn.rollback(); } catch (SQLException se) { se.printStackTrace(); }
            return -1; // Unknown failure
        } finally {
            DatabaseConnection.close(rsVehicle, psCheckVehicle, rsSpot, psCheckSpot, psInsert, conn);
        }
    }

    /**
     * Clears a parking spot by setting the OutTime on an active record.
     * @return 0=Success, 1=Format Error, 2=Spot Not Found or Already Clear
     */
    public static int clearSpot(int slotNo, String outTimeStr) {
        Timestamp outTime;
        try {
            // Replace any newline characters just in case
            String cleanTimeStr = outTimeStr.replace("\n", "").trim();
            outTime = Timestamp.valueOf(LocalDateTime.parse(cleanTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid Out-Time format. Use YYYY-MM-DD HH:MM:SS", "Error", JOptionPane.ERROR_MESSAGE);
            return 1; // Format Error
        }

        Connection conn = null;
        PreparedStatement ps = null;
        // Update the parking record that is currently active (OutTime is NULL)
        String sql = "UPDATE parkingtime SET OutTime = ? WHERE Slot_No = ? AND OutTime IS NULL";

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, outTime);
            ps.setInt(2, slotNo);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                return 0; // Success
            } else {
                return 2; // Spot not in use or already clear
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return -1; // Unknown failure
        } finally {
            DatabaseConnection.close(ps, conn);
        }
    }
}