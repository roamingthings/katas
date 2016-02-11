package de.egga.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    public void score_should_be_zero_before_first_roll() {
        int score = game.score();
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void score_should_be_zero_after_failed_roll() {
        game.roll(0);
        int score = game.score();
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void score_should_be_one() {
        game.roll(1);
        int score = game.score();
        assertThat(score).isEqualTo(1);
    }

}
