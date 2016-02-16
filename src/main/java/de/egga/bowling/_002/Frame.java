package de.egga.bowling._002;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    public static final int NUMBER_OF_ROLES_PER_FRAME = 2;
    private List<Integer> rolls = new ArrayList<>();

    public void addRoll(int numberOfPins) {
        rolls.add(numberOfPins);
    }

    public int score() {
        int sum = 0;

        for (Integer roll : rolls) {
            sum += roll;
        }
        return sum;
    }

    public boolean isFinished() {
        return rolls.size() == NUMBER_OF_ROLES_PER_FRAME;
    }
}
