package de.egga.bowling._002;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    public void it_should_have_score_of_zero_before_first_roll() {
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void it_should_have_score_of_zero_if_no_pins_knocked_down() {
        game.roll(0);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void it_should_add_pins_as_score() {
        game.roll(1);
        game.roll(2);
        game.roll(3);
        assertThat(game.score()).isEqualTo(1+2+3);
    }
}
