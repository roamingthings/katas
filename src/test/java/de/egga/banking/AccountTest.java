package de.egga.banking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock Printer printer;
    @InjectMocks Account account;

    @Test
    public void print_statement_should_use_printer() {
        account.printStatement();
        verify(printer).print("0");
    }

    @Test
    public void print_statement_should_print_deposited_amounts() {
        account.deposit(100);
        account.printStatement();
        verify(printer).print("100");
    }
    @Test
    public void print_statement_should_print_sum_of_deposited_amounts() {
        account.deposit(100);
        account.deposit(100);
        account.printStatement();
        verify(printer).print("200");
    }
}
