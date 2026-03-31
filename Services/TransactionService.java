package Services;

import Model.BankAccount;
import Model.Transaction;

public class TransactionService {
    
    public void showAllTransactions(BankAccount bankAccount){
        System.out.println("-------- Transaction of " + bankAccount.accountNumber + "-----------");
        for (Transaction t : bankAccount.transactionHistory){
            System.out.println("Transaction of type " + t.transactionType + " of amount " + t.transactionAmount);
        }
    }

    public void searchTransaction(BankAccount bankAccount , Transaction transaction){
        boolean isTransactionFound = false;
        for (Transaction t : bankAccount.transactionHistory){
            // System.out.println("Transaction of type " + t.transactionType + " of amount " + t.transactionAmount);
            if (t.transactionId == transaction.transactionId){
                System.out.println("Found Transaction of type " + t.transactionType + " of amount " + t.transactionAmount);
                isTransactionFound = true;
            }
        }
        // return null;
        if(!isTransactionFound){
            System.out.println("No Transaction with such transaction ID " + transaction.transactionId + " found." );
        }
    }
}
