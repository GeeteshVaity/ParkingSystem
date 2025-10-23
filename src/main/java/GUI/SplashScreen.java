package GUI;

import javax.swing.*;

public class SplashScreen extends JFrame {
    private JPanel root;
    private JLabel title;
    private JButton launchButton;

    public  SplashScreen() {
        this.setContentPane(root);
        this.setTitle("Parking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        launchButton.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                LoginPage myFrame = new LoginPage();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });

            this.dispose();
        });
    }

    public  static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SplashScreen myFrame = new SplashScreen();
            myFrame.setSize(1000, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });
    }


}
