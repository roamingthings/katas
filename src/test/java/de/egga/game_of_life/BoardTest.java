package de.egga.game_of_life;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BoardTest {

    @Mock Cell cell1;
    @Mock Cell cell2;
    @Mock Printer printer;

    Board board;
    List<Cell> cells;

    @Before public void before() {
        cells = asList(cell1, cell2);
        board = new Board(cells);
    }

    @Test
    public void it_should_trigger_output_on_tick() {
        board.tick(printer);
        verify(printer).print(board);
    }

    @Test
    public void it_should_calc_new_generation_on_tick() {
        board.tick(printer);
        verify(cell2).newState(cell1);
        verify(cell1).newState(cell1);
    }

}
