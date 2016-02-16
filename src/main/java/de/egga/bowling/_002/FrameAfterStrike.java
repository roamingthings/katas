package de.egga.bowling._002;

public class FrameAfterStrike extends Frame {

    @Override
    public int score() {
        return totalNumberOfPinsKnockedDownInFrame() * 2;
    }
}
