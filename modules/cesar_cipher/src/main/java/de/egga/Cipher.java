package de.egga;

import java.util.HashMap;
import java.util.Map;

/**
 * @author egga
 */
public class Cipher {
    private static String DEFAULT_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final Map<Character, Character> mapping = new HashMap<Character, Character>();

    public Cipher() {
        this(DEFAULT_ALPHABET);
    }

    public Cipher(String alphabet) {
        char[] characters = alphabet.toCharArray();
        int maximumIndex = characters.length;
        for (int plainIndex = 0; plainIndex < maximumIndex; plainIndex++) {
            int rotationLength = maximumIndex / 2;
            int encodedIndex = plainIndex + rotationLength;

            if (encodedIndex >= maximumIndex) {
                encodedIndex -= maximumIndex;
            }
            char plain = characters[plainIndex];
            char encoded = characters[encodedIndex];
            mapping.put(plain, encoded);

        }
    }

    public String encode(String plain) {
        String encoded = "";
        for (char c : plain.toUpperCase().toCharArray()) {
            if (mapping.containsKey(c)) {
                encoded += mapping.get(c);
            } else {
                encoded += c;
            }
        }
        return encoded;
    }
}
