package de.egga.bowling;

import java.util.List;

public class FrameFactory {

    private final List<Integer> rolls;

    public FrameFactory(List<Integer> rolls) {
        this.rolls = rolls;
    }

    public int score() {
        Frame frame = new Frame();

        rolls.forEach(frame::addRoll);

        return frame.score();
    }
}
