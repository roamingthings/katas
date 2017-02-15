package de.egga;


import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.summingInt;

public class ShoppingCart {

    private List<Integer> prices = new ArrayList<>();

    public void add(int price) {
        prices.add(price);
    }

    public int calculateTotalPrice() {
        return prices.stream().collect(summingInt(p -> p));
    }

    public boolean hasDiscount() {
        return prices.stream()
            .filter(p -> p >= 100)
            .findFirst()
            .isPresent();
    }

    public int numberOfProducts() {
        return prices.size();
    }
}