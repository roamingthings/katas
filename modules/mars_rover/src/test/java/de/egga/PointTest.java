package de.egga;

import org.junit.Test;

import static de.egga.Direction.*;
import static de.egga.Point.point;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    public void points_with_same_coordinates_should_be_equal() {
        assertThat(point(0, 0)).isEqualTo(point(0, 0));
    }

    @Test
    public void point_should_know_its_northern_neighbor() {
        Point point = point(0, 0);
        Point neighbor = point.getNeighbor(NORTH);
        assertThat(neighbor).isEqualTo(point(0, 1));
    }

    @Test
    public void point_should_know_its_southern_neighbor() {
        Point point = point(0, 0);
        Point neighbor = point.getNeighbor(SOUTH);
        assertThat(neighbor).isEqualTo(point(0, -1));
    }

    @Test
    public void point_should_know_its_eastern_neighbor() {
        Point point = point(0, 0);
        Point neighbor = point.getNeighbor(EAST);
        assertThat(neighbor).isEqualTo(point(1, 0));
    }
    @Test
    public void point_should_know_its_western_neighbor() {
        Point point = point(0, 0);
        Point neighbor = point.getNeighbor(WEST);
        assertThat(neighbor).isEqualTo(point(-1, 0));
    }

    @Test
    public void to_string_should_show_coordinates() {
        assertThat(point(0,0).toString()).isEqualTo("Point{x=0, y=0}");
    }
}