package de.egga.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    public void score_should_be_zero_if_all_pins_missed() {
        game.roll(0);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void score_should_return_the_number_of_knocked_down_pins() {
        game.roll(1);
        assertThat(game.score()).isEqualTo(1);
    }

    @Test
    public void score_should_return_the_sum_of_knocked_down_pins() {
        game.roll(1);
        game.roll(2);
        game.roll(3);
        game.roll(4);
        assertThat(game.score()).isEqualTo(1+2+3+4);
    }
}
