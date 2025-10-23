package org.example;


import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.example.DatabaseConnection.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI.SplashScreen app = new GUI.SplashScreen();
            app.setVisible(true);
        });
    }
}