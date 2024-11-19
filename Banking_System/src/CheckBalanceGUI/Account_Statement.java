package CheckBalanceGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import GUI.Home;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class Account_Statement {

	private JFrame frmAccountStatement;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lbltheAccountStatement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_Statement window = new Account_Statement();
					window.frmAccountStatement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Account_Statement() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccountStatement = new JFrame();
		frmAccountStatement.getContentPane().setBackground(new Color(230, 245, 255));
		frmAccountStatement.setTitle("Account Statement\r\n");
		frmAccountStatement.setBounds(100, 100, 1198, 528);
		frmAccountStatement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccountStatement.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 75, 719, 355);
		frmAccountStatement.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Balance", "Deposit", "Withdrawal", "Date"
			}
		));
		String[] options = {"Sort by Date" , "Sort by Amount"};
		comboBox = new JComboBox(options);
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(new Color(0, 78, 168));
		comboBox.setBounds(197, 441, 179, 22);
		frmAccountStatement.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Generate Account Statement");
		btnNewButton.setForeground(new Color(0, 78, 168));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(442, 441, 205, 23);
		frmAccountStatement.getContentPane().add(btnNewButton);
		
		JLabel lblAccountStatement = new JLabel("Account Statement");
		lblAccountStatement.setForeground(new Color(8, 76, 172));
		lblAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAccountStatement.setBounds(286, 0, 294, 80);
		frmAccountStatement.getContentPane().add(lblAccountStatement);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setForeground(new Color(8, 76, 172));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Home home = new Home();
			        home.setVisible(true); 
			        frmAccountStatement.dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(56, 37, 89, 23);
		frmAccountStatement.getContentPane().add(btnNewButton_1);
		
		panel = new JPanel();
		panel.setBackground(new Color(0,78,168));
		panel.setBounds(806, 0, 376, 494);
		frmAccountStatement.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Welcome to PotsBank");
		lblNewLabel.setBounds(22, 22, 331, 37);
		lblNewLabel.setForeground(new Color(230, 245, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Your Trust, Our Commitment");
		lblNewLabel_1.setForeground(new Color(252, 183, 21));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(81, 70, 219, 35);
		panel.add(lblNewLabel_1);
		
		lbltheAccountStatement = new JLabel("<html>The Account Statement feature allows you to sort transactions by date or amount, making it easy to organize and view your account activity.</html>");
		lbltheAccountStatement.setForeground(new Color(230, 245, 254));
		lbltheAccountStatement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltheAccountStatement.setBackground(new Color(230, 245, 254));
		lbltheAccountStatement.setBounds(24, 177, 342, 67);
		panel.add(lbltheAccountStatement);
	}
}