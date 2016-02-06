package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames = new ArrayList<Frame>();

    public Game() {
        frames.add(new Frame());
    }

    public void roll(int numberOfPins) {
        startNewFrameIfNecessary();
        currentFrame().addRoll(numberOfPins);
    }

    public int score() {
        int score = 0;

        for (Frame frame : frames) {
            score += frame.score();
        }

        return score;
    }


    private void startNewFrameIfNecessary() {
        if (currentFrame().isComplete()) {
            frames.add(new Frame());
        }
    }

    private Frame currentFrame() {
        return frames.get(frames.size() - 1);
    }
}
