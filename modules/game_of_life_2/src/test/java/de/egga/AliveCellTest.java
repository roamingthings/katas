package de.egga;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AliveCellTest {

    @Test
    public void it_returns_a_dead_cell_for_less_than_two_alive_neighbors() {
        Cell aliveCell = new AliveCell();
        Cell nextCell = aliveCell.iterate(1);
        assertThat(nextCell).isInstanceOf(DeadCell.class);
    }

    @Test
    public void it_returns_an_alive_cell_for_two_alive_neighbors() {
        Cell aliveCell = new AliveCell();
        Cell nextCell = aliveCell.iterate(2);
        assertThat(nextCell).isInstanceOf(AliveCell.class);
    }

    @Test
    public void it_returns_an_alive_cell_for_three_alive_neighbors() {
        Cell aliveCell = new AliveCell();
        Cell nextCell = aliveCell.iterate(3);
        assertThat(nextCell).isInstanceOf(AliveCell.class);
    }

    @Test
    public void it_returns_a_dead_cell_for_more_than_three_alive_neighbors() {
        Cell aliveCell = new AliveCell();
        Cell nextCell = aliveCell.iterate(4);
        assertThat(nextCell).isInstanceOf(DeadCell.class);
    }
}
