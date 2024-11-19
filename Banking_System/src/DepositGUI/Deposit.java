package DepositGUI;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import GUI.Home;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {
    private JPanel panel;
    private JTextField textField_1;
    private JLabel lblEnterTheAmount_1;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_1;
    private JLabel lblEnterTheAmount;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Deposit window = new Deposit();
                    window.setVisible(true);  // Directly display the Deposit JFrame
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Deposit() {
    	getContentPane().setBackground(new Color(230,245,255));
    	getContentPane().setForeground(new Color(252, 183, 21));
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Set the title, size, and close operation for the JFrame
        setTitle("Deposit");
        setBounds(100, 100, 876, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Welcome label
        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setForeground(new Color(0, 78, 168));
        lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 50));
        lblDeposit.setBounds(135, 90, 192, 80);
        getContentPane().add(lblDeposit);

        // Panel for deposit functionality
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0, 78, 168));
        panel.setBounds(70, 205, 320, 140);
        getContentPane().add(panel);

        // TextField for deposit amount
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(26, 64, 268, 26);
        panel.add(textField_1);

        // Label for entering amount
        lblEnterTheAmount_1 = new JLabel("Enter the Amount to Deposit");
        lblEnterTheAmount_1.setForeground(new Color(230, 245, 254));
        lblEnterTheAmount_1.setBackground(new Color(230, 245, 254));
        lblEnterTheAmount_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEnterTheAmount_1.setBounds(66, 28, 187, 19);
        panel.add(lblEnterTheAmount_1);

        // Button to confirm the deposit
        btnNewButton = new JButton("Enter");
        btnNewButton.setForeground(new Color(0,78,168));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton.setBounds(115, 106, 89, 23);
        panel.add(btnNewButton);

        // "Home" button to go back to the home screen
        btnNewButton_1 = new JButton("Home");
        btnNewButton_1.setForeground(new Color(0, 78, 168));
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Home home = new Home();
                home.setVisible(true);  // Open Home screen
                dispose();  // Close the current Deposit window
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton_1.setBounds(10, 11, 89, 23);
        getContentPane().add(btnNewButton_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0,78,168));
        panel_1.setBounds(460, 0, 400, 501);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Welcome to PotsBank");
        lblNewLabel.setBounds(39, 77, 331, 37);
        panel_1.add(lblNewLabel);
        lblNewLabel.setForeground(new Color(230,245,255));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        
        lblNewLabel_1 = new JLabel("Your Trust, Our Commitment");
        lblNewLabel_1.setForeground(new Color(252, 183, 21));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblNewLabel_1.setBounds(105, 115, 219, 35);
        panel_1.add(lblNewLabel_1);
        
        lblEnterTheAmount = new JLabel("<html>To complete your deposit, simply enter the amount you wish to deposit and confirm.<br>Once submitted, you'll receive a confirmation message.</html>");
        lblEnterTheAmount.setForeground(new Color(230, 245, 254));
        lblEnterTheAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEnterTheAmount.setBackground(new Color(230, 245, 254));
        lblEnterTheAmount.setBounds(29, 208, 342, 84); 
        panel_1.add(lblEnterTheAmount);

    }
}