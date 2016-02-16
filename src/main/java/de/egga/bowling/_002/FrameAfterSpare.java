package de.egga.bowling._002;

public class FrameAfterSpare extends Frame {

    @Override
    public int score() {
        return totalNumberOfPinsKnockedDownInFrame() + pinsKnockedDownInFirstRoll();
    }

}
