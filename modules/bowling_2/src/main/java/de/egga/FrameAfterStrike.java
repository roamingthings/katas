package de.egga;

public class FrameAfterStrike extends Frame {

    @Override
    public int score() {
        return totalNumberOfPinsKnockedDownInFrame() * 2;
    }
}
