package WithdrawGUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import CheckBalanceGUI.Account_Statement;
import CheckBalanceGUI.TransactionService;
import GUI.Home;

public class Withdraw extends JFrame {
    private JTextField textFieldAmount;
    private TransactionService transactionService;

    public Withdraw(Account_Statement accountStatement, TransactionService service) {
        transactionService = service;

        getContentPane().setBackground(new Color(229, 245, 255));
        setTitle("Withdraw");
        setBounds(100, 100, 876, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnHome = new JButton("Home");
        btnHome.setBackground(new Color(252, 183, 21));
        btnHome.setForeground(new Color(0, 78, 168));
        btnHome.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnHome.addActionListener(e -> {
            Home.main(new String[0]);
            dispose();
        });
        btnHome.setBounds(10, 10, 100, 30);
        getContentPane().add(btnHome);

        JLabel lblWithdraw = new JLabel("Withdraw");
        lblWithdraw.setForeground(new Color(0, 78, 168));
        lblWithdraw.setFont(new Font("Tahoma", Font.BOLD, 50));
        lblWithdraw.setBounds(114, 90, 246, 80);
        getContentPane().add(lblWithdraw);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 78, 168));
        panel.setBounds(70, 205, 320, 140);
        getContentPane().add(panel);
        panel.setLayout(null);

        textFieldAmount = new JTextField();
        textFieldAmount.setBounds(26, 64, 268, 26);
        panel.add(textFieldAmount);
        textFieldAmount.setColumns(10);

        JLabel lblEnterAmount = new JLabel("Enter the Amount to Withdraw");
        lblEnterAmount.setForeground(new Color(230, 245, 254));
        lblEnterAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEnterAmount.setBounds(60, 28, 199, 19);
        panel.add(lblEnterAmount);

        JButton btnEnter = new JButton("Enter");
        btnEnter.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(textFieldAmount.getText());

                // Process withdrawal through TransactionService
                boolean success = transactionService.addWithdrawal(amount);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Withdrawal processed: " + amount);
                    accountStatement.show(); // Show updated Account_Statement
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds for withdrawal.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid amount.");
            }
        });
        btnEnter.setBounds(115, 106, 89, 23);
        panel.add(btnEnter);
    }

    public static void main(String[] args) {
        Account_Statement accountStatement = new Account_Statement();
        TransactionService transactionService = new TransactionService(accountStatement);
        Withdraw withdrawFrame = new Withdraw(accountStatement, transactionService);
        withdrawFrame.setVisible(true);
    }
}
