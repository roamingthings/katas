package de.egga;

import org.junit.Ignore;
import org.junit.Test;

import static de.egga.Position.CENTER;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    public void it_should_have_no_winner_before_first_move() {
        Game game = new Game();
        assertThat(game.getStatus()).isNull();
    }

    @Test
    @Ignore
    public void itName2() {
        Game game = new Game();
        moveSequence(game, CENTER);
        assertThat(game.getStatus()).isEqualTo("Player One");
    }

    private void moveSequence(Game game, Position... positions) {

        for (Position position : positions) {
            game.move(position);
        }

    }

}
