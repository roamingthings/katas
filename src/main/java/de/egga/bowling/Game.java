package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame = createNewFrame(frames);

    public void roll(int i) {
        if (currentFrame.isFinished()) {
            currentFrame = createNewFrame(frames);
        }
        currentFrame.addRoll(i);
    }

    public int score() {
        int sum = 0;
        boolean hasBonusRoll = false;
        boolean hasTwoBonusRolls = false;

        for (Frame frame : frames) {
            if (hasTwoBonusRolls) {
                sum += frame.score();
                hasTwoBonusRolls = false;
            } else if (hasBonusRoll) {
                sum += frame.pinsOfFirstRoll();
                hasBonusRoll = false;
            }

            sum += frame.score();

            if (frame.isStrike()) {
                hasTwoBonusRolls = true;
            } else if (frame.isSpare()) {
                hasBonusRoll = true;
            }
        }

        return sum;

    }

    private Frame createNewFrame(List<Frame> frames) {
        Frame frame = new Frame();
        frames.add(frame);
        return frame;
    }

}
