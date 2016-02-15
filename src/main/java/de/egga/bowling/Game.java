package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private int multiplier = 0;
    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame;

    public Game() {
        addNewFrame();
    }

    public void roll(int numberOfPins) {
        createNewFrameIfNecessary();
        currentFrame.addRoll(numberOfPins);
    }

    private void createNewFrameIfNecessary() {
        if (currentFrame.isFinished()) {
            if (currentFrame.isSpare()) {
                multiplier = multiplier + 1;
            }

            if (currentFrame.isStrike()) {
                multiplier = multiplier + 1;
            }

            addNewFrame();
            multiplier = 0;
        }
    }

    private void addNewFrame() {
        Frame newFrame = new Frame(multiplier);
        frames.add(newFrame);
        currentFrame = newFrame;
    }

    public int score() {
        int sum = 0;

        for (Frame frame : frames) {
            sum += frame.score();
        }

        return sum;
    }

    private class Frame {

        public static final int TOTAL_NUMBER_OF_PINS = 10;
        public static final int ROLLS_PER_FRAME = 2;

        private int pinsLeft = TOTAL_NUMBER_OF_PINS;
        private int rollsLeft = ROLLS_PER_FRAME;
        private List<Integer> pinsKnockedDown = new ArrayList<>();
        private int bonusRolls;

        public Frame(int bonusRolls) {
            this.bonusRolls = bonusRolls;
        }

        public void addRoll(int numberOfPins) {
            pinsKnockedDown.add(numberOfPins);
            pinsLeft -= numberOfPins;
            rollsLeft--;
        }

        public int score() {
            int score = 0;
            for (Integer integer : pinsKnockedDown) {
                if (bonusRolls > 0) {
                    score += integer;
                    bonusRolls--;
                }
                score += integer;
            }

            return score;
        }

        public boolean isFinished() {
            return rollsLeft == 0 || pinsLeft == 0;
        }

        public boolean isSpare() {
            return pinsLeft == 0 && rollsLeft == 0;
        }

        public boolean isStrike() {
            return pinsLeft == 0 && rollsLeft == 1;
        }
    }
}
