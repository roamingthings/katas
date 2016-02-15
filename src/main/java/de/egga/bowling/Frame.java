package de.egga.bowling;

public class Frame {


    private final boolean isFrameAfterSpare;
    private final boolean isFrameAfterStrike;
    private Rolls rolls = new Rolls();

    public static Frame defaultFrame() {
        return new Frame(false, false);
    }

    public static Frame afterSpare() {
        return new Frame(true, false);
    }

    public static Frame afterStrike() {
        return new Frame(false, true);
    }

    private Frame(boolean isFrameAfterSpare, boolean isFrameAfterStrike) {
        this.isFrameAfterSpare = isFrameAfterSpare;
        this.isFrameAfterStrike = isFrameAfterStrike;
    }

    public void addRoll(int numberOfPins) {
        rolls.add(numberOfPins);
    }

    public int score() {
        int score = rolls.getNUmberOfPinsKnockedDown();

        if (isFrameAfterSpare) {
            score += rolls.getSpareBonus();
        } else if (isFrameAfterStrike) {
            score += rolls.getStrikeBonus();
        }

        return score;
    }

    public boolean isFinished() {
        return rolls.rollsLeft() == 0 || rolls.pinsLeft() == 0;
    }

    public boolean isSpare() {
        return rolls.pinsLeft()== 0 && rolls.rollsLeft() == 0;
    }

    public boolean isStrike() {
        return rolls.pinsLeft() == 0 && rolls.rollsLeft() == 1;
    }
}
