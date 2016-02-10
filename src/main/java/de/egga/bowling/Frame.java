package de.egga.bowling;

public class Frame {

    private final Roll firstRoll = new Roll();
    private final Roll secondRoll = new Roll();

    public void roll(RollResult result) {
        if (!firstRoll.hasResult()) {
            firstRoll.setResult(result);
        } else {
            secondRoll.setResult(result);
        }
    }

    public int score() {
        int score = 0;

        if (firstRoll.hasResult()) {
            score += firstRoll.getResult().value();
        }
        if (secondRoll.hasResult()) {
            score += secondRoll.getResult().value();
        }

        return score;
    }

    public boolean isFinished() {
        return firstRoll.hasResult() && secondRoll.hasResult();
    }
}
