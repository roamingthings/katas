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
    public void itName() {
        account.printStatement();
        verify(printer).print();
    }
}
