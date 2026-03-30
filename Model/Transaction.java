package Model;

import Enums.TransactionType;

public class Transaction {
    public TransactionType transactionType;
    public double transactionAmount;

    public Transaction(TransactionType transactionType , double transactionAmount){
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }
}
