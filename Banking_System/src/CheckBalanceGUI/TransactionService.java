package CheckBalanceGUI;

import java.util.LinkedList;
import java.util.Queue;

public class TransactionService {
    private Account_Statement accountStatement;
    private Queue<Transaction> transactionQueue;

    public TransactionService(Account_Statement accountStatement) {
        this.accountStatement = accountStatement;
        this.transactionQueue = new LinkedList<>();
    }

  
    public void addDeposit(double amount) {
        Transaction transaction = new Transaction("deposit", amount);
        transactionQueue.add(transaction);
        processTransaction();  
    }

   
    public void processTransaction() {
        if (!transactionQueue.isEmpty()) {
            Transaction transaction = transactionQueue.poll();  

            if (transaction.getType().equals("deposit")) {
                
                double newBalance = accountStatement.getBalance() + transaction.getAmount();
                accountStatement.updateBalance(newBalance, transaction.getAmount());
                System.out.println("Deposit processed: " + transaction.getAmount());
            } else if (transaction.getType().equals("withdrawal")) {
                
                double newBalance = accountStatement.getBalance() - transaction.getAmount();
                accountStatement.updateBalance(newBalance, 0);
                System.out.println("Withdrawal processed: " + transaction.getAmount());
            }
        }
    }

	
}
