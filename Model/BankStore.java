package Model;

import java.util.*;

import Enums.AccountType;

public class BankStore {
    private Map<Integer, BankAccount> bankStore = new HashMap<>();

    void createBankAccount(AccountType accountType , int accountNumber ,double currentBalance){
        BankAccount b = new BankAccount(accountType, accountNumber, currentBalance);
        bankStore.put(accountNumber, b);
    }
}
