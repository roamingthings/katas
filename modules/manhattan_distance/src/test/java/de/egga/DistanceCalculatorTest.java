package de.egga.manhattan;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DistanceCalculatorTest {

    DistanceCalculator calculator = new DistanceCalculator();

    @Test
    public void distance_should_be_zero_for_the_same_point() {
        Point point = new Point(1, 1);
        int distance = calculator.manhattanDistance(point, point);
        assertThat(distance).isEqualTo(0);
    }

    @Test
    public void distance_should_be_one() {
        Point pointA = new Point(0, 0);
        Point pointB = new Point(1, 1);
        int distance = calculator.manhattanDistance(pointA, pointB);
        assertThat(distance).isEqualTo(2);
    }
}