import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import Enums.AccountType;
import Enums.TransactionType;
import Model.*;
import Services.*;

public class Main {
    public static void main(String args[]) {
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
        BankAccount b1 = new BankAccount(AccountType.CURRENT, 4004, 20000.0);
        BankAccount b2 = new BankAccount(AccountType.SAVING, 5005, 19000);

        accountService.readFile(TransactionType.DEPOSIT);
        // try{
        //     String depositedResult = accountService.deposit(b1, 1800);
        //     System.out.println(depositedResult);
        //     System.out.println();
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }

        // try {
        //     String withdrawnResult = accountService.withdraw(b1, 2000);
        //     System.out.println( );
        //     System.out.println();
        // } catch (Exception e) {
        //     System.out.println(e);
        // }

        // try{
        //     String depositedResult = accountService.deposit(b2, 3800);
        //     System.out.println(depositedResult);
        //     System.out.println();
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }

        // try {
        //     String withdrawnResult = accountService.withdraw(b2, 2100);
        //     System.out.println( );
        //     System.out.println();
        // } catch (Exception e) {
        //     System.out.println(e);
        // }
        // String checkBalanceResult = accountService.checkBankBalance(b1);
        // System.out.println(checkBalanceResult);
        // System.out.println();

        // System.out.println("For Amount Transfer ");
        // try {
        //     String transferResult = accountService.transfer(b1, b2, 10000);
        //     System.out.println(transferResult);
        //     System.out.println();
        // } catch (Exception e) {
        //     System.out.println(e);
        // }

        // transactionService.showAllTransactions(b1);
        // transactionService.showAllTransactions(b2);

        // try{
        //     List<Transaction> transactions = transactionService.lastNTransactions(b1, 2);
        //     System.out.println("------ Last 2 Transactions------------");
        //     for(Transaction t : transactions){
        //         System.out.println("Found Transaction of type " + t.getTransactionType() + " of amount " + t.getTransactionAmount());
        //     }
        // }
        // catch(Exception e){
        //     System.out.println(e);
        // }

        // System.out.println();
        // List<Transaction> ts = transactionService.transactionBetweenDates(b1, LocalDate.of(2026, 04, 02), LocalDate.of(2026, 04, 03));
        // for(Transaction transaction : ts){
        //     System.out.println("Transaction of type " + transaction.getTransactionType() + " of amount " + transaction.getTransactionAmount());
        // }

        // System.out.println();
        // List<Transaction> highTransaction = transactionService.highValueTransaction(b1, 2000);
        // System.out.println("----------- High Value Transactons -------------");
        // for(Transaction transaction : highTransaction){
        //     System.out.println("Transaction of type " + transaction.getTransactionType() + " of amount " + transaction.getTransactionAmount());
        // }

        // System.out.println();
        // // System.out.println(" -----------show all transaction of bank Account ----------------");
        // transactionService.showAllTransactions(b1);

        // System.out.println();
        // System.out.println("-----------Average Amount of the Transaction-----------");
        // double averageValue = transactionService.getAverageTransactionAmount(b1);
        // System.out.println(averageValue);

        // System.out.println();
        // System.out.println("----------------- Total Expense--------------");
        // double totalAmount = transactionService.getTotalExpenses(b1);
        // System.out.println(totalAmount);

        // -----------------------------------------------------------------------------

        
        // File myFile = new File("bankFile.txt");
        // try {
        //     myFile.createNewFile();
        // } catch (IOException e) {
        //     System.out.println("Error While handling the file." + e);
        // }

        // try{
        //     FileWriter wr = new FileWriter("bankFile.txt");
        //     wr.write("BANK STATEMENTS");
        //     wr.close();
        // }
        // catch(IOException e){
        //     System.out.println("Error while writing inside the file" + e);
        // }

        // try{
        //     File readFile = new File("bankFile.txt");
        //     Scanner reader = new Scanner(readFile);
        //     while(reader.hasNextLine()){
        //         String data = reader.nextLine();
        //         System.out.println(data);
        //     }
        // }
        // catch(IOException e){
        //     System.out.println("Error while reading File" + e);
        // }

        // try( BufferedReader br = new BufferedReader(new FileReader("bankFile.txt"))){
        //     String line;
        //     while((line = br.readLine()) != null){
        //         System.out.println(line);
        //     }
        // }
        // catch(IOException e){
        //     System.out.println("Error while Reading File" + e);
        // }
    }
}