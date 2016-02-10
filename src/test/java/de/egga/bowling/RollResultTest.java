package de.egga.bowling;

import de.egga.bowling.exceptions.NoValidResultException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RollResultTest {

    @Test(expected = NoValidResultException.class)
    public void result_cannot_be_too_small() {
        new RollResult(-1);
    }

    @Test
    public void result_can_be_zero() {
        assertThat(new RollResult(0).value()).isEqualTo(0);
    }

    @Test
    public void result_can_be_all_pins() {
        new RollResult(10);
    }

    @Test(expected = NoValidResultException.class)
    public void result_cannot_be_too_big() {
        new RollResult(11);
    }
}