package de.egga.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    public void game_without_rolls_has_zero_score() {
        int score = game.score();
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void game_without_pins_knocked_down_has_zero_score() {
        roll(0);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void game_should_remember_pins_of_first_roll() {
        roll(1);
        assertThat(game.score()).isEqualTo(1);
    }

    @Test
    public void game_should_remember_pins_of_second_roll() {
        roll(1, 1);
        assertThat(game.score()).isEqualTo(2);
    }

    @Test
    public void game_should_remember_pins_of_third_roll() {
        roll(1, 1, 3);
        assertThat(game.score()).isEqualTo(3);
    }

    private void roll(int... results) {
        for (int result : results) {
            game.roll(result);
        }
    }


}
