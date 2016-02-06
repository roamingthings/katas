package de.egga.bowling;

public class Game {

    private int score = 0;

    public void roll(int numberOfPins) {
        score += numberOfPins;
    }

    public int score() {

        return score;
    }
}
