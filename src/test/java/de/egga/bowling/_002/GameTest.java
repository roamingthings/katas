package de.egga.bowling._002;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    Game game = new Game();

    @Test
    public void itName() {
        assertThat(game.score()).isEqualTo(0);
    }
}
