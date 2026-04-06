import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import Enums.AccountType;
import Model.*;
import Services.*;

public class Main {
    public static void main(String args[]) {
        // System.out.println("Project starts..");
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
        BankAccount b1 = new BankAccount(AccountType.CURRENT, 4004, 20000.0);
        BankAccount b2 = new BankAccount(AccountType.SAVING, 5005, 19000);

        try{
            String depositedResult = accountService.deposit(b1, 1800);
            System.out.println(depositedResult);
            System.out.println();
        }
        catch(Exception e){
            System.out.println(e);
        }

        try {
            String withdrawnResult = accountService.withdraw(b1, 2000);
            System.out.println(withdrawnResult);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }

        String checkBalanceResult = accountService.checkBankBalance(b1);
        System.out.println(checkBalanceResult);
        System.out.println();

        // System.out.println("For Amount Transfer ");
        try {
            String transferResult = accountService.transfer(b1, b2, 10000);
            System.out.println(transferResult);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }

        transactionService.showAllTransactions(b1);
        transactionService.showAllTransactions(b2);

        try{
            List<Transaction> transactions = transactionService.lastNTransactions(b1, 2);
            System.out.println("------ Last 2 Transactions------------");
            for(Transaction t : transactions){
                System.out.println("Found Transaction of type " + t.getTransactionType() + " of amount " + t.getTransactionAmount());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println();
        List<Transaction> ts = transactionService.transactionBetweenDates(b1, LocalDate.of(2026, 04, 02), LocalDate.of(2026, 04, 03));
        for(Transaction transaction : ts){
            System.out.println("Transaction of type " + transaction.getTransactionType() + " of amount " + transaction.getTransactionAmount());
        }

        System.out.println();
        List<Transaction> highTransaction = transactionService.highValueTransaction(b1, 2000);
        System.out.println("----------- High Value Transactons -------------");
        for(Transaction transaction : highTransaction){
            System.out.println("Transaction of type " + transaction.getTransactionType() + " of amount " + transaction.getTransactionAmount());
        }

        System.out.println();
        // System.out.println(" -----------show all transaction of bank Account ----------------");
        transactionService.showAllTransactions(b1);

        System.out.println();
        System.out.println("-----------Average Amount of the Transaction-----------");
        double averageValue = transactionService.getAverageTransactionAmount(b1);
        System.out.println(averageValue);

        System.out.println();
        System.out.println("----------------- Total Expense--------------");
        double totalAmount = transactionService.getTotalExpenses(b1);
        System.out.println(totalAmount);
    }
}