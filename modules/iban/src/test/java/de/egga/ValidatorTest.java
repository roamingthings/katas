package de.egga;

import org.junit.Test;

import static de.egga.Validator.isIban;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @Test
    public void less_than_34_chars_should_be_valid() {
        String shortString = "some iban";
        assertThat(isIban(shortString)).isTrue();
    }

    @Test
    public void exactly_34_chars_should_be_valid() {
        String stringWith34Chars = "some iban that is exactly 34 chars";
        assertThat(isIban(stringWith34Chars)).isTrue();
    }

    @Test
    public void exactly_35_chars_should_not_be_valid() {
        String stringWith35Chars = "some iban that is exactly 35 chars.";
        assertThat(isIban(stringWith35Chars)).isFalse();
    }

    @Test
    public void more_than_35_chars_should_not_be_valid() {
        String stringWithMoreChars = "some iban that is far more 35 chars.";
        assertThat(isIban(stringWithMoreChars)).isFalse();
    }
}