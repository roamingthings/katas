package de.egga;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GridTest {

    private final int smallGridSize = 3;

    @Test
    public void it_should_turn_on_one_light() {
        Grid grid = new Grid(smallGridSize);
        grid.turnOn(0, 0, 0, 0);
        assertThat(grid.countLights()).isEqualTo(1);
    }

    @Test
    public void it_should_turn_on_two_lights_in_a_row() {
        Grid grid = new Grid(smallGridSize);
        grid.turnOn(0, 0, 1, 0);
        assertThat(grid.countLights()).isEqualTo(2);
    }

    @Test
    public void it_should_turn_on_two_lights_in_a_column() {
        Grid grid = new Grid(smallGridSize);
        grid.turnOn(0, 0, 0, 1);
        assertThat(grid.countLights()).isEqualTo(2);
    }

    @Test
    public void it_should_turn_on_all_lights() {
        Grid grid = new Grid(smallGridSize);
        grid.turnOn(0, 0, 2, 2);
        assertThat(grid.countLights()).isEqualTo(9);
    }

    @Test
    public void it_should_accept_too_large_ranges() {
        Grid grid = new Grid(1);
        grid.turnOn(0, 0, 2, 2);
        assertThat(grid.countLights()).isEqualTo(1);
    }

    @Test
    public void it_should_accept_too_high_start_x() {
        Grid grid = new Grid(1);
        grid.turnOn(2, 0, 3, 3);
        assertThat(grid.countLights()).isEqualTo(0);
    }

    @Test
    public void it_should_accept_too_high_start_y() {
        Grid grid = new Grid(1);
        grid.turnOn(0, 2, 3, 3);
        assertThat(grid.countLights()).isEqualTo(0);
    }

    @Test
    public void it_should_leave_on_one_light() {
        Grid grid = new Grid(smallGridSize);
        grid.turnOn(0, 0, 0, 0);
        grid.turnOn(0, 0, 0, 0);
        assertThat(grid.countLights()).isEqualTo(1);
    }

    @Test
    public void it_should_turn_off_one_light() {
        Grid grid = new Grid(smallGridSize);
        grid.turnOn(0, 0, 0, 0);
        assertThat(grid.countLights()).isEqualTo(1);
        grid.turnOff(0, 0, 0, 0);
        assertThat(grid.countLights()).isEqualTo(0);
    }
    @Test
    public void it_should_toggle_one_light() {
        Grid grid = new Grid(smallGridSize);
        grid.toggle(0, 0, 0, 0);
        assertThat(grid.countLights()).isEqualTo(1);
        grid.toggle(0, 0, 0, 0);
        assertThat(grid.countLights()).isEqualTo(0);
    }


}