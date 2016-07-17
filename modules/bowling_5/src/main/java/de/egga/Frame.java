package de.egga;

public class Frame {

    private final int fallenPins;
    private int fallenPins2;
    private final Frame lastFrame;
    private boolean isFinished = false;

    public Frame(int fallenPins, int fallenPins2) {
        this(fallenPins, fallenPins2, null);
    }

    public Frame(int fallenPins, int fallenPins2, Frame lastFrame) {
        this.fallenPins = fallenPins;
        this.fallenPins2 = fallenPins2;
        this.lastFrame = lastFrame;

        if (lastFrame == null) {
            isFinished = true;
        }
    }

    public Frame(int fallenPins) {
        this(fallenPins, 0, null);
    }

    public int score() {
        if (lastFrame != null) {
            int multiply = 1;
            if (lastFrame.isSpare()) {
                multiply++;
            }

            return (fallenPins + fallenPins2)*multiply + lastFrame.score();
        }
        return fallenPins + fallenPins2;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void secondRoll(int fallenPins) {
        fallenPins2 = fallenPins;
        isFinished = true;
    }

    public boolean isSpare() {
        return fallenPins + fallenPins2 == 10;
    }
}
