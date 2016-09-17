package de.egga;

public class AmountFactory {
    public static Amount anyAmount() {
        return new Amount(500);
    }
}
