package de.egga.bowling;

import de.egga.bowling.exceptions.DoNotRollAgainException;

public class Roll {

    private RollResult result;

    public Roll() {
    }

    RollResult getResult() {
        return result;
    }


    public void setResult(RollResult result) {
        validate();
        this.result = result;
    }

    boolean hasResult() {
        return result != null;
    }

    private void validate() {
        if (hasResult()) {
            throw new DoNotRollAgainException();
        }
    }
}