package de.egga;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridAcceptanceTest {

    private final int gridSize = 1000;
    private final int numberOfLights = 1000000;

    @Test
    public void it_should_turn_on_all_lights() {
        Grid grid = new Grid(gridSize);
        grid.turnOn(0, 0, 999, 999);
        assertThat(grid.countLights()).isEqualTo(numberOfLights);

        grid.toggle(0,0,999,0);
        assertThat(grid.countLights()).isEqualTo(numberOfLights-1000);

        grid.toggle(499,499,500,500);
        assertThat(grid.countLights()).isEqualTo(numberOfLights-1000-4);
    }

}