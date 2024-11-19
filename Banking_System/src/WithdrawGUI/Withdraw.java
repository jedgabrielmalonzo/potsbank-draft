package WithdrawGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.Home;

import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Withdraw {

	private JFrame frmWithdraw;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
					window.frmWithdraw.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Withdraw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWithdraw = new JFrame();
		frmWithdraw.getContentPane().setBackground(new Color(229, 245, 255));
		frmWithdraw.setTitle("Withdraw");
		frmWithdraw.setBounds(100, 100, 876, 540);
		frmWithdraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWithdraw.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0,78,168));
		panel.setBounds(70, 205, 320, 140);
		frmWithdraw.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(229, 245, 255));
		textField.setBounds(26, 64, 268, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterTheAmount = new JLabel("Enter the Amount to Withdraw");
		lblEnterTheAmount.setForeground(new Color(230,245,255));
		lblEnterTheAmount.setBounds(60, 28, 199, 19);
		panel.add(lblEnterTheAmount);
		lblEnterTheAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Enter\r\n");
		btnNewButton.setForeground(new Color(0, 78, 168));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(115, 106, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(new Color(0,78,168));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Home home = new Home();
		        home.setVisible(true); 
		        frmWithdraw.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 11, 89, 23);
		frmWithdraw.getContentPane().add(btnNewButton_1);
		
		JLabel lblWithdraw = new JLabel("Withdraw\r\n");
		lblWithdraw.setForeground(new Color(0, 78, 168));
		lblWithdraw.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblWithdraw.setBounds(114, 90, 246, 80);
		frmWithdraw.getContentPane().add(lblWithdraw);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 78, 168));
		panel_1.setBounds(460, 0, 400, 501);
		frmWithdraw.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Welcome to PotsBank");
		lblNewLabel.setForeground(new Color(230, 245, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(39, 77, 331, 37);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Your Trust, Our Commitment");
		lblNewLabel_1.setForeground(new Color(252, 183, 21));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(90, 115, 219, 35);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblEnterTheAmount_1 = new JLabel("<html>To complete your withdrawal, simply enter the amount you wish to withdraw and confirm.<br>Once submitted, you'll receive a confirmation message.</html>\r\n");
		lblEnterTheAmount_1.setForeground(new Color(230, 245, 254));
		lblEnterTheAmount_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterTheAmount_1.setBackground(new Color(230, 245, 254));
		lblEnterTheAmount_1.setBounds(44, 208, 312, 84);
		panel_1.add(lblEnterTheAmount_1);
	}
}