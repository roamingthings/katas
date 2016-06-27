package de.egga.bowling2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FrameTest {

    @Test
    public void frame_should_return_sum_if_is_first_frame() {
        Frame frame = new Frame(1, 1);
        int score = frame.score();
        assertThat(score).isEqualTo(2);
    }

    @Test
    public void frame_without_last_frame_should_be_finished() {
        Frame frame = new Frame(1);
        boolean finished = frame.isFinished();
        assertThat(finished).isTrue();
    }

    @Test
    public void frame_should_be_finished_after_second_roll() {
        Frame frame = new Frame(1);
        frame.secondRoll(3);
        boolean finished = frame.isFinished();
        assertThat(finished).isEqualTo(true);
    }

    @Test
    public void frame_should_sum_both_rolls() {
        Frame frame = new Frame(1);
        frame.secondRoll(3);
        int score = frame.score();
        assertThat(score).isEqualTo(4);
    }
    @Test
    public void frame_should_sum_both_rolls2() {
        Frame frame = new Frame(1);
        frame.secondRoll(9);
        assertThat(frame.isSpare()).isTrue();
    }
    @Test
    public void frame_should_sum_both_rolls4() {
        Frame frame = new Frame(1, 0, new Frame(1,1));
        assertThat(frame.isFinished()).isFalse();
    }
}