package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

import static de.egga.bowling.Frame.*;
import static de.egga.bowling.Frame.defaultFrame;

public class Game {

    private List<Frame> frames = new ArrayList<>();

    public Game() {
        frames.add(defaultFrame());
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

    private Frame currentFrame() {
        return frames.get(frames.size() - 1);
    }

    private void createNewFrameIfNecessary() {
        if (currentFrame().isFinished()) {

            if (currentFrame().isSpare()) {
                frames.add(afterSpare());

            } else if (currentFrame().isStrike()) {
                frames.add(afterStrike());

            } else {
                frames.add(defaultFrame());
            }
        }
    }

}

