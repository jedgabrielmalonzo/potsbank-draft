package CheckBalanceGUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;
import CheckBalanceGUI.Account_Statement;
import GUI.Home;  // Import the Home class

public class Check_Balance {

    private JFrame frmCheckBalance;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Check_Balance window = new Check_Balance();
                    window.frmCheckBalance.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Check_Balance() {
        initialize();
    }

    private void initialize() {
        frmCheckBalance = new JFrame();
        frmCheckBalance.getContentPane().setBackground(new Color(230, 245, 255));
        frmCheckBalance.setTitle("Check Balance");
        frmCheckBalance.setBounds(100, 100, 876, 540);
        frmCheckBalance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCheckBalance.getContentPane().setLayout(null);

        // "Check Current Balance" button
        JButton btnCheckBalance = new JButton("Check Current Balance");
        btnCheckBalance.setBackground(Color.WHITE);
        btnCheckBalance.setForeground(new Color(0, 78, 168));
        btnCheckBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	CurrentBalance.main(new String[0]); 
            }
        });
        btnCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnCheckBalance.setBounds(495, 252, 311, 78);
        frmCheckBalance.getContentPane().add(btnCheckBalance);

        // "Check Bank Statement" button
        JButton btnBankStatement = new JButton("Check Bank Statement");
        btnBankStatement.setForeground(new Color(0, 78, 168));
        btnBankStatement.setBackground(Color.WHITE);
        btnBankStatement.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnBankStatement.setBounds(76, 252, 311, 78);
        frmCheckBalance.getContentPane().add(btnBankStatement);
        btnBankStatement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 Account_Statement.main(new String[0]); 
            }
        });

        // Title Label
        JLabel lblCheckBalance = new JLabel("Check Balance");
        lblCheckBalance.setForeground(new Color(0, 78, 168));
        lblCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblCheckBalance.setBounds(284, 115, 292, 78);
        frmCheckBalance.getContentPane().add(lblCheckBalance);

        // Home Button
        JButton btnHome = new JButton("Home");
        btnHome.setBackground(Color.WHITE);
        btnHome.setForeground(new Color(0, 78, 168));
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnHome.setBounds(10, 23, 89, 23);
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Home.main(new String[0]); 
                frmCheckBalance.dispose(); 
            }
        });
        frmCheckBalance.getContentPane().add(btnHome);

        // Welcome Label
        JLabel lblNewLabel = new JLabel("Welcome to PotsBank");
        lblNewLabel.setForeground(new Color(0, 78, 168));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(264, 23, 331, 37);
        frmCheckBalance.getContentPane().add(lblNewLabel);

        // Subtitle Label
        JLabel lblNewLabel_1 = new JLabel("Your Trust, Our Commitment");
        lblNewLabel_1.setForeground(new Color(252, 183, 21));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblNewLabel_1.setBounds(320, 57, 219, 35);
        frmCheckBalance.getContentPane().add(lblNewLabel_1);
    }

 
}
