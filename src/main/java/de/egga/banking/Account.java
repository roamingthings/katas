package de.egga.banking;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final Printer printer;
    private int amount = 0;
    private List<Integer>  amounts = new ArrayList<>();

    public Account(Printer printer) {
        this.printer = printer;
    }

    public void deposit(int amount) {
        amounts.add(amount);
        this.amount += amount;
    }

    public void printStatement() {
        printer.print(amount);
    }
}
