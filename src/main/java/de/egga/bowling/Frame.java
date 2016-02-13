package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    public static final int NUMBER_OF_ROLLS_PER_FRAME = 2;
    public static final int TOTAL_NUMBER_OF_PINS = 10;
    private Frame nextFrame;

    private List<Integer> rolls = new ArrayList<>();

    public void addRoll(Integer numberOfPins) {

        if (frameIsNotFull()) {
            rolls.add(numberOfPins);

        } else {
            addRollToNextFrame(numberOfPins);
        }
    }


    public int score() {
        return score(0);
    }

    private int score(int numberOfBonusRolls) {
        int sum = scoreOfThisFrame(numberOfBonusRolls);

        int scoreOfNextFrames = 0;
        if (hasNext()) {
            if (isSpare()) {
                scoreOfNextFrames = nextFrame.score(1);
            } else if (isStrike()) {
                scoreOfNextFrames = nextFrame.score(2);
            }

        }
        return sum + scoreOfNextFrames;
    }

    private boolean isSpare() {
        return isMaxScore() || rolls.size() == 2;
    }

    private boolean isMaxScore() {
        return scoreOfThisFrame() == TOTAL_NUMBER_OF_PINS;
    }

    private int scoreOfThisFrame() {
        return scoreOfThisFrame(0);
    }

    private int scoreOfThisFrame(int numberOfBonusRolls) {
        int score = 0;

        for (Integer numberOfPins : rolls) {

            if (numberOfBonusRolls > 0) {
                numberOfPins *= 2;
                numberOfBonusRolls--;
            }
            score += numberOfPins;
        }
        return score;
    }

    private void addRollToNextFrame(Integer numberOfPins) {
        createNextFrameIfNecessary();
        nextFrame.addRoll(numberOfPins);
    }

    private void createNextFrameIfNecessary() {
        if (!hasNext()) {
            nextFrame = new Frame();
        }
    }

    private boolean frameIsNotFull() {
        boolean allRollsDone = rolls.size() < NUMBER_OF_ROLLS_PER_FRAME;
        return allRollsDone && scoreOfThisFrame() < 10;
    }

    private boolean hasNext() {
        return nextFrame != null;
    }

    public boolean isStrike() {
        return isMaxScore() && rolls.size() == 1;
    }
}
