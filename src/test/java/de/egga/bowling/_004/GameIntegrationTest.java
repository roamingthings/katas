package de.egga.bowling._004;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameIntegrationTest {

    Game game = new Game(
            new ScoreService(),
            new FrameService()
    );

    @Test
    public void score_should_be_zero_before_first_roll() {
        assertThat(game.score()).isEqualTo(0);
    }
}
