package de.egga.mars_rover;

import org.junit.Test;

import static de.egga.mars_rover.Direction.*;
import static de.egga.mars_rover.Point.point;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    Point startingPoint = point(0, 0);

    @Test
    public void rover_should_move_forwards_when_facing_north() {
        MarsRover rover = roverFacing(NORTH).receiveCommand('f');
        assertThat(rover.getPosition()).isEqualTo(point(0, 1));
    }

    @Test
    public void rover_should_move_forwards_when_facing_east() {
        MarsRover rover = roverFacing(EAST).receiveCommand('f');
        assertThat(rover.getPosition()).isEqualTo(point(1, 0));
    }

    @Test
    public void rover_should_move_forwards_when_facing_south() {
        MarsRover rover = roverFacing(SOUTH).receiveCommand('f');
        assertThat(rover.getPosition()).isEqualTo(point(0, -1));
    }

    @Test
    public void rover_should_move_forwards_when_facing_west() {
        MarsRover rover = roverFacing(WEST).receiveCommand('f');
        assertThat(rover.getPosition()).isEqualTo(point(-1, 0));
    }

    @Test
    public void rover_should_move_backwards_when_facing_north() {
        MarsRover rover = roverFacing(NORTH).receiveCommand('b');
        assertThat(rover.getPosition()).isEqualTo(point(0, -1));
    }

    @Test
    public void rover_should_move_backwards_when_facing_east() {
        MarsRover rover = roverFacing(EAST).receiveCommand('b');
        assertThat(rover.getPosition()).isEqualTo(point(-1, 0));
    }

    @Test
    public void rover_should_move_backwards_when_facing_south() {
        MarsRover rover = roverFacing(SOUTH).receiveCommand('b');
        assertThat(rover.getPosition()).isEqualTo(point(0, 1));
    }

    @Test
    public void rover_should_move_backwards_when_facing_west() {
        MarsRover rover = roverFacing(WEST).receiveCommand('b');
        assertThat(rover.getPosition()).isEqualTo(point(1, 0));
    }

    @Test
    public void rover_should_move_east_after_turning_right() {
        MarsRover rover = roverFacing(NORTH).receiveCommand('r').receiveCommand('f');
        assertThat(rover.getPosition()).isEqualTo(point(1, 0));
    }
    @Test
    public void rover_should_move_west_after_turning_left() {
        MarsRover rover = roverFacing(NORTH).receiveCommand('l').receiveCommand('f');
        assertThat(rover.getPosition()).isEqualTo(point(-1, 0));
    }


    public MarsRover roverFacing(Direction direction) {
        return new MarsRover(startingPoint, direction);
    }
}
