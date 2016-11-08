package de.egga;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Integer> prices = new ArrayList<>();

    public void add(int price) {
        prices.add(price);
    }

    public int calculateTotalPrice() {
        int sum = 0;

        for (Integer price : prices) {
            sum += price;
        }

        return sum;
    }

    public boolean hasDiscount() {
        return calculateTotalPrice() >= 100;
    }

    public int numberOfProducts() {
        return prices.size();
    }

}
