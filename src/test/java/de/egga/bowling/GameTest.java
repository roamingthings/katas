package de.egga.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    public void it_should_have_score_of_zero_before_first_r0ll() {
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void it_should_have_score_of_zero_if_no_pins_knocked_down() {
        game.roll(0);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void it_should_have_score_according_to_pins_knocked_down() {
        game.roll(1);
        game.roll(2);
        game.roll(3);
        assertThat(game.score()).isEqualTo(1 + 2 + 3);
    }

    @Test
    public void it_should_add_bonus_for_spare() {
        game.roll(5);
        game.roll(5);
        game.roll(2);
        game.roll(3);
        game.roll(4);
        assertThat(game.score()).isEqualTo(5 + 5 + (2 * 2) + 3 + 4);
    }

    @Test
    public void it_should_add_bonus_for_strike() {
        game.roll(10);
        game.roll(2);
        game.roll(2);
        game.roll(3);
        game.roll(4);
        assertThat(game.score()).isEqualTo(10 + (2 * 2 + 2) + 3 + 4);
    }
}
