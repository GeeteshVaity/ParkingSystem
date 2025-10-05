package GUI;

import Data.Owner;
import Data.Vehicle;
import org.example.Main;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class SiginPage extends JFrame {
    private JPanel root;
    private JPanel HeaderPanel;
    private JPanel ContentPanel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JTextField licensePalteField;
    private JTextField phoneField;
    private JComboBox vehicleTypeComboBox;
    private JButton saveButton;
    private JPanel buttonPanel;

    // Constructor to set up the frame
    public SiginPage() {

        this.setContentPane(root);
        this.setTitle("Sign In");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        saveButton.addActionListener(e -> {
            String firstname = firstNameField.getText();
            String lastname = lastNameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String vehicleType = vehicleTypeComboBox.getSelectedItem().toString();
            String licensePlate = licensePalteField.getText();

            Owner owner = new Owner(firstname,lastname,email,phone);
            Vehicle vehicle = new Vehicle(licensePlate,vehicleType);
            Main user = new Main();
            try {
                user.SignIn(owner);
                user.SetVehicle(vehicle);
                JOptionPane.showMessageDialog(this, "User Saved Successfully!");
                try {
                    ParkingSystem parkingSystem = new ParkingSystem();
                    parkingSystem.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            } catch (RuntimeException exp) {
                JOptionPane.showMessageDialog(this, "Error saving data: " + exp.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        });
    }

    public  static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SiginPage myFrame = new SiginPage();
            myFrame.setSize(800, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });



    }




}

