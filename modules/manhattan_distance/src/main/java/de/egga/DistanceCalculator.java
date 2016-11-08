package de.egga.manhattan;

public class DistanceCalculator {


    public int manhattanDistance(Point pointA, Point pointB) {

        return pointA.horizontalDistanceTo(pointB) + pointA.horizontalDistanceTo(pointB);
    }
}
