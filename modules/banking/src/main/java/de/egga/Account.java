package de.egga;

import java.util.ArrayList;
import java.util.List;

import static de.egga.Amount.amount;

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
        Amount balance = amount(0);

        for (Transaction transaction : transactions) {
            balance = balance.add(transaction.amount);
        }

        printer.print(balance.print());
    }
}
