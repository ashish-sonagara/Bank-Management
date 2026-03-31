package Services;

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
        bankAccount.currentBalance += amount;
        Transaction t = new Transaction(TransactionType.DEPOSIT, "+"+amount , r.nextInt(1,1001));
        bankAccount.transactionHistory.add(t);
        return amount + " deposited in the " + bankAccount.accountNumber;
    }

    public String withdraw(BankAccount bankAccount, double amount) throws InsufficientBalanceException {
        if (bankAccount.currentBalance < amount) {
            throw new InsufficientBalanceException("Withdrawn Amount is greater than the Current Bank balance");
        } else {
            bankAccount.currentBalance -= amount;
            Transaction t = new Transaction(TransactionType.WITHDRAW, "-"+amount, r.nextInt(1,1001));
            bankAccount.transactionHistory.add(t);
            return amount + " withdrawn from the " + bankAccount.accountNumber;
        }
    }

    public String checkBankBalance(BankAccount bankAccount) {
        return "Bank Account with account number " + bankAccount.accountNumber + " has current balance " + bankAccount.currentBalance;
    }

    public String transfer(BankAccount bankAccount1, BankAccount bankAccount2, double amount) throws InsufficientBalanceException{
        if(amount > bankAccount1.currentBalance){
            throw new InsufficientBalanceException("Cant transfer the Given amount as it lesser than the Current Balance");
        }
        bankAccount1.currentBalance -= amount;
        Transaction t1 = new Transaction(TransactionType.TRANSFER, "-"+amount , r.nextInt(1,1001));
        bankAccount1.transactionHistory.add(t1);

        if(amount > 10000){
            bankAccount1.currentBalance += amount;
            Transaction back = new Transaction(TransactionType.TRANSFER, "+"+amount ,r.nextInt(1,1001));
            bankAccount1.transactionHistory.add(back);
            throw new InvalidAmountException("Transaction Beyond 10000 is not possible");
        }
        bankAccount2.currentBalance += amount;
        Transaction t2 = new Transaction(TransactionType.TRANSFER, "+"+amount , r.nextInt(1,1001));
        bankAccount2.transactionHistory.add(t2);

        // withdraw(bankAccount2, amount);
        // this.deposit(bankAccount2, amount);

        return "Transferred " + amount + " from Bank Account " + bankAccount1.accountNumber + " to " + bankAccount2.accountNumber;
    }

}
