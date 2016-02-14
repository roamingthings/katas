package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    public static final int NUMBER_OF_ROLLS_PER_FRAME = 2;
    public static final int TOTAL_NUMBER_OF_PINS = 10;

    private List<Integer> rolls = new ArrayList<>();

    public void addRoll(Integer roll) {
        rolls.add(roll);
    }

    public boolean isFinished() {
        return rolls.size() == NUMBER_OF_ROLLS_PER_FRAME || isStrike();
    }

    public int score() {
        int sum = 0;
        for (Integer roll : rolls) {
            sum += roll;
        }
        return sum;
    }

    public boolean isSpare() {
        return rolls.size() == NUMBER_OF_ROLLS_PER_FRAME && score() == TOTAL_NUMBER_OF_PINS;
    }

    public int pinsOfFirstRoll() {
        return rolls.get(0);
    }

    public boolean isStrike() {
        return rolls.size() == 1 && score() == TOTAL_NUMBER_OF_PINS;
    }
}
