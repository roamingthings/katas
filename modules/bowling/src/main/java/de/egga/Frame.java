package de.egga;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    public static final int NUMBER_OF_ROLLS_PER_FRAME = 2;
    public static final int TOTAL_NUMBER_OF_PINS = 10;

    private final boolean isAfterSpare;
    private final boolean isAfterStrike;
    private List<Integer> rolls = new ArrayList<>();


    static Frame defaultFrame() {
        return new Frame(false, false);
    }

    static Frame frameAfterSpare() {
        return new Frame(true, false);
    }

    public static Frame frameAfterStrike() {
        return new Frame(false, true);
    }


    private Frame(boolean isAfterSpare, boolean isAfterStrike) {
        this.isAfterSpare = isAfterSpare;
        this.isAfterStrike = isAfterStrike;
    }

    public void addRoll(int numberOfPins) {
        rolls.add(numberOfPins);
    }

    public int score() {
        int score = 0;

        for (Integer roll : rolls) {
            score += roll;
        }

        if (isAfterSpare) {
            score += rolls.get(0);
        } else if (isAfterStrike) {
            score *= 2;
        }

        return score;
    }

    public boolean isFinished() {
        return isStrike() || rolls.size() == NUMBER_OF_ROLLS_PER_FRAME ;
    }

    public boolean isSpare() {
        return score() == TOTAL_NUMBER_OF_PINS && rolls.size() > 1;
    }

    public boolean isStrike() {
        return score() == TOTAL_NUMBER_OF_PINS && rolls.size() == 1;
    }
}
