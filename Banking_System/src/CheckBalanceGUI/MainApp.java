package CheckBalanceGUI;

import CheckBalanceGUI.TransactionManager;
import CheckBalanceGUI.Account_Statement;
import DepositGUI.Deposit;
import WithdrawGUI.Withdraw;

import java.awt.EventQueue;

public class MainApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            double initialBalance = Account_Statement_Database.getCurrentBalance(); // Fetch balance from DB
            TransactionManager transactionManager = TransactionManager.getInstance(initialBalance);
            Account_Statement accountStatement = new Account_Statement();

            // Launch Deposit Window
            new Deposit(transactionManager, accountStatement);

            // Launch Withdraw Window
            new Withdraw(transactionManager, accountStatement);
        });
    }
}