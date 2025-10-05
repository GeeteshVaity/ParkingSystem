package GUI;

import javax.swing.*;

public class ParkingSystem extends JFrame {
    private JPanel root;
    private JPanel LotAPanel;
    private JPanel LotBPanel;
    private JPanel LotCPanel;
    private JPanel TicketPanel;
    private JButton spot1AButton;
    private JButton spot3AButton;
    private JButton spot5AButton;
    private JButton spot7AButton;
    private JButton spot4AButton;
    private JButton spot2AButton;
    private JButton spot6AButton;
    private JButton spot8AButton;
    private JButton spot1BButton;
    private JButton spot3Button1;
    private JButton spot5Button1;
    private JButton spot7Button1;
    private JButton spot6Button1;
    private JButton spot8Button1;
    private JButton spot4Button1;
    private JButton spot2Button1;
    private JButton spot1Button2;
    private JButton spot3Button2;
    private JButton spot5Button2;
    private JButton spot7Button2;
    private JButton spot6Button3;
    private JButton spot8Button2;
    private JButton spot2Button2;
    private JButton spot4Button2;
    private JButton emptySpotButton;
    private JTextField textField1;
    private JTextPane textPane1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton payButton;
    private JButton getTicketButton;

    public ParkingSystem() {
        this.setContentPane(root);
        this.setTitle("Parking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        
        spot1AButton.addActionListener(e -> {
            //action
        });
    }

    public  static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ParkingSystem myFrame = new ParkingSystem();
            myFrame.setSize(1000, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });
    }
}
