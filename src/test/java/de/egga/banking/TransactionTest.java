package de.egga.banking;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest {

    @Test
    public void itName() {
        Transaction transaction = new Transaction(12);
        assertThat(transaction).isEqualTo(new Transaction(12));
    }
}
