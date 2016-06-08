package de.egga.banking;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void itName() {
        Account account = new Account();

        assertThat("").isEqualTo("");
    }
}
