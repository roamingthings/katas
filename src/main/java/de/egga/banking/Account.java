package de.egga.banking;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final Printer printer;
    private List<Transaction>  transactions = new ArrayList<>();

    public Account(Printer printer) {
        this.printer = printer;
    }

    public void deposit(int amount) {
        transactions.add(new Transaction(amount));
    }

    public void printStatement() {
        int balance = 0;
        Amount balance2 = new Amount(0);

        for (Transaction transaction : transactions) {
            balance2 = balance2.add(transaction.amount);
        }

        printer.print(balance2.print());
    }
}
