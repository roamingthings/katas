package de.egga;

import org.junit.Test;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class CesarCipherTest {

    Random random = new Random();
    private String generateRandomString(List<Character> characters, int stringLength) {
        String randomString = "";
        for (int j = 0; j < stringLength; j++) {
            randomString += characters.get(random.nextInt(characters.size()));
        }
        return randomString;
    }

    private int getRandomNotEmptyString() {
        return random.nextInt(10) + 1;
    }

    List<Character> characters = asList('A', 'B', 'C', 'N', 'O', 'P');

    @Test
    public void encrypt_should_change_the_plaintext() {

        for (int i = 0; i < 100000; i++) {
            int stringLength = getRandomNotEmptyString();
            String plaintext = generateRandomString(characters, stringLength);

            String ciphertext = encrypt(plaintext);
            assertThat(ciphertext).isNotEqualTo(plaintext);
        }
    }

    @Test
    public void encrypting_twice_should_return_the_plaintext() {

        for (int i = 0; i < 100000; i++) {
            int stringLength = getRandomNotEmptyString();
            String plaintext = generateRandomString(characters, stringLength);

            String ciphertext = encrypt(encrypt(plaintext));
            assertThat(ciphertext).isEqualTo(plaintext);
        }
    }

    @Test
    public void ciphertext_should_not_contain_the_plaintext() {
        for (int i = 0; i < 100000; i++) {
            int stringLength = getRandomNotEmptyString();
            String plaintext = generateRandomString(characters, stringLength);

            String ciphertext = encrypt(plaintext);
            assertThat(ciphertext).doesNotContain(plaintext);
        }
    }

    @Test
    public void non_alphabet_characters_should_be_unchanged() {
        for (int i = 0; i < 100000; i++) {


            int stringLength = getRandomNotEmptyString();
            String plaintext = generateRandomString(characters, stringLength);

            String ciphertext = encrypt(plaintext);
            assertThat(ciphertext).doesNotContain(plaintext);
        }
    }



    private String encrypt(String plaintext) {
        String ciphertext = "";

        for (char plaintextCharacter : plaintext.toCharArray()) {
            ciphertext += encryptCharacter(plaintextCharacter);
        }

        return ciphertext;
    }

    private char encryptCharacter(char plaintextCharacter) {
        List<Character> characters = asList('A', 'B', 'C', 'N', 'O', 'P');
        int alphabetLength = characters.size();
        int index = characters.indexOf(plaintextCharacter);
        int cipherIndex = (index +  alphabetLength / 2) % alphabetLength;

        return characters.get(cipherIndex);
    }
}