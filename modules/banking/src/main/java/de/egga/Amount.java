package de.egga;

public class Amount {

    public static Amount amount(int amount) {
        return new Amount(amount);
    }


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
        return amount(this.amount + amount.amount);
    }

    public String print() {
        return amount.toString();
    }
}
