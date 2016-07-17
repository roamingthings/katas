package de.egga;

public class Validator {


    public static final int MAX_IBAN_LENGTH = 34;

    public static boolean isIban(String iban) {

        if (iban.length() > MAX_IBAN_LENGTH) {
            return false;
        }

        return true;
    }
}
