package de.egga;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static de.egga.AmountFactory.anyAmount;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BankAccountTest {

    @Mock Printer printer;
    @InjectMocks BankAccount account;

    @Test
    public void after_depositing_money_we_should_be_able_to_withdraw_it() {
        account.deposit(anyAmount());
        account.withdraw(anyAmount());
    }

    @Test
    public void after_depositing_money_we_should_be_able_to_see_it_on_the_statement() {
        account.deposit(anyAmount());
        account.printStatement();
        verify(printer).print(anyAmount());
    }

    @Test(expected = OutOfMoneyException.class)
    public void without_depositing_money_we_should_not_be_able_to_withdraw() {
        account.withdraw(anyAmount());
    }

}