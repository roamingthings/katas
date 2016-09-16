package de.egga;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ThingTest {

    Random random = new Random();

    @Test
    public void it_should_call_for_action() {
        List<Character> characters = asList('A', 'B', 'C', 'N', 'O', 'P');

        for (int i = 0; i < 100000; i++) {
            int stringLength = random.nextInt(10);
            String randomString = "";
            for (int j = 0; j < stringLength; j++) {
                randomString += characters.get(random.nextInt(characters.size()));
            }

            String encrypted = encrypt(randomString);
            assertThat(encrypted).isNotEqualTo(randomString);
        }

    }

    private String encrypt(String randomString) {

        return randomString + "something";
    }
}