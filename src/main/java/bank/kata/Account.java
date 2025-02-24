package bank.kata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {
    private int balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();
    LocalDate simulatedDate = LocalDate.now();

    @Override
    public void deposit(int amount) {
        balance += amount;
        String date = formatDate(simulatedDate);
        transactions.add(new Transaction(date, amount, balance));
        simulateNextDate();
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
        String date = formatDate(simulatedDate);
        transactions.add(new Transaction(date, -amount, balance));
        simulateNextDate();
    }

    @Override
    public void printStatement() {
        System.out.println("Date       || Amount || Balance");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.printf("%s || %d || %d%n", t.getDate(), t.getAmount(), t.getBalance());
        }
    }

    private void simulateNextDate() {
        simulatedDate = simulatedDate.plusDays(3);
    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
