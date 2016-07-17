package de.egga;

import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Position {

    public static final Position CENTER = new Position(0, 0);
    public static final Position UPPER_LEFT = new Position(-1, -1);
    public static final Position LOWER_RIGHT = new Position(1, 1);
    public static final Position RIGHT = new Position(1, 0);
    public static final Position LOWER_LEFT = new Position(-1, 1);
    public static final Position UP = new Position(0, -1);

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isNeighbourOf(Position that){
        int xAbs = calculateDistance(this.x, that.x);
        int yAbs = calculateDistance(this.y, that.y);
        return areTheyCloseEnough(xAbs, yAbs);
    }

    private boolean areTheyCloseEnough(int xAbs, int yAbs) {
        return max(xAbs, yAbs) < 2;
    }

    private int calculateDistance(int a, int b) {
        return abs(a - b);
    }
}
