package de.egga.bowling._002;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    public static final int NUMBER_OF_ROLES_PER_FRAME = 2;
    public static final int TOTAL_NUMBER_OF_PINS = 10;
    private List<Integer> rolls = new ArrayList<>();

    public void addRoll(int numberOfPins) {
        rolls.add(numberOfPins);
    }

    public int score() {
        return totalNumberOfPinsKnockedDownInFrame();
    }

    public boolean isFinished() {
        return rolls.size() == NUMBER_OF_ROLES_PER_FRAME;
    }

    public boolean isSpare() {
        return totalNumberOfPinsKnockedDownInFrame() == TOTAL_NUMBER_OF_PINS;
    }


    protected int totalNumberOfPinsKnockedDownInFrame() {
        int sum = 0;

        for (Integer roll : rolls) {
            sum += roll;
        }

        return sum;
    }

    protected int pinsKnockedDownInFirstRoll() {
        return rolls.get(0);
    }
}
