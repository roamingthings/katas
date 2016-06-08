package de.egga.banking;

public class Transaction {

    public final int amount;

    public Transaction(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return amount == that.amount;

    }

    @Override
    public int hashCode() {
        return amount;
    }
}
