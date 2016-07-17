package de.egga;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {


    @Test
    public void itName() {
        List<List<Cell>> cells = new ArrayList<>();

        Game game = new Game(cells);
        List<List<Cell>> lists = game.iterate();
        assertThat(lists).isInstanceOf(List.class);
    }
}
