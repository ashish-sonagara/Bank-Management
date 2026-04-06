package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enums.TransactionType;
import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidAmountException;
import Model.*;

public class AccountService {
    Random r= new Random();

    public String deposit(BankAccount bankAccount, double amount) throws InvalidAmountException {
        if (amount > 10000) {
            throw new InvalidAmountException("Cannot Deposit Amount greater than 10000");
        }
        double currBalance = bankAccount.getCurrentBalance();
        currBalance += amount;
        bankAccount.setCurrentBalance(currBalance);
        Transaction t = new Transaction(TransactionType.DEPOSIT, "+"+amount , r.nextInt(1,1001));
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(t);
        bankAccount.setTransactionHistory(transactions);
        return amount + " deposited in the " + bankAccount.getAccountNumber();
    }

    public String withdraw(BankAccount bankAccount, double amount) throws InsufficientBalanceException {
        if (bankAccount.getCurrentBalance() < amount) {
            throw new InsufficientBalanceException("Withdrawn Amount is greater than the Current Bank balance");
        } else {
            double currBalance = bankAccount.getCurrentBalance();
            currBalance -= amount;
            bankAccount.setCurrentBalance(currBalance);
            Transaction t = new Transaction(TransactionType.WITHDRAW, "-" + amount, r.nextInt(1, 1001));
            List<Transaction> transactions = new ArrayList<>();
            transactions.add(t);
            bankAccount.setTransactionHistory(transactions);
            return amount + " withdrawn from the " + bankAccount.getAccountNumber();
        }
    }

    public String checkBankBalance(BankAccount bankAccount) {
        return "Bank Account with account number " + bankAccount.getAccountNumber() + " has current balance " + bankAccount.getCurrentBalance();
    }

    public String transfer(BankAccount bankAccount1, BankAccount bankAccount2, double amount) throws InsufficientBalanceException{
        if(amount > bankAccount1.getCurrentBalance()){
            throw new InsufficientBalanceException("Cant transfer the Given amount as it lesser than the Current Balance");
        }
        double currBalanceAccount1 = bankAccount1.getCurrentBalance();
        currBalanceAccount1 -= amount;
        bankAccount1.setCurrentBalance(currBalanceAccount1);
        Transaction t1 = new Transaction(TransactionType.TRANSFER, "-"+amount , r.nextInt(1,1001));
        List<Transaction> transactions1 = new ArrayList<>();
        transactions1.add(t1);
        bankAccount1.setTransactionHistory(transactions1);

        if(amount > 10000){
            double currBalanceError = bankAccount1.getCurrentBalance();
            bankAccount1.setCurrentBalance(currBalanceError + amount);
            Transaction back = new Transaction(TransactionType.TRANSFER, "+"+amount ,r.nextInt(1,1001));
            List<Transaction> backTransactions = new ArrayList<>();
            backTransactions.add(back);
            bankAccount1.setTransactionHistory(backTransactions);
            throw new InvalidAmountException("Transaction Beyond 10000 is not possible");
        }
        double currBalanceAccount2 = bankAccount2.getCurrentBalance();
        bankAccount2.setCurrentBalance(currBalanceAccount2 + amount);
        Transaction t2 = new Transaction(TransactionType.TRANSFER, "+"+amount , r.nextInt(1,1001));
        List<Transaction> transactions2 = new ArrayList<>();
        transactions2.add(t2);
        bankAccount2.setTransactionHistory(transactions2);

        return "Transferred " + amount + " from Bank Account " + bankAccount1.getAccountNumber() + " to " + bankAccount2.getAccountNumber();
    }

}
