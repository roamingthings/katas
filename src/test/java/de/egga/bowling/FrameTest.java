package de.egga.bowling;

import org.junit.Test;

import static de.egga.bowling.RollResultFactory.ONE;
import static de.egga.bowling.RollResultFactory.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    Frame frame = new Frame();

    @Test
    public void frame_without_rolls_has_zero_score() {
        int score = frame.score();
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void frame_without_pins_knocked_down_has_zero_score() {
        frame.roll(ZERO);
        assertThat(frame.score()).isEqualTo(0);
    }

    @Test
    public void frame_remembers_pins_knocked_down_in_first_roll() {
        frame.roll(ONE);
        assertThat(frame.score()).isEqualTo(1);
    }

    @Test
    public void frame_remembers_pins_knocked_down_in_second_roll() {
        frame.roll(ZERO);
        frame.roll(ONE);
        assertThat(frame.score()).isEqualTo(1);
    }

    @Test
    public void frame_remembers_pins_knocked_down_in_both_rolls() {
        frame.roll(ONE);
        frame.roll(ONE);
        assertThat(frame.score()).isEqualTo(2);
    }
}
