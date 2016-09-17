package de.egga;

import static de.egga.AmountFactory.anyAmount;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @org.junit.Test
    public void asd() {

        assertThat(anyAmount()).isEqualTo(anyAmount());
    }
}