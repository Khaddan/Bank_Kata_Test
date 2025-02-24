package bank.kata;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);

//    void deposit(int amount, String date);
//
//    void withdraw(int amount, String date);

    void printStatement();
}
