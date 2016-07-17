package de.egga;

public class FrameAfterSpare extends Frame {

    @Override
    public int score() {
        return totalNumberOfPinsKnockedDownInFrame() + pinsKnockedDownInFirstRoll();
    }

}
