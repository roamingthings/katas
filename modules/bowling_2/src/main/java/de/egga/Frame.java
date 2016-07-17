package de.egga;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    public static final int TOTAL_NUMBER_OF_PINS = 10;

    private List<Integer> rolls = new ArrayList<>();

    public void addRoll(int numberOfPins) {
        rolls.add(numberOfPins);
    }

    public int score() {
        return totalNumberOfPinsKnockedDownInFrame();
    }

    public boolean isFinished() {
        return didTwoRolls() || allPinsKnockedDown();
    }

    public boolean isSpare() {
        return allPinsKnockedDown() && didTwoRolls();
    }

    public boolean isStrike() {
        return allPinsKnockedDown() && didOneRoll();
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


    private boolean didOneRoll() {
        return rolls.size() == 1;
    }

    private boolean didTwoRolls() {
        return rolls.size() == 2;
    }

    private boolean allPinsKnockedDown() {
        return totalNumberOfPinsKnockedDownInFrame() == TOTAL_NUMBER_OF_PINS;
    }
}
