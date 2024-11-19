package GUI;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.SwingConstants;

import CheckBalanceGUI.Account_Statement;
import DepositGUI.Deposit;
import WithdrawGUI.Withdraw;

public class Home extends JFrame {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home window = new Home();
                    window.setVisible(true);  // Set the visibility of this JFrame
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Home() {
    	getContentPane().setBackground(new Color(230, 245, 254));
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Initialize this JFrame directly
        setTitle("Home");
        setBounds(100, 100, 876, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // "Deposit" button to open Deposit window
        JButton btnNewButton = new JButton("Deposit");
        btnNewButton.setBackground(new Color(252, 183, 21));
        btnNewButton.setForeground(new Color(0, 78, 168));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Deposit.main(new String[0]);  
                dispose();  
            }
        });
        btnNewButton.setBounds(498, 174, 204, 54);
        getContentPane().add(btnNewButton);

        // "Withdraw" button
        JButton btnNewButton_1 = new JButton("Withdraw");
        btnNewButton_1.setBackground(new Color(252, 183, 21));
        btnNewButton_1.setForeground(new Color(0, 78, 168));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
               Withdraw.main(new String[0]);  
                dispose();  
            }
        });
        btnNewButton_1.setBounds(498, 239, 201, 54);
        getContentPane().add(btnNewButton_1);

        // "Account Statement" button
        JButton btnAccountStatement = new JButton("Check Balance");
        btnAccountStatement.setBackground(new Color(252, 183, 21));
        btnAccountStatement.setForeground(new Color(0, 78, 168));
        btnAccountStatement.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                Account_Statement.main(new String[0]);  
                 dispose();  
             }
        });
        btnAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnAccountStatement.setBounds(498, 314, 204, 54);
        getContentPane().add(btnAccountStatement);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 78, 168));
        panel.setBounds(0, 0, 363, 501);
        getContentPane().add(panel);
        panel.setLayout(null);
                
                JLabel lblNewLabel_2_1_1 = new JLabel("<html>What would you</html>");
                lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_2_1_1.setForeground(Color.WHITE);
                lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 35));
                lblNewLabel_2_1_1.setBounds(33, 11, 298, 107);
                panel.add(lblNewLabel_2_1_1);
                
                JLabel lblNewLabel_2_1_1_1 = new JLabel("<html>like to do?</html>");
                lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
                lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 35));
                lblNewLabel_2_1_1_1.setBounds(33, 65, 298, 107);
                panel.add(lblNewLabel_2_1_1_1);
                
                JLabel lblNewLabel_2_1_1_2 = new JLabel("<html>Choose an action from the options on the right to manage your account:<br><br>Deposit: Add money to your account securely.<br><br>Withdraw: Withdraw funds from your account.<br><br>Check Balance: View your current account balance.<br><br>Change Pin: Update your PIN for added security.<br><br>");
                lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
                lblNewLabel_2_1_1_2.setForeground(Color.WHITE);
                lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
                lblNewLabel_2_1_1_2.setBounds(55, 158, 256, 306);
                panel.add(lblNewLabel_2_1_1_2);
        
        JButton btnChangePin = new JButton("Change Pin");
        btnChangePin.setBackground(new Color(252, 183, 21));
        btnChangePin.setForeground(new Color(0, 78, 168));
        btnChangePin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnChangePin.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnChangePin.setBounds(498, 379, 204, 54);
        getContentPane().add(btnChangePin);
        
        JLabel lblNewLabel_2 = new JLabel("Welcome to PotsBank");
        lblNewLabel_2.setBounds(441, 26, 331, 37);
        getContentPane().add(lblNewLabel_2);
        lblNewLabel_2.setForeground(new Color(0, 78, 168));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        
                JLabel lblNewLabel_1 = new JLabel("Your Trust, Our Commitment");
                lblNewLabel_1.setBounds(505, 62, 197, 35);
                getContentPane().add(lblNewLabel_1);
                lblNewLabel_1.setForeground(new Color(245,185,19));
                lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
    }
}