package de.egga.banking;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final Printer printer;
    private List<Integer>  amounts = new ArrayList<>();

    public Account(Printer printer) {
        this.printer = printer;
    }

    public void deposit(int amount) {
        amounts.add(amount);
    }

    public void printStatement() {
        int balance = 0;

        for (Integer amount : amounts) {
            balance += amount;
        }

        printer.print(balance);
    }
}
