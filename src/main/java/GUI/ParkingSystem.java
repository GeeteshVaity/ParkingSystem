package GUI;

import javax.swing.*;

public class ParkingSystem extends JFrame {
    private JPanel root;
    private JPanel LotAPanel;
    private JPanel LotBPanel;
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
    private JButton spot3BButton;
    private JButton spot5BButton;
    private JButton spot7BButton;
    private JButton spot6BButton;
    private JButton spot8BButton;
    private JButton spot4BButton;
    private JButton spot2BButton;
    private JTextField lotATextField;
    private JTextField YYYYMMDDHHTextField;
    private JButton bookButton;
    private JTextField a1ATextField;
    private JButton back;

    public ParkingSystem() {
        this.setContentPane(root);
        this.setTitle("Parking System");
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
