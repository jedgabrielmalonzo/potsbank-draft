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

        JButton btnCheckBalance = new JButton("Check Current Balance");
        btnCheckBalance.setBackground(Color.WHITE);
        btnCheckBalance.setForeground(new Color(0, 78, 168));
        btnCheckBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkPin();
            }
        });
        btnCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnCheckBalance.setBounds(495, 252, 311, 78);
        frmCheckBalance.getContentPane().add(btnCheckBalance);

        JButton btnBankStatement = new JButton("Check Bank Statement");
        btnBankStatement.setForeground(new Color(0, 78, 168));
        btnBankStatement.setBackground(Color.WHITE);
        btnBankStatement.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnBankStatement.setBounds(76, 252, 311, 78);
        frmCheckBalance.getContentPane().add(btnBankStatement);
        btnBankStatement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkPin();
            }
        });

        JLabel lblCheckBalance = new JLabel("Check Balance");
        lblCheckBalance.setForeground(new Color(0,78,168));
        lblCheckBalance.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblCheckBalance.setBounds(284, 115, 292, 78);
        frmCheckBalance.getContentPane().add(lblCheckBalance);

        JButton btnHome = new JButton("Home");
        btnHome.setBackground(Color.WHITE);
        btnHome.setForeground(new Color(0, 78, 168));
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnHome.setBounds(10, 23, 89, 23);
        frmCheckBalance.getContentPane().add(btnHome);
        
        JLabel lblNewLabel = new JLabel("Welcome to PotsBank");
        lblNewLabel.setForeground(new Color(0,78,168));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(264, 23, 331, 37);
        frmCheckBalance.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Your Trust, Our Commitment");
        lblNewLabel_1.setForeground(new Color(252, 183, 21));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblNewLabel_1.setBounds(320, 57, 219, 35);
        frmCheckBalance.getContentPane().add(lblNewLabel_1);
    }

    private void checkPin() {
        
        String pin = JOptionPane.showInputDialog(frmCheckBalance, "Please enter your four-digit PIN:");

        
        if (pin != null) {
            if (pin.length() == 5) {
                JOptionPane.showMessageDialog(frmCheckBalance, "PIN accepted. Please continue.");
            } else {
                JOptionPane.showMessageDialog(frmCheckBalance, "Error: PIN must be 5 digits.", "Invalid PIN", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}