package de.egga;

import java.util.ArrayList;
import java.util.List;

public class RollRepository {

    private List<Integer> rolls = new ArrayList<>();

    public void save(int roll) {
        rolls.add(roll);
    }

    public Integer getSum() {
        int sum = 0;

        for (Integer roll : rolls) {
            sum += roll;
        }

        return sum;
    }
}
