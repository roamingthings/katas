package de.egga.game_of_life2;

public abstract class  Cell {
    Cell iterate(int aliveNeighbors) {
        if (aliveNeighbors == 2 || aliveNeighbors == 3) {
            return new AliveCell();
        }
        return new DeadCell();
    };
}
