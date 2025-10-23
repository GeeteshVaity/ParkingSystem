package GUI;

import org.example.Main; // Import Main
import javax.swing.*;

public class SignUpPage extends JFrame {
    private JTextField textField1; // First Name
    private JTextField textField2; // Last Name
    private JTextField textField3; // Contact Number
    private JTextArea textArea1;   // Address
    private JButton saveButton;
    private JPanel root;
    private JTextField textField4; // Password

    public SignUpPage() {
        this.setContentPane(root);
        this.setTitle("Parking System - Sign Up");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        saveButton.addActionListener(e -> {
            registerMember();
        });
    }

    private void registerMember() {
        String fName = textField1.getText();
        String lName = textField2.getText();
        String contactNo = textField3.getText();
        String passwordStr = textField4.getText();
        String address = textArea1.getText();

        // Basic validation
        if (fName.isEmpty() || lName.isEmpty() || contactNo.isEmpty() || passwordStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields (First Name, Last Name, Contact, Password).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int password;
        try {
            password = Integer.parseInt(passwordStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Password must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Call the centralized register method from Main
        boolean success = Main.registerMember(fName, lName, contactNo, address, password);

        if (success) {
            JOptionPane.showMessageDialog(this, "Sign up successful! Please log in.", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Go to Login Page
            SwingUtilities.invokeLater(() -> {
                LoginPage myFrame = new LoginPage();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Sign up failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SignUpPage myFrame = new SignUpPage();
            myFrame.setSize(1000, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });
    }
}
