package de.egga.banking;

public class Account {

    private final Printer printer;

    public Account(Printer printer) {
        this.printer = printer;
    }

    public void printStatement() {
        printer.print(0);
    }
}
