package de.egga;

public abstract class  Cell {
    Cell iterate(int aliveNeighbors) {
        if (aliveNeighbors == 2 || aliveNeighbors == 3) {
            return new AliveCell();
        }
        return new DeadCell();
    };
}
