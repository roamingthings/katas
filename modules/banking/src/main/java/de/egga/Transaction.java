package de.egga;

public class Transaction {

    public final Amount amount;

    public Transaction(int amount) {
        this.amount = Amount.amount(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        return amount.equals(that.amount);

    }

    @Override
    public int hashCode() {
        return amount.hashCode();
    }
}
