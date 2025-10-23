package GUI;

import javax.swing.*;

public class SignUpPage extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextArea textArea1;
    private JButton saveButton;
    private JPanel root;
    private JTextField textField4;

    public SignUpPage() {
        this.setContentPane(root);
        this.setTitle("Parking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        saveButton.addActionListener(e -> {
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
        SwingUtilities.invokeLater(() -> {
            SignUpPage myFrame = new SignUpPage();
            myFrame.setSize(1000, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });
    }

}
