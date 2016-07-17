package de.egga;

import org.junit.Test;

import static de.egga.CharacterValidator.isLetter;
import static org.assertj.core.api.Assertions.assertThat;

public class CharacterValidatorTest {

    @Test
    public void a_letter_should_be_a_letter() {
        char letter = 'a';
        assertThat(isLetter(letter)).isTrue();
    }
}