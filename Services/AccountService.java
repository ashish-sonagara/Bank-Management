package Services;

public class AccountService {
    
    public String deposit(int amount){
        return "deposited";
    }

    public String withdraw(int amount){
        return "withdrawn";
    }

    public String transfer(int amount){
        return "transferred";
        // also need to have the bank accounts
    }
}
