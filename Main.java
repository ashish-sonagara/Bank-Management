import java.util.ArrayList;
import java.util.Collection;

import Enums.AccountType;
import Model.*;
import Services.*;

public class Main {
    public static void main(String args[]) {
        // System.out.println("Project starts..");
        AccountService accountService = new AccountService();
        TransactionService transactionService = new TransactionService();
        BankAccount b1 = new BankAccount(AccountType.CURRENT, 4004, 20000.0);
        BankAccount b2 = new BankAccount(AccountType.SAVING, 5005, 19000);

        try{
            String depositedResult = accountService.deposit(b1, 1800);
            System.out.println(depositedResult);
        }
        catch(Exception e){
            System.out.println(e);
        }

        try {
            String withdrawnResult = accountService.withdraw(b1, 2000);
            System.out.println(withdrawnResult);
        } catch (Exception e) {
            System.out.println(e);
        }

        String checkBalanceResult = accountService.checkBankBalance(b1);
        System.out.println(checkBalanceResult);

        // System.out.println("For Amount Transfer ");
        try {
            String transferResult = accountService.transfer(b1, b2, 10000);
            System.out.println(transferResult);
        } catch (Exception e) {
            System.out.println(e);
        }

        transactionService.showAllTransactions(b1);
        transactionService.showAllTransactions(b2);
    }
}