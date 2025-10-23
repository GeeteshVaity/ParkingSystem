package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JPanel root;
    private JButton loginButton;
    private JButton signUpButton;
    private JTextField textField1;
    private JTextField textField2;


    public LoginPage() {

        this.setContentPane(root);
        this.setTitle("Parking System");
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
            SwingUtilities.invokeLater(() -> {
                Dashboard myFrame = new Dashboard();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });

            this.dispose();
        });
    }

    public static void main (String[] args) {


    }
}
