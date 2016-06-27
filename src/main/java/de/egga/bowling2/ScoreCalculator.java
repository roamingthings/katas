package de.egga.bowling2;

public class ScoreCalculator {

    private Frame lastFrame = new Frame(0, 0);

    public int score() {
        return  lastFrame.score();
    }

    public void roll(int fallenPins) {
        if (lastFrame.isFinished()) {
            lastFrame = new Frame(fallenPins, 0, lastFrame);
        } else {
            lastFrame.secondRoll(fallenPins);
        }
    }
}
