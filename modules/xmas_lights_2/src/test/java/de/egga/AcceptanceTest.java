package de.egga;

import org.junit.Test;

import static de.egga.CoordinateTest.coord;
import static org.assertj.core.api.StrictAssertions.assertThat;

public class AcceptanceTest {

    @Test
    public void follow_santas_instructions() {
        Grid grid = new Grid();

        grid.turnOn(new Range(coord(0,0), coord(999, 999)));
        assertThat(grid.countBurningLights()).isEqualTo(1000000);

        grid.toggle(new Range(coord(0,0), coord(999, 0)));
        assertThat(grid.countBurningLights()).isEqualTo(999000);


        grid.turnOff(new Range(coord(499,499), coord(500, 500)));
        assertThat(grid.countBurningLights()).isEqualTo(998996);
    }
}
