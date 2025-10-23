package GUI;

import org.example.Main; // Import Main
import javax.swing.*;

public class VehicleRegistration extends JFrame {
    private JTextField textField1; // Vehicle Number (V_regNo)
    private JTextField textField2; // Engine Number (V_engNo)
    private JTextField textField3; // Vehicle Model (V_model)
    private JTextField textField4; // Vehicle Name (V_name)
    private JButton clearButton;
    private JButton saveButton;
    private JPanel root;
    private JButton back;

    public VehicleRegistration() {
        this.setContentPane(root);
        this.setTitle("Parking System - Vehicle Registration");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        back.addActionListener(event -> {
            SwingUtilities.invokeLater(() -> {
                Dashboard myFrame = new Dashboard();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });

        saveButton.addActionListener(e -> {
            registerVehicle();
        });

        clearButton.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
        });
    }

    private void registerVehicle() {
        String regNo = textField1.getText();
        String engNo = textField2.getText();
        String model = textField3.getText();
        String name = textField4.getText();

        if (regNo.isEmpty() || engNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vehicle Number and Engine Number are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Call the centralized register method from Main
        boolean success = Main.registerVehicle(regNo, engNo, model, name);

        if (success) {
            JOptionPane.showMessageDialog(this, "Vehicle registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Go back to Dashboard
            SwingUtilities.invokeLater(() -> {
                Dashboard myFrame = new Dashboard();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Vehicle registration failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VehicleRegistration myFrame = new VehicleRegistration();
            myFrame.setSize(1000, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });
    }
}
