package GUI;

import javax.swing.*;

public class Dashboard extends JFrame {
    private JButton vehicleRegistrationButton;
    private JButton bookSpotButton;
    private JButton signOutButton;
    private JPanel root;
    private JButton clearSpotButton;

    public Dashboard() {
        this.setContentPane(root);
        this.setTitle("Parking System");
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
                ParkingSystem myFrame = new ParkingSystem();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });

        clearSpotButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                ParkingSystem myFrame = new ParkingSystem();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });

        signOutButton.addActionListener(e -> {
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

    }
}
