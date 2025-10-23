package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static final String url = "jdbc:mysql://localhost:3306/Smart_Parking_System";
    public static final String username = "root";
    public static final String password = "MAZASQL";

    public static Connection getConnection() {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            return conn;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Connection failed");
        }

    }

}
