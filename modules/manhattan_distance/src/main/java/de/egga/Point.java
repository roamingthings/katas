package de.egga.manhattan;

import static java.lang.Math.abs;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int horizontalDistanceTo(Point that) {
        return abs(this.x - that.x);
    }

    public int verticalDistanceTO(Point that) {
        return abs(this.y - that.y);
    }
}
