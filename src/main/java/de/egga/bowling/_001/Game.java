package de.egga.bowling._001;

import java.util.ArrayList;
import java.util.List;

import static de.egga.bowling._001.Frame.defaultFrame;
import static de.egga.bowling._001.Frame.frameAfterSpare;
import static de.egga.bowling._001.Frame.frameAfterStrike;

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

    private void createNewFrameIfNecessary() {

        if (currentFrame().isFinished()) {

            if (currentFrame().isSpare()) {
                frames.add(frameAfterSpare());
            } else if (currentFrame().isStrike()) {
                frames.add(frameAfterStrike());
            } else {
                frames.add(defaultFrame());
            }
        }
    }

    private Frame currentFrame() {
        return frames.get(frames.size() - 1);
    }
}

