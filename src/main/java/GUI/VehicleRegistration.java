package GUI;

import javax.swing.*;

public class VehicleRegistration extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton clearButton;
    private JButton saveButton;
    private JPanel root;

    public VehicleRegistration() {
        this.setContentPane(root);
        this.setTitle("Parking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        saveButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                Dashboard myFrame = new Dashboard();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });
    }
}
