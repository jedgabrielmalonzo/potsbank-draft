package CheckBalanceGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CurrentBalance {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentBalance window = new CurrentBalance();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrentBalance() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 245, 254));
		frame.setBounds(100, 100, 876, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance");
		lblCurrentBalance.setForeground(new Color(0, 78, 168));
		lblCurrentBalance.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblCurrentBalance.setBounds(307, 1, 245, 80);
		frame.getContentPane().add(lblCurrentBalance);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(new Color(0, 78, 168));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(58, 33, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 73, 720, 355);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Balance", "Date"
			}
		));
	}
}