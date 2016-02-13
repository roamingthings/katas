package de.egga.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    public void it_should_have_zero_score_before_first_roll() {
        int score  = game.score();
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void it_should_have_score_of_two_after_according_roll() {
        game.roll(2);
        int score  = game.score();
        assertThat(score).isEqualTo(2);
    }
}
