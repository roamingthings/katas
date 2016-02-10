package de.egga.bowling;

import de.egga.bowling.exceptions.NoValidResultException;

import static de.egga.bowling.Game.TOTAL_NUMBER_OF_PINS;

public class RollResult {

    private final int numberOfPins;

    public RollResult(int numberOfPins) {
        validate(numberOfPins);
        this.numberOfPins = numberOfPins;
    }

    public int value() {
        return numberOfPins;
    }


    private void validate(int numberOfPins) {
        if (tooSmall(numberOfPins) || tooHigh(numberOfPins)) {
            throw new NoValidResultException();
        }
    }

    private boolean tooHigh(int numberOfPins) {
        return numberOfPins > TOTAL_NUMBER_OF_PINS;
    }

    private boolean tooSmall(int numberOfPins) {
        return numberOfPins < 0;
    }
}
