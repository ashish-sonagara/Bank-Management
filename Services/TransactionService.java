package Services;

import java.util.*;
// import java.util.List;
import java.time.*;
import Exceptions.InvalidTransactionException;
import Model.BankAccount;
import Model.Transaction;

public class TransactionService {
    
    public void showAllTransactions(BankAccount bankAccount){
        System.out.println("-------- Transaction of " + bankAccount.accountNumber + "-----------");
        for (Transaction t : bankAccount.transactionHistory){
            System.out.println("Transaction of type " + t.transactionType + " of amount " + t.transactionAmount + " on Date " + t.date);
        }
        System.out.println();
    }

    public void searchTransaction(BankAccount bankAccount , int transactionId){
        boolean isTransactionFound = false;
        for (Transaction t : bankAccount.transactionHistory){
            // System.out.println("Transaction of type " + t.transactionType + " of amount " + t.transactionAmount);
            if (t.transactionId == transactionId){
                System.out.println("Found Transaction of type " + t.transactionType + " of amount " + t.transactionAmount);
                System.out.println();
                isTransactionFound = true;
            }
        }

        if(!isTransactionFound){
            System.out.println("No Transaction with such transaction ID " + transactionId + " found." );
        }
    }

    public List<Transaction> lastNTransactions(BankAccount bankAccount, int n) throws InvalidTransactionException {
        int noOfTransaction = bankAccount.transactionHistory.size();
        if(noOfTransaction < n){
            throw new InvalidTransactionException("Number of Transaction in your Bank Account is Lesser than U are asking for!");
        } 
        List <Transaction> transactions = new ArrayList<Transaction>();
        int length = bankAccount.transactionHistory.size() - 1;
        for (int i = length ; n > 0 ; i-- ){
            Transaction t = bankAccount.transactionHistory.get(i);
            transactions.add(t);
            n -= 1;
        }

        return transactions;
    }

    public List<Transaction> transactionBetweenDates(BankAccount bankAccount , LocalDate a , LocalDate b){
        List<Transaction> transactions = new ArrayList<>();
        bankAccount.transactionHistory.forEach( transaction -> {
            if ((transaction.date.isAfter(a) || transaction.date.isEqual(a)) &&
                    (transaction.date.isBefore(b) || transaction.date.isEqual(b))) {
                transactions.add(transaction);
            }
        });
        return transactions;
    }

    public List<Transaction> highValueTransaction(BankAccount bankAccount , double value){
        List<Transaction> transactions = new ArrayList<>();

        bankAccount.transactionHistory.forEach( transaction -> {
            if (Double.parseDouble(transaction.transactionAmount.substring(1)) >= value) {
                transactions.add(transaction);
            }
        });

        return transactions;
    }

}

// 1. Filtering by Type
// Users rarely want to see every single thing. They usually want to see only their spends or only their incoming salary.

// Method: filterByTransactionType(BankAccount account, TransactionType type)

// Logic: Use a stream to return a list of only DEPOSIT or only WITHDRAW.

// 2. The "Mini Statement" (Last N Transactions)
// A full history can have 1,000 items. Usually, you only want to see the most recent ones.

// Method: getMiniStatement(BankAccount account, int limit)

// Logic: Use .stream().limit(limit) to show only the last 5 or 10 records.

// 3. Date-Range Searching (Crucial for Real Apps)
// Transactions usually have a timestamp. If you add private LocalDateTime timestamp to your Transaction model, you can search for things that happened "This Week" or "Last Month."

// Logic: Filter based on a start date and an end date.

// 4. High-Value Alert / Search
// Find all transactions where the amount is greater than a certain value (e.g., "Show me all transactions > 5000").

// Method: getHighValueTransactions(BankAccount account, double threshold)

// 5. Statistics (The "Analytics" Feature)
// This is where Streams really shine. Instead of just showing data, calculate something:

// getTotalExpenses(): Sum of all WITHDRAW and TRANSFER (outgoing).

// getAverageTransactionAmount(): The average of all transactions using .mapToDouble().average().

// getHighestSpending(): Find the single largest withdrawal using .max().