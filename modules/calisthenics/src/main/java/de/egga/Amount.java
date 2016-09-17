package de.egga;

import com.google.common.base.Objects;

public class Amount {

    private final int money;

    public Amount(int money) {

        this.money = money;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return money == amount.money;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(money);
    }
}
