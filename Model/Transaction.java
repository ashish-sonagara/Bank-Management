package Model;

import Enums.TransactionType;

public class Transaction {
    public TransactionType transactionType;
    public String transactionAmount;
    public int transactionId;

    public Transaction(TransactionType transactionType , String transactionAmount , int transactionId){
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionId = transactionId;
    }
}
