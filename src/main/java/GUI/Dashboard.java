package GUI;

import org.example.Main; // Import Main
import javax.swing.*;

public class Dashboard extends JFrame {
    private JButton vehicleRegistrationButton;
    private JButton bookSpotButton;
    private JButton signOutButton;
    private JPanel root;
    private JButton clearSpotButton;

    public Dashboard() {
        this.setContentPane(root);
        this.setTitle("Parking System - Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);


        vehicleRegistrationButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                VehicleRegistration myFrame = new VehicleRegistration();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });

        bookSpotButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                // Open ParkingSystem in "book" mode
                ParkingSystem myFrame = new ParkingSystem("book");
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });

        clearSpotButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                // Open ParkingSystem in "clear" mode
                ParkingSystem myFrame = new ParkingSystem("clear");
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });

        signOutButton.addActionListener(e -> {
            // Clear the logged-in user's ID from Main
            Main.currentMemberId = 0;

            SwingUtilities.invokeLater(() -> {
                LoginPage myFrame = new LoginPage();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });
    }

    public static void main(String[] args) {
        // Main for testing this frame
        SwingUtilities.invokeLater(() -> {
            Dashboard myFrame = new Dashboard();
            myFrame.setSize(1000, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });
    }
}
