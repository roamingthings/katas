package de.egga.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    Frame frame = new Frame();

    @Test
    public void frame_should_not_be_complete_after_first_roll() {
        frame.addRoll(1);
        assertThat(frame.isComplete()).isFalse();
    }

    @Test
    public void frame_should_be_complete_after_second_roll() {
        frame.addRoll(1);
        frame.addRoll(1);
        assertThat(frame.isComplete()).isTrue();
    }

    @Test
    public void frame_should_have_zero_score_before_first_roll() {
        assertThat(frame.score()).isEqualTo(0);
    }

    @Test
    public void frame_should_return_number_of_pins_after_first_roll() {
        frame.addRoll(1);
        assertThat(frame.score()).isEqualTo(1);
    }

    @Test
    public void frame_should_return_number_of_pins_after_second_roll() {
        frame.addRoll(1);
        frame.addRoll(1);
        assertThat(frame.score()).isEqualTo(1 + 1);
    }

    @Test
    public void frame_should_have_bonus() {
        frame.addRoll(5);
        frame.addRoll(5);
        boolean isNextBonus = frame.isNextBonus();
        assertThat(isNextBonus).isTrue();
    }
}
