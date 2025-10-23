package GUI;

import org.example.Main; // Import Main
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkingSystem extends JFrame {
    private JPanel root;
    private JPanel LotAPanel;
    private JPanel LotBPanel;
    private JPanel TicketPanel; // Booking Panel
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
    private JTextField lotATextField; // "Selected Lot" for booking
    private JTextField YYYYMMDDHHTextField; // "In Time" for booking
    private JButton bookButton;
    private JTextField a1ATextField; // "Selected Spot" for booking
    private JButton back;

    // --- Components from "Clear Spot" panel (Missing from original .java file) ---
    private JPanel clearSpotPanel; // The panel with grid id 925de
    private JTextField clearLotTextField; // b1abd
    private JTextField clearSpotTextField; // 2e788
    private JTextField clearTimeTextField; // 2097b
    private JButton checkOutButton; // c1d92

    // --- New component (Missing from .form file) ---
    private JTextField vehicleRegNoTextField;

    // Map buttons to their unique integer Slot_No
    private final int[] spotIDs = {
            1, 2, 3, 4, 5, 6, 7, 8, // Lot A (1A-8A)
            9, 10, 11, 12, 13, 14, 15, 16 // Lot B (1B-8B)
    };

    public ParkingSystem(String mode) {

        // --- Fix 1: Reliably find the "Clear Spot" panel ---
        JPanel clearSpotSubPanel = null;
        for (Component rootChild : root.getComponents()) {
            if (rootChild instanceof JPanel) {
                JPanel potentialPanel = (JPanel) rootChild;
                if (potentialPanel.getComponentCount() == 1 && potentialPanel.getComponent(0) instanceof JPanel) {
                    JPanel potentialSubPanel = (JPanel) potentialPanel.getComponent(0);
                    if (potentialSubPanel.getComponentCount() == 8) {
                        clearSpotPanel = potentialPanel;
                        clearSpotSubPanel = potentialSubPanel;
                        break;
                    }
                }
            }
        }
        if (clearSpotPanel == null) {
            JOptionPane.showMessageDialog(null, "CRITICAL ERROR: Could not find clearSpotPanel. Your .form and .java files are out of sync.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        clearLotTextField = (JTextField) clearSpotSubPanel.getComponent(2);
        clearTimeTextField = (JTextField) clearSpotSubPanel.getComponent(4);
        checkOutButton = (JButton) clearSpotSubPanel.getComponent(5);
        clearSpotTextField = (JTextField) clearSpotSubPanel.getComponent(6);
        // --- End of Fix 1 ---

        clearTimeTextField.setText("YYYY-MM-DD HH:MM:SS");


        // --- Fix 2: Correctly rebuild the "Book Spot" panel ---
        // Find the unbound labels
        Component bookSpotLabel = null;
        Component lotLabel = null;
        Component spotLabel = null;
        Component timeLabel = null;
        for(Component comp : TicketPanel.getComponents()) {
            if (comp instanceof JLabel) {
                String text = ((JLabel) comp).getText();
                if ("Book Spot".equals(text)) bookSpotLabel = comp;
                else if ("Selected Lot:".equals(text)) lotLabel = comp;
                else if ("Selected Spot:".equals(text)) spotLabel = comp;
                else if ("In Time:".equals(text)) timeLabel = comp;
            }
        }

        TicketPanel.removeAll();
        TicketPanel.setLayout(new GridLayout(6, 2, 5, 5)); // 6 rows, 2 cols, 5px gaps

        // ** THIS IS THE FIX **
        // Add components sequentially without indices
        TicketPanel.add(bookSpotLabel);
        TicketPanel.add(new JLabel("")); // Empty cell

        TicketPanel.add(lotLabel);
        TicketPanel.add(lotATextField);

        TicketPanel.add(spotLabel);
        TicketPanel.add(a1ATextField);

        // Add the new row
        JLabel vehicleRegLabel = new JLabel("Vehicle RegNo:");
        vehicleRegLabel.setFont(new Font("Arial Black", Font.BOLD, 14));
        vehicleRegNoTextField = new JTextField();
        TicketPanel.add(vehicleRegLabel);
        TicketPanel.add(vehicleRegNoTextField);

        TicketPanel.add(timeLabel);
        TicketPanel.add(YYYYMMDDHHTextField);

        TicketPanel.add(bookButton);
        TicketPanel.add(new JLabel("")); // Empty cell
        // --- End of Fix 2 ---


        this.setContentPane(root);
        this.setTitle("Parking System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        // --- Mode selection ---
        if ("book".equals(mode)) {
            clearSpotPanel.setVisible(false);
            TicketPanel.setVisible(true);
            setTitle("Parking System - Book Spot");
        } else if ("clear".equals(mode)) {
            clearSpotPanel.setVisible(true);
            TicketPanel.setVisible(false);
            setTitle("Parking System - Clear Spot");
        }

        back.addActionListener(event -> {
            SwingUtilities.invokeLater(() -> {
                Dashboard myFrame = new Dashboard();
                myFrame.setSize(1000, 500);
                myFrame.setResizable(false);
                myFrame.setVisible(true);
            });
            this.dispose();
        });

        addButtonListeners();
        bookButton.addActionListener(e -> bookSpot());
        checkOutButton.addActionListener(e -> clearSpot());
    }

    /**
     * Adds click listeners to all 16 parking spot buttons.
     */
    private void addButtonListeners() {
        JButton[] buttons = {
                spot1AButton, spot2AButton, spot3AButton, spot4AButton, spot5AButton, spot6AButton, spot7AButton, spot8AButton,
                spot1BButton, spot2BButton, spot3BButton, spot4BButton, spot5BButton, spot6BButton, spot7BButton, spot8BButton
        };

        for(int i = 0; i < buttons.length; i++) {
            if (buttons[i] == null) continue;

            final int spotId = spotIDs[i];
            final String lotName = (i < 8) ? "Lot A" : "Lot B";

            buttons[i].addActionListener(e -> {
                a1ATextField.setText(String.valueOf(spotId));
                lotATextField.setText(lotName);

                clearSpotTextField.setText(String.valueOf(spotId));
                clearLotTextField.setText(lotName);

                String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                YYYYMMDDHHTextField.setText(now);
                clearTimeTextField.setText(now);
            });
        }
    }

    /**
     * Gathers data from the booking panel and calls Main.bookSpot().
     */
    private void bookSpot() {
        int m_id = Main.currentMemberId;
        String v_regNo = vehicleRegNoTextField.getText();
        String slotNoStr = a1ATextField.getText();
        String inTimeStr = YYYYMMDDHHTextField.getText();

        if (v_regNo.isEmpty() || slotNoStr.isEmpty() || inTimeStr.isEmpty() || inTimeStr.equals("YYYY-MM-DD HH:MM:SS")) {
            JOptionPane.showMessageDialog(this, "Please select a spot and enter a Vehicle RegNo and In-Time.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int slotNo;
        try {
            slotNo = Integer.parseInt(slotNoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Spot ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resultCode = Main.bookSpot(m_id, v_regNo, slotNo, inTimeStr);

        if (resultCode == 0) {
            JOptionPane.showMessageDialog(this, "Spot " + slotNo + " booked successfully for vehicle " + v_regNo + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (resultCode == 1) {
            // This message is already shown by Main.java
        } else if (resultCode == 2) {
            JOptionPane.showMessageDialog(this, "Booking failed. Vehicle with registration number '" + v_regNo + "' is not registered.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (resultCode == 3) {
            JOptionPane.showMessageDialog(this, "Booking failed. Spot " + slotNo + " is already in use.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Booking failed due to an unknown error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Gathers data from the clear spot panel and calls Main.clearSpot().
     */
    private void clearSpot() {
        String slotNoStr = clearSpotTextField.getText();
        String outTimeStr = clearTimeTextField.getText();

        if (slotNoStr.isEmpty() || outTimeStr.isEmpty() || outTimeStr.equals("YYYY-MM-DD HH:MM:SS")) {
            JOptionPane.showMessageDialog(this, "Please select a spot and enter an Out-Time.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int slotNo;
        try {
            slotNo = Integer.parseInt(slotNoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Spot ID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int resultCode = Main.clearSpot(slotNo, outTimeStr);

        if (resultCode == 0) {
            JOptionPane.showMessageDialog(this, "Spot " + slotNo + " cleared successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (resultCode == 1) {
            // Message already shown by Main.java
        } else if (resultCode == 2) {
            JOptionPane.showMessageDialog(this, "Checkout failed. This spot is not currently in use.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Checkout failed due to an unknown error.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method for testing this frame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ParkingSystem myFrame = new ParkingSystem("book");
            myFrame.setSize(1000, 500);
            myFrame.setResizable(false);
            myFrame.setVisible(true);
        });
    }
}