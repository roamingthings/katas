package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> rolls = new ArrayList<>();

    public void roll(int numberOfPins) {
        rolls.add(numberOfPins);
    }

    public int score() {
        FrameFactory frameFactory = new FrameFactory(rolls);
        int score = frameFactory.score();
        return score;
    }

}
