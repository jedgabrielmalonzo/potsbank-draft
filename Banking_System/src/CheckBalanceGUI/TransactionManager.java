package CheckBalanceGUI;

import java.util.LinkedList;
import java.util.Queue;

public class TransactionManager {
    private static TransactionManager instance; // Singleton instance
    private Queue<QueuedTransaction> transactionQueue; // Queue for transactions
    private double currentBalance; // Current account balance
    private int userPin;

    public TransactionManager(double initialBalance) {
        this.transactionQueue = new LinkedList<>();
        this.currentBalance = initialBalance;
    }
    
    public static TransactionManager getInstance(double initialBalance) {
        if (instance == null) {
            instance = new TransactionManager(initialBalance);
        }
        return instance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0!");
            return;
        }
        transactionQueue.add(new QueuedTransaction("Deposit", amount)); // Add deposit to queue
        currentBalance += amount; // Update the current balance
        processTransactions(); // Process transactions in the queue
    }
    public int getCurrentUserPin() {
        return userPin; // Return the actual user's PIN
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0!");
            return;
        }
        if (currentBalance >= amount) {
            transactionQueue.add(new QueuedTransaction("Withdraw", amount)); // Add withdrawal to queue
            currentBalance -= amount; // Update the current balance
            processTransactions(); // Process transactions in the queue
        } else {
            System.out.println("Insufficient balance for withdrawal!");
        }
    }

    private void processTransactions() {
        while (!transactionQueue.isEmpty()) {
            QueuedTransaction transaction = transactionQueue.poll(); // Remove transaction from queue

            if (transaction.getType().equals("Deposit")) {
                Account_Statement_Database.insertAccountstatement(currentBalance, transaction.getAmount(), 0, System.currentTimeMillis());
            } else if (transaction.getType().equals("Withdraw")) {
                Account_Statement_Database.insertAccountstatement(currentBalance, 0, transaction.getAmount(), System.currentTimeMillis());
            }

            System.out.println("Processed: " + transaction.getType() + " of " + transaction.getAmount());
        }
    }

    public double getCurrentBalance() {
        return currentBalance; // Return the current balance
    }
}

// Transaction class for queue management
class QueuedTransaction {
    private String type; // Type of transaction: Deposit or Withdraw
    private double amount; // Transaction amount

    public QueuedTransaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}