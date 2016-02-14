package de.egga.bowling;

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
    public void it_should_have_score_if_pins_knocked_down() {
        game.roll(1);
        game.roll(1);
        assertThat(game.score()).isEqualTo(2);
    }

    @Test
    public void it_should_add_score_for_unfinished_frames() {
        game.roll(1);
        game.roll(2);
        game.roll(3);
        game.roll(4);
        game.roll(5);
        assertThat(game.score()).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

    @Test
    public void it_should_add_bonus_for_spare() {
        game.roll(4);
        game.roll(6);
        game.roll(3);
        assertThat(game.score()).isEqualTo(4 + 6 + 3 * 2);
    }

    @Test
    public void it_should_add_bonus_for_spare_only() {
        game.roll(4);
        game.roll(6);
        game.roll(3);
        game.roll(2);
        game.roll(1);
        game.roll(1);
        assertThat(game.score()).isEqualTo(4 + 6 + 3 * 2 + 2 + 1 + 1);
    }

    @Test
    public void it_should_add_double_bonus_for_strike() {
        game.roll(10);
        game.roll(3);
        game.roll(3);
        assertThat(game.score()).isEqualTo(10 + 2 * (3 + 3));
    }
}
