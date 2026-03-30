package Model;

public interface Account {
    String deposit(int amount);

    String withdraw(int amount);

    String transfer(int amount);
}