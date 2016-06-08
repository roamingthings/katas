package de.egga.banking;

import org.junit.Test;

public class AccountTest {

    @Test
    public void itName() {
        Printer printer = new Printer();
        Account account = new Account(printer);
        account.printStatement();
    }
}
