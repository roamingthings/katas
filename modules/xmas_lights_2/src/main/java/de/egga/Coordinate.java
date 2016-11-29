package de.egga;

import com.google.common.base.Objects;

import java.util.HashSet;
import java.util.Set;

public class Coordinate {

    public final int x;
    public final int y;

    public Coordinate(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Iterable<Coordinate> rectangleTo(Coordinate anotherCorner) {
        Set<Coordinate> coordinates = new HashSet<>();

        for (int currentX = this.x; currentX <= anotherCorner.x; currentX++) {
            for (int currentY = this.y; currentY <= anotherCorner.y; currentY++) {
                coordinates.add(new Coordinate(currentX, currentY));
            }
        }

        return coordinates;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }
}
