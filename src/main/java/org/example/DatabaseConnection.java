package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database connection details from your original file
    public static final String url = "jdbc:mysql://localhost:3306/Smart_Parking_System";
    public static final String username = "root";
    public static final String password = "MAZASQL";

    /**
     * Establishes and returns a connection to the database.
     * @return A Connection object or null if connection fails.
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Ensure the JDBC driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        catch (Exception e) {
            e.printStackTrace();
            // It's better to let the caller handle the exception or show a message
            throw new RuntimeException("Connection failed: " + e.getMessage());
        }
    }

    /**
     * Helper utility to close multiple database resources (Connection, Statement, ResultSet).
     * @param closeables Varargs of AutoCloseable resources.
     */
    public static void close(AutoCloseable... closeables) {
        for (AutoCloseable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e) {
                    // Log or print the stack trace for debugging
                    e.printStackTrace();
                }
            }
        }
    }
}
