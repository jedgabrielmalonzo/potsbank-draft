package CheckBalanceGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Account_Statement {
    private JFrame frmAccountStatement;
    private JTable table;
    private DefaultTableModel tableModel;

    public Account_Statement() {
        initialize();
    }

    private void initialize() {
        frmAccountStatement = new JFrame();
        frmAccountStatement.getContentPane().setBackground(new Color(230, 245, 255));
        frmAccountStatement.setTitle("Account Statement");
        frmAccountStatement.setBounds(100, 100, 1198, 528);
        frmAccountStatement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAccountStatement.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(57, 75, 719, 355);
        frmAccountStatement.getContentPane().add(scrollPane);

        table = new JTable();
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Balance", "Deposit", "Withdrawal", "Date" }
        );
        table.setModel(tableModel);
        scrollPane.setViewportView(table);

        JLabel lblAccountStatement = new JLabel("Account Statement");
        lblAccountStatement.setForeground(new Color(8, 76, 172));
        lblAccountStatement.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblAccountStatement.setBounds(286, 0, 294, 80);
        frmAccountStatement.getContentPane().add(lblAccountStatement);
    }

    /**
     * Makes the Account Statement window visible and ensures it updates.
     */
   
    	public void show() {
    	    System.out.println("Account_Statement is now visible!");
    	    frmAccountStatement.setVisible(true);
    	    refreshTable();
    	}
    

    /**
     * Refreshes the account statement table UI.
     */
    public void refreshTable() {
        table.revalidate(); // Ensures table structure is up-to-date
        table.repaint();    // Forces the table to redraw itself
    }

    /**
     * Returns the table model for adding transactions.
     */
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Account_Statement accountStatement = new Account_Statement();
                accountStatement.show(); // Ensure this makes the frame visible
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
	
}
