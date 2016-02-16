package de.egga.bowling._002;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames = new ArrayList<>();

    public Game() {
        frames.add(new Frame());
    }

    public void roll(int numberOfPins) {
        createNewFrameIfNecessary();
        currentFrame().addRoll(numberOfPins);
    }

    public int score() {
        int sum = 0;

        for (Frame frame : frames) {
            sum += frame.score();
        }

        return sum;
    }


    private void createNewFrameIfNecessary() {
        if (currentFrame().isFinished()) {
            frames.add(new Frame());
        }
    }

    private Frame currentFrame() {
        return frames.get(frames.size() - 1);
    }
}
