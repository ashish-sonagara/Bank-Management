package Model;

import java.sql.Date;
import java.time.LocalDate;

import Enums.TransactionType;

public class Transaction {
    public TransactionType transactionType;
    public String transactionAmount;
    public int transactionId;
    public LocalDate date;

    public Transaction(TransactionType transactionType , String transactionAmount , int transactionId){
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionId = transactionId;
        date = LocalDate.now();
    }
}
