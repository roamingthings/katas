package de.egga.bowling;

import de.egga.bowling.exceptions.DoNotRollAgainException;
import org.junit.Test;

import static de.egga.bowling.RollResultFactory.ANY;

public class RollTest {

    @Test(expected = DoNotRollAgainException.class)
    public void it_can_not_be_done_twice() {
        Roll roll = new Roll();
        roll.setResult(ANY);
        roll.setResult(ANY);
    }
}