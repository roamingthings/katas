package de.egga;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class GameIntegrationTest {

    Game game = new Game(new RollRepository());

    @Test
    public void score_should_be_zero_before_first_roll() {
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void score_should_be_zero_if_no_pins_knocked_down() {
        game.roll(0);
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    public void score_should_be_the_number_of_pins_knocked_down() {
        game.roll(3);
        assertThat(game.score()).isEqualTo(3);
    }
}
