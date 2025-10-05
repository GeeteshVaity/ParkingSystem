package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static final String url = "Your Url";
    public static final String username = "Your Username";
    public static final String password = "Your Password";

    private DatabaseConnection() {}

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
