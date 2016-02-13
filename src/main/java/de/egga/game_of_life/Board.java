package de.egga.game_of_life;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cells = new ArrayList<>();

    public Board(List<Cell> cells) {
        this.cells = cells;
    }

    public void tick(Printer printer) {
        for (Cell cell : cells) {
            contactNeighbors(cell);
        }
        printer.print(this);
    }

    private void contactNeighbors(Cell cell) {
        Cell neighbor = cells.get(0);

        cell.newState(neighbor);
    }

    private Cell getNeighbor() {
        return cells.get(0);
    }

}
