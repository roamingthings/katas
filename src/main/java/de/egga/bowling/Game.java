package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Integer> rolls = new ArrayList<Integer>();

    public void roll(int i) {
        rolls.add(i);
    }

    public int score() {
        List<Integer> rolls = this.rolls;
        return ScoreCalculator.calc(rolls);
    }

}
