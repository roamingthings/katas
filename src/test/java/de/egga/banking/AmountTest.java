package de.egga.banking;

import org.junit.Test;

import static de.egga.banking.Amount.amount;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    public void two_same_amounts_should_be_sane() {
        Amount amount = amount(12);
        assertThat(amount).isEqualTo(amount(12));
    }

    @Test
    public void two_different_amounts_should_be_sane() {
        Amount amount = amount(11);
        assertThat(amount).isNotEqualTo(amount(12));
    }

    @Test
    public void it_should_add_amounts() {

        Amount sum = amount(1).add(amount(3));
        assertThat(sum).isEqualTo(amount(4));
    }
}
