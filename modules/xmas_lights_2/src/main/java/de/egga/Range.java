package de.egga;

public class Range {


    private final Coordinate oneCorner;
    private final Coordinate anotherCorner;

    public Range(Coordinate oneCorner, Coordinate anotherCorner) {

        this.oneCorner = oneCorner;
        this.anotherCorner = anotherCorner;
    }

    public Iterable<Coordinate> getCoordinates() {

        return oneCorner.rectangleTo(anotherCorner);
    }
}
