package de.egga;

import org.junit.Test;

import static de.egga.CoordinateTest.coord;
import static org.assertj.core.api.Assertions.assertThat;

public class RangeTest {

    @Test
    public void range_with_two_corners_should_span_whole_rectangle() {
        Range range = new Range(coord(0,0), coord(1, 1));
        assertThat(range.getCoordinates()).containsOnly(
                coord(0,0),
                coord(0,1),
                coord(1,0),
                coord(1,1)
        );
    }
}