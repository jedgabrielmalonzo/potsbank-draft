package CheckBalanceGUI;

import java.sql.Timestamp;

public class Transaction {
    private double balance;
    private double deposit;
    private double withdrawal;
    private Timestamp date;

    public Transaction(double balance, double deposit, double withdrawal, Timestamp date) {
        this.balance = balance;
        this.deposit = deposit;
        this.withdrawal = withdrawal;
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public double getDeposit() {
        return deposit;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public Timestamp getDate() {
        return date;
    }
}