package Model;
import java.util.ArrayList;
import java.util.List;
import Enums.AccountType;

public class BankAccount {
    public AccountType accountType;
    public int accountNumber;
    public double currentBalance;
    public List<Transaction> transactionHistory = new ArrayList<Transaction>();

    public BankAccount(AccountType accountType, int accountNumber , double currentBalance){
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.currentBalance = currentBalance;   
    }
}
