package DepositGUI;

import CheckBalanceGUI.Account_Statement;
import CheckBalanceGUI.TransactionService;
import GUI.Home;

import javax.swing.*;
import java.awt.*;

public class Deposit extends JFrame {
    private JTextField textFieldAmount;
    private TransactionService transactionService;

    public Deposit(Account_Statement accountStatement, TransactionService service) {
        this.transactionService = service;

        getContentPane().setBackground(new Color(230, 245, 255));
        setTitle("Deposit");
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

        JLabel lblDeposit = new JLabel("Deposit");
        lblDeposit.setForeground(new Color(0, 78, 168));
        lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 50));
        lblDeposit.setBounds(135, 90, 192, 80);
        getContentPane().add(lblDeposit);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 78, 168));
        panel.setBounds(70, 205, 320, 140);
        getContentPane().add(panel);
        panel.setLayout(null);

        textFieldAmount = new JTextField();
        textFieldAmount.setBounds(26, 64, 268, 26);
        panel.add(textFieldAmount);
        textFieldAmount.setColumns(10);

        JLabel lblEnterAmount = new JLabel("Enter the Amount to Deposit");
        lblEnterAmount.setForeground(new Color(230, 245, 254));
        lblEnterAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEnterAmount.setBounds(66, 28, 187, 19);
        panel.add(lblEnterAmount);

        JButton btnEnter = new JButton("Enter");
        btnEnter.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(textFieldAmount.getText());
                transactionService.addDeposit(amount); // Push deposit into the shared Account_Statement
                JOptionPane.showMessageDialog(null, "Deposit processed: " + amount);
                accountStatement.show(); // Show the updated Account_Statement
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
        Deposit depositFrame = new Deposit(accountStatement, transactionService);
        depositFrame.setVisible(true);
    }
}
