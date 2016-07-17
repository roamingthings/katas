package de.egga;

import java.util.Objects;

import static de.egga.Direction.*;

public class Point {

    private final int x;
    private final int y;

    public static Point point(int x, int y) {
        return new Point(x, y);
    }


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point getNeighbor(Direction direction) {
        int newY = y;
        int newX = x;

        if (direction== NORTH) {
            newY = y + 1;
        } else if (direction == SOUTH) {
            newY = y - 1;
        } else if (direction == EAST) {
            newX = x + 1;
        } else if (direction == WEST) {
            newX = x - 1;
        }

        return point(newX, newY);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
