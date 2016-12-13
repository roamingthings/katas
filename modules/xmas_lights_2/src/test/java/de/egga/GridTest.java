package de.egga;

import org.junit.Test;

import static de.egga.CoordinateTest.coord;
import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    @Test
    public void it_should_call_for_action2() {
        Grid grid = new Grid();
        grid.turnOn(new Range(
                coord(0, 0),
                coord(1, 1)
        ));
        assertThat(grid.countBurningLights()).isEqualTo(4);
    }
}