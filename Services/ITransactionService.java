package Services;

import java.time.LocalDate;
import java.util.List;

import Enums.TransactionType;
import Exceptions.InvalidTransactionException;
import Model.BankAccount;
import Model.Transaction;

public interface ITransactionService {
    
    void showAllTransactions(BankAccount bankAccount);

    void searchTransaction(BankAccount bankAccount , int transactionId);

    List<Transaction> lastNTransactions(BankAccount bankAccount, int n) throws InvalidTransactionException;

    List<Transaction> transactionBetweenDates(BankAccount bankAccount , LocalDate a , LocalDate b);

    List<Transaction> highValueTransaction(BankAccount bankAccount , double value);

    List<Transaction> filterByType(BankAccount bankAccount , TransactionType transactionType );

    double getTotalExpenses(BankAccount bankAccount);

    double getAverageTransactionAmount(BankAccount bankAccount);

}
