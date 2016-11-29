package de.egga;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest {

    @Test
    public void range_of_one_coordinate_should_include_only_coordinate_itself() {
        assertThat(coord(0, 0)
                .rectangleTo(coord(0, 0))).
                containsExactly(
                        coord(0, 0)
                );
    }

    @Test
    public void range_of_two_vertically_neighboring_coordinates_should_include_both_neighbors() {
        assertThat(coord(0, 0).
                rectangleTo(coord(0, 1))).
                containsOnly(
                        coord(0, 0),
                        coord(0, 1)
                );
    }

    @Test
    public void range_of_two_horizontally_neighboring_coordinates_should_include_both_neighbors() {
        assertThat(coord(0, 0).
                rectangleTo(coord(1, 0))).
                containsOnly(
                        coord(0, 0),
                        coord(1, 0)
                );
    }
    @Test
    public void range_of_two_corners_should_include_the_whole_rectangle() {
        assertThat(coord(0, 0).
                rectangleTo(coord(2, 2))).
                containsOnly(
                        coord(0, 0),
                        coord(0, 1),
                        coord(0, 2),
                        coord(1, 0),
                        coord(1, 1),
                        coord(1, 2),
                        coord(2, 0),
                        coord(2, 1),
                        coord(2, 2)
                );
    }

    public static Coordinate coord(int x, int y) {
        return new Coordinate(x, y);
    }
}