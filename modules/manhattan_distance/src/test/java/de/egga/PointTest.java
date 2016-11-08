package de.egga.manhattan;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    final Point origin = new Point(0, 0);
    private final Point horizontallyMovedPoint = new Point(1, 0);
    private final Point verticallyMovedPoint = new Point(0, 1);

    @Test
    public void x_distance_to_itself_should_be_zero() {
        int distance = origin.horizontalDistanceTo(origin);
        assertThat(distance).isEqualTo(0);
    }

    @Test
    public void x_distance_should_be_one() {
        int distance = origin.horizontalDistanceTo(horizontallyMovedPoint);
        assertThat(distance).isEqualTo(1);
    }

    @Test
    public void x_distance_should_not_be_negative() {
        int distance = horizontallyMovedPoint.horizontalDistanceTo(origin);
        assertThat(distance).isEqualTo(1);
    }

    @Test
    public void y_distance_to_itself_should_be_zero() {
        int distance = origin.verticalDistanceTO(origin);
        assertThat(distance).isEqualTo(0);
    }

    @Test
    public void y_distance_should_be_one() {
        int distance = origin.verticalDistanceTO(verticallyMovedPoint);
        assertThat(distance).isEqualTo(1);
    }

    @Test
    public void y_distance_should_not_be_negative() {
        int distance = verticallyMovedPoint.verticalDistanceTO(origin);
        assertThat(distance).isEqualTo(1);
    }
}
