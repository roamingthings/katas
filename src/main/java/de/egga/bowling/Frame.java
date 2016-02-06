package de.egga.bowling;

public class Frame {

    private static final int NUMBER_OF_ROLLS_PER_FRAME = 2;
    private static final int NUMBER_OF_PINS_PER_FRAME = 10;

    private int rollsDoneSoFar = 0;
    private int score = 0;

    public void addRoll(int numberOfPins) {
        rollsDoneSoFar++;
        score += numberOfPins;
    }

    public boolean isComplete() {
        return allRollsOfFrameDone();
    }

    public int score() {
        return score;
    }

    public boolean isNextBonus() {
        return isSpare();
    }


    private boolean isSpare() {
        return allRollsOfFrameDone() && allPinsKnockedDown();
    }

    private boolean allPinsKnockedDown() {
        return score == NUMBER_OF_PINS_PER_FRAME;
    }

    private boolean allRollsOfFrameDone() {
        return rollsDoneSoFar == NUMBER_OF_ROLLS_PER_FRAME;
    }
}
