package Services;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
// import java.util.List;
import java.time.*;
import Exceptions.InvalidTransactionException;
import Model.BankAccount;
import Model.Transaction;
import Enums.*;

public class TransactionService implements ITransactionService{
    
    @Override
    public void showAllTransactions(BankAccount bankAccount){
        System.out.println("-------- Transaction of " + bankAccount.getAccountNumber() + "-----------");
        for (Transaction t : bankAccount.getTransactionHistory()){
            System.out.println("Transaction of type " + t.getTransactionType() + " of amount " + t.getTransactionAmount() + " on Date " + t.getDate());
        }
        System.out.println();
    }

    @Override
    public void searchTransaction(BankAccount bankAccount , int transactionId){
        boolean isTransactionFound = false;
        for (Transaction t : bankAccount.getTransactionHistory()){
            if (t.getTransactionId() == transactionId){
                System.out.println("Found Transaction of type " + t.getTransactionType() + " of amount " + t.getTransactionAmount());
                System.out.println();
                isTransactionFound = true;
            }
        }

        if(!isTransactionFound){
            System.out.println("No Transaction with such transaction ID " + transactionId + " found." );
        }
    }

    @Override
    public List<Transaction> lastNTransactions(BankAccount bankAccount, int n) throws InvalidTransactionException {
        int noOfTransaction = bankAccount.getTransactionHistory().size();
        if(noOfTransaction < n){
            throw new InvalidTransactionException("Number of Transaction in your Bank Account is Lesser than U are asking for!");
        } 
        List <Transaction> transactions = new ArrayList<Transaction>();
        int length = bankAccount.getTransactionHistory().size() - 1;
        for (int i = length ; n > 0 ; i-- ){
            Transaction t = bankAccount.getTransactionHistory().get(i);
            transactions.add(t);
            n -= 1;
        }

        return transactions;
    }

    @Override
    public List<Transaction> transactionBetweenDates(BankAccount bankAccount , LocalDate a , LocalDate b){
        List<Transaction> transactions = new ArrayList<>();
        bankAccount.getTransactionHistory().forEach( transaction -> {
            if ((transaction.getDate().isAfter(a) || transaction.getDate().isEqual(a)) &&
                    (transaction.getDate().isBefore(b) || transaction.getDate().isEqual(b))) {
                transactions.add(transaction);
            }
        });
        return transactions;
    }

    @Override
    public List<Transaction> highValueTransaction(BankAccount bankAccount , double value){
        List<Transaction> transactions = new ArrayList<>();

        // bankAccount.getTransactionHistory().forEach( transaction -> {
        //     if (Double.parseDouble(transaction.getTransactionAmount().substring(1)) >= value) {
        //         transactions.add(transaction);
        //     }
        // });
        transactions = bankAccount.getTransactionHistory().stream()
                .filter(t -> Double.parseDouble(t.getTransactionAmount().substring(1)) > value)
                .toList();

        return transactions;
    }

    @Override
    public List<Transaction> filterByType(BankAccount bankAccount , TransactionType transactionType ){
        List<Transaction> transactions = new ArrayList<>();

        // bankAccount.getTransactionHistory().forEach( transaction -> {
        // if (transaction.getTransactionType() == transactionType){
        //         transactions.add(transaction);
        //     }
        // });
        transactions = bankAccount.getTransactionHistory().stream()
                        .filter( t -> t.getTransactionType() == transactionType)
                        .toList();
        return transactions;
    }

    @Override
    public double getTotalExpenses(BankAccount bankAccount){
        double totalExpense = 0;

        // for(Transaction t : bankAccount.getTransactionHistory()){
        //     totalExpense += Double.parseDouble(t.getTransactionAmount().substring(1));
        // }
        
        DoubleStream number = bankAccount.getTransactionHistory().stream()
            .mapToDouble( t -> Double.parseDouble(t.getTransactionAmount().substring(1))); 
            
        totalExpense = number.sum();

        return totalExpense;
    }

    @Override
    public double getAverageTransactionAmount(BankAccount bankAccount) {
        double averageExpense = 0;
        double totalExpense = 0;
        int transactionHistoryLength  = 0;

        // for(Transaction t : bankAccount.getTransactionHistory()){
        //     totalExpense += Double.parseDouble(t.getTransactionAmount().substring(1));
        // }
   
        DoubleStream numbers = bankAccount.getTransactionHistory().stream()
                .mapToDouble(t -> Double.parseDouble(t.getTransactionAmount().substring(1)));

        totalExpense = numbers.sum();
        transactionHistoryLength = bankAccount.getTransactionHistory().size();
        averageExpense = totalExpense / transactionHistoryLength;

        return averageExpense;
    }
}
