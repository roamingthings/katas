package de.egga.banking;

public class Transaction {

    public final int amount;
    public final Amount amount2;

    public Transaction(int amount) {
        this.amount = amount;
        this.amount2 = new Amount(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return amount2.equals(that.amount2);

    }

    @Override
    public int hashCode() {
        return amount;
    }
}
