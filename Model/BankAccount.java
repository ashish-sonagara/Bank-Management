package Model;
import java.util.ArrayList;
import java.util.List;
import Enums.AccountType;

public class BankAccount {
    private AccountType accountType;
    private int accountNumber;
    private double currentBalance;
    private List<Transaction> transactionHistory = new ArrayList<Transaction>();

    public BankAccount(AccountType accountType, int accountNumber , double currentBalance){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.currentBalance = currentBalance;   
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    
    public AccountType getAccountType() {
        return accountType;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void setTransactionHistory(List<Transaction> transactionHistory) {
        this.transactionHistory.addAll(transactionHistory);
    }

}
