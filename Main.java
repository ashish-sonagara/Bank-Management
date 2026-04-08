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
    private final Scanner sc = new Scanner(System.in);
    private final AccountService accountService = new AccountService();
    private final TransactionService transactionService = new TransactionService();
    private final BankStore bankStore = new BankStore();
    public static void main(String args[]) {
        Main myApp = new Main();
        myApp.startMethod();
    }

    void startMethod() {
        
        // bankStore.
        BankAccount b1 = new BankAccount(AccountType.CURRENT, 4004, 20000.0);
        BankAccount b2 = new BankAccount(AccountType.SAVING, 5005, 19000);


        boolean shouldContinueLoop = true;
        int choosenOperation = 0;

        while (shouldContinueLoop) {
            System.out.println("Chooose the Number for the Opertion u want to perform: ");
            System.out.println("1) Deposit Money");
            System.out.println("2) Withdraw Money");
            System.out.println("3) Transfer Money");
            System.out.println("4) Additional Operation");
            System.out.println("5) Check Bank Balance");
            System.out.println("6) Exit");
            choosenOperation = sc.nextInt();
            
            shouldContinueLoop = menu(choosenOperation , b1 , b2);
        }
    }

    boolean menu(int choosenOperation,BankAccount b1,BankAccount b2) {

        switch (choosenOperation) {
            case 1:
                String depositedResult = accountService.deposit(b1, 3800);
                System.out.println(depositedResult);
                System.out.println();
                break;

            case 2:
                try {
                    String withdrawnResult = accountService.withdraw(b1, 2100);
                    System.out.println(withdrawnResult);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

            case 3:
                try {
                    String transferResult = accountService.transfer(b1, b2, 10000);
                    System.out.println(transferResult);
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

            case 4:
                additionalOperation(b1 , b2);
                break;

            case 5:
                String checkBalanceResult = accountService.checkBankBalance(b1);
                System.out.println(checkBalanceResult);
                System.out.println();
                break;

            case 6:
                System.out.println("Exiting..");
                return false;

            default:
                break;
        }

        return true;
    }

    void additionalOperation(BankAccount b1,BankAccount b2) {
        boolean shouldContinueLoop = true;
        int choosenOperation = 0;

        while (shouldContinueLoop) {
            System.out.println("Chooose the Number for the Opertion u want to perform: ");
            System.out.println("1) showAllTransactions");
            System.out.println("2) lastNTransactions");
            System.out.println("3) transactionBetweenDates");
            System.out.println("4) highValueTransaction");
            System.out.println("5) getAverageTransactionAmount");
            System.out.println("6) getTotalExpenses");
            System.out.println("7) Exjavit");
            choosenOperation = sc.nextInt();

            shouldContinueLoop = menuForAdditionOperation(choosenOperation, b1, b2);
        }
    }

    boolean menuForAdditionOperation(int choosenOperation, BankAccount b1,BankAccount b2) {
        switch (choosenOperation) {
            case 1:
                transactionService.showAllTransactions(b1);
                break;

            case 2:
                try {
                    List<Transaction> transactions = transactionService.lastNTransactions(b1, 2);
                    System.out.println("------ Last 2 Transactions------------");
                    for (Transaction t : transactions) {
                        System.out.println("Found Transaction of type " + t.getTransactionType() + " of amount "
                                + t.getTransactionAmount());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;

            case 3:
                System.out.println();
                List<Transaction> ts = transactionService.transactionBetweenDates(b1, LocalDate.of(2026, 04, 02),
                        LocalDate.of(2026, 04, 07));
                for (Transaction transaction : ts) {
                    System.out.println("Transaction of type " + transaction.getTransactionType() + " of amount "
                            + transaction.getTransactionAmount());
                }
                break;

            case 4:
                System.out.println();
                List<Transaction> highTransaction = transactionService.highValueTransaction(b1, 2000);
                System.out.println("----------- High Value Transactons -------------");
                for (Transaction transaction : highTransaction) {
                    System.out.println("Transaction of type " + transaction.getTransactionType() + " of amount "
                            + transaction.getTransactionAmount());
                }
                break;

            case 5:
                System.out.println();
                System.out.println("-----------Average Amount of the Transaction-----------");
                double averageValue = transactionService.getAverageTransactionAmount(b1);
                System.out.println(averageValue);
                break;
            
            case 6:
                System.out.println();
                System.out.println("----------------- Total Expense--------------");
                double totalAmount = transactionService.getTotalExpenses(b1);
                System.out.println(totalAmount);
                break;
            
            case 7:
                System.out.println("Exiting..");
                return false;

            default:
                break;
        }
        
        return true;
    }
}

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