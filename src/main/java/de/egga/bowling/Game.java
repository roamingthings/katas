package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int TOTAL_NUMBER_OF_PINS = 10;

    private List<Frame> frames = new ArrayList<Frame>();
    private Frame currentFrame = newFrame();


    public void roll(int numberOfPins) {
        if (currentFrame == null || currentFrame.isFinished()) {
            currentFrame = newFrame();
        }
        this.currentFrame.roll(new RollResult(numberOfPins));
    }

    public int score() {
        return currentFrame.score();
    }


    private Frame newFrame() {
        Frame frame = new Frame();
        frames.add(frame);
        return frame;
    }
}
