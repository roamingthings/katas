package de.egga.banking;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionTest {

    @Test
    public void transactions_with_same_amount_should_be_equal() {

        Transaction transaction = new Transaction(12);
        assertThat(transaction).isEqualTo(new Transaction(12));
    }

    @Test
    public void transactions_with_different_amount_should_not_be_equal() {
        Transaction transaction = new Transaction(12);
        assertThat(transaction).isNotEqualTo(new Transaction(34));
    }
}
