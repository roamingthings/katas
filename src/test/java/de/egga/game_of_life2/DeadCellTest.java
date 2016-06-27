package de.egga.game_of_life2;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class DeadCellTest {

    @Test
    public void dead_cell_returns_an_alive_cell_for_exactly_three_alive_neighbors() {
        Cell deadCell = new DeadCell();
        Cell nextCell = deadCell.iterate(3);
        assertThat(nextCell).isInstanceOf(AliveCell.class);
    }

}