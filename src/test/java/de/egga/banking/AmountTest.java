package de.egga.banking;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    public void two_same_amounts_should_be_sane() {
        Amount amount = new Amount(12);
        assertThat(amount).isEqualTo(new Amount(12));
    }

    @Test
    public void two_different_amounts_should_be_sane() {
        Amount amount = new Amount(11);
        assertThat(amount).isNotEqualTo(new Amount(12));
    }

    @Test
    public void it_should_add_amounts() {

        Amount sum = new Amount(1).add(new Amount(3));
        assertThat(sum).isEqualTo(new Amount(4));
    }
}
