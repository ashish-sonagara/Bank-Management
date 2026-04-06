package Model;

import java.sql.Date;
import java.time.LocalDate;

import Enums.TransactionType;

public class Transaction {
    private TransactionType transactionType;
    private String transactionAmount;
    private int transactionId;
    private LocalDate date;

    public Transaction(TransactionType transactionType , String transactionAmount , int transactionId){
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionId = transactionId;
        date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
