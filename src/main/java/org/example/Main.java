package org.example;


import Data.Owner;
import Data.ParkingLot;
import Data.ParkingSpot;
import Data.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
    }

    private Connection conn = DatabaseConnection.getConnection();

    public void SignIn(Owner owner) {
        String sql = "  INSERT INTO owner (first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)"; // modify according to jays database
        try(PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setString(1, owner.firstname);
            psmt.setString(2,owner.lastname);
            psmt.setString(3,owner.email);
            psmt.setString(4, owner.phone);
            psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void SetVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle (licence_plate, type) VALUES (?, ?)"; // modify according to jays database
        try(PreparedStatement psmt = conn.prepareStatement(sql) ) {
            psmt.setString(1,vehicle.licenseplate);
            psmt.setString(2, vehicle.type);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ChooseSpot(ParkingSpot parkingSpot) {
        String sql = "SELECT * FROM spot WHERE spot_number = ?";
        try(PreparedStatement psmt = conn.prepareStatement(sql)) {
            psmt.setInt(1, parkingSpot.spotNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void bookSpot(ParkingSpot parkingSpot) {
        String sql = "";
        try(PreparedStatement psmt = conn.prepareStatement(sql) ) {
        }catch (SQLException e) {

        }
    }




}