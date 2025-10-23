package GUI;

import org.example.Main; // Import Main
import javax.swing.*;

public class LoginPage extends JFrame {
    private JPanel root;
    private JButton loginButton;
    private JButton signUpButton;
    private JTextField textField1; // Password (from .form file)
    private JTextField textField2; // Username (from .form file)


    public LoginPage() {
        this.setContentPane(root);
        this.setTitle("Parking System - Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        signUpButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                SignUpPage myFrame = new SignUpPage();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });

        loginButton.addActionListener(e -> {
            performLogin();
        });
    }

    private void performLogin() {
        String username = textField2.getText(); // M_Fname
        String passwordStr = textField1.getText();

        if (username.isEmpty() || passwordStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Username and Password.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int password;
        try {
            password = Integer.parseInt(passwordStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Password must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Call the centralized login method from Main
        int memberId = Main.performLogin(username, password);

        if (memberId > 0) {
            // Login Successful
            JOptionPane.showMessageDialog(this, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Open Dashboard
            SwingUtilities.invokeLater(() -> {
                Dashboard myFrame = new Dashboard();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();

        } else {
            // Login Failed
            JOptionPane.showMessageDialog(this, "Invalid Username or Password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // This main is just for testing this frame
        SwingUtilities.invokeLater(() -> {
            LoginPage myFrame = new LoginPage();
            myFrame.setSize(1000, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });
    }
}
