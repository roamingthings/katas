package de.egga.bowling._002;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int numberOfPins) {
        rolls.add(numberOfPins);
    }

    public int score() {
        int sum = 0;

        for (Integer roll : rolls) {
            sum += roll;
        }

        return sum;
    }
}
