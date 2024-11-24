package ChangePinGui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import GUI.Home;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

import Signup.signup_database; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Change_Pin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldNewPin;
    private JTextField textFieldConfirmNewPin;
    private JLabel lblConfirmNewPin;
    private JPanel panel;
    private JLabel lblpleaseEnterYour;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_1_2;
    private JButton btnHome;

    // Assume you have a way to get the current user's ID
    private int currentUserId = 1; // Replace with actual user ID logic

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Change_Pin frame = new Change_Pin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Change_Pin() {
        // Initialize the frame and components
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(497, 0, 886, 548);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(230, 245, 255));
        contentPane.setBackground(new Color(230, 245, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textFieldNewPin = new JTextField();
        textFieldNewPin.setToolTipText("Enter New Pin");
        textFieldNewPin.setColumns(10);
        textFieldNewPin.setBounds(106, 186, 260, 38);
        contentPane.add(textFieldNewPin);
        
        textFieldConfirmNewPin = new JTextField();
        textFieldConfirmNewPin.setToolTipText("Confirm your pin");
        textFieldConfirmNewPin.setColumns(10);
        textFieldConfirmNewPin.setBounds(106, 285, 260, 38);
        contentPane.add(textFieldConfirmNewPin);
        
        JLabel lblChangePin = new JLabel("CHANGE PIN");
        lblChangePin.setForeground(new Color(0, 78, 168));
        lblChangePin.setFont(new Font("Tahoma", Font.BOLD, 45));
        lblChangePin.setBounds(95, 66, 292, 60);
        contentPane.add(lblChangePin);
        
        JLabel lblNewPin = new JLabel("New Pin:");
        lblNewPin.setForeground(new Color(0, 78, 168));
        lblNewPin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewPin.setBounds(106, 149, 94, 26);
        contentPane.add(lblNewPin);
        
        lblConfirmNewPin = new JLabel("Confirm New Pin:");
        lblConfirmNewPin.setForeground(new Color(0, 78, 168));
        lblConfirmNewPin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblConfirmNewPin.setBounds(106, 248, 154, 26);
        contentPane.add(lblConfirmNewPin);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.setForeground(new Color(0, 78, 168));
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnUpdate.setBounds(180, 359, 119, 38);
        contentPane.add(btnUpdate);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0, 78, 168));
        panel.setBounds(507, 0, 363, 509);
        contentPane.add(panel);
        
        lblpleaseEnterYour = new JLabel("<html>Please enter your new PIN and confirm it. Ensure your new PIN is 5 digits long.</html>");
        lblpleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
        lblpleaseEnterYour.setForeground(Color.WHITE);
        lblpleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblpleaseEnterYour.setBounds(46, 90, 271, 306);
        panel.add(lblpleaseEnterYour);
        
        lblNewLabel_3 = new JLabel("Welcome to PotsBank");
        lblNewLabel_3.setForeground(new Color(230, 245, 255));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_3.setBounds(18, 33, 335, 64);
        panel.add(lblNewLabel_3);
        
        lblNewLabel_1_2 = new JLabel("Your Trust, Our Commitment");
        lblNewLabel_1_2.setForeground(new Color(252, 183, 21));
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblNewLabel_1_2.setBounds(92, 90, 219, 35);
        panel.add(lblNewLabel_1_2);
        
        btnHome = new JButton("Home");
        btnHome.setForeground(new Color(0, 78, 168));
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnHome.setBackground(new Color(252, 183, 21));
        btnHome.setBounds(10, 11, 100, 30);
        contentPane.add(btnHome);
        btnHome.addActionListener(e -> {
            Home homeWindow = new Home(0); 
            homeWindow.setVisible(true); 
            dispose();
        });
        
        btnUpdate.addActionListener(e -> {
            String newPin = textFieldNewPin.getText();
            String confirmNewPin = textFieldConfirmNewPin.getText();

            // Validate new PIN
            if (newPin.length() != 5 || !newPin.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "New PIN must be exactly 5 digits.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if new PIN and confirm PIN match
            if (!newPin.equals(confirmNewPin)) {
                JOptionPane.showMessageDialog(null, "New PINs do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update the PIN in the database
            if (updatePinInDatabase(newPin)) {
                JOptionPane.showMessageDialog(null, "PIN updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update PIN in the database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private boolean updatePinInDatabase(String newPin) {
        String updateSQL = "UPDATE users SET pin = ? WHERE UserID = ?";
        try (Connection connection = signup_database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

        	preparedStatement.setInt(1, Integer.parseInt(newPin)); // Set new PIN
            preparedStatement.setInt(2, currentUserId); // Use the actual user ID

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}