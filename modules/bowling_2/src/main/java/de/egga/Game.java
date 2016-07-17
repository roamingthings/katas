package de.egga;

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
            frames.add(nextFrame());
        }
    }

    private Frame nextFrame() {
        if (currentFrame().isSpare()) {
            return new FrameAfterSpare();
        } else if (currentFrame().isStrike()) {
            return new FrameAfterStrike();
        } else {
            return new Frame();
        }
    }

    private Frame currentFrame() {
        return frames.get(frames.size() - 1);
    }
}
