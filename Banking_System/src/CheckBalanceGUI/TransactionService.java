package CheckBalanceGUI;

import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class TransactionService {
    private Account_Statement accountStatement;

    public TransactionService(Account_Statement accountStatement) {
        this.accountStatement = accountStatement;
    }

   
    public void addDeposit(double amount) {
        double currentBalance = getCurrentBalance();
        currentBalance += amount;
        updateAccountStatement(currentBalance, amount, 0); 
    }

    
    public boolean addWithdrawal(double amount) {
        double currentBalance = getCurrentBalance();

        
        if (amount > currentBalance) {
            return false; 
        }

        currentBalance -= amount; 
        updateAccountStatement(currentBalance, 0, amount); 
        return true; 
    }

  
    private double getCurrentBalance() {
        DefaultTableModel model = accountStatement.getTableModel();

        if (model.getRowCount() == 0) {
            return 0.0; 
        }

      
        return (double) model.getValueAt(model.getRowCount() - 1, 0);
    }

   
    private void updateAccountStatement(double balance, double deposit, double withdrawal) {
        DefaultTableModel model = accountStatement.getTableModel();
        model.addRow(new Object[]{balance, deposit, withdrawal, new Date()});
        accountStatement.refreshTable(); 
    }
}
