package de.egga;

public class BankAccount {

    private final Printer printer;
    private Amount money;

    public BankAccount(Printer printer) {
        this.printer = printer;
    }


    public void deposit(Amount money) {
        this.money = money;
    }

    public void withdraw(Amount amount) {
        throw new de.egga.OutOfMoneyException();
    }

    public void printStatement() {
        printer.print(money);
    }
}
