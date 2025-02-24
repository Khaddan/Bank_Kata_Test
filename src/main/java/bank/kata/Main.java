package bank.kata;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.simulatedDate = LocalDate.of(2012, 1, 10);
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.printStatement();
    }

}