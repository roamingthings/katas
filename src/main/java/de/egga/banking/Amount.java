package de.egga.banking;

public class Amount {

    private final Integer amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount that = (Amount) o;
        return this.amount == that.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }

    public Amount add(Amount amount) {
        return new Amount(this.amount + amount.amount);
    }

    public String print() {
        return amount.toString();
    }
}
