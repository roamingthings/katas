package de.egga;

import org.junit.Test;

import static de.egga.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void opposite_of_north_should_be_south() {
        assertThat(NORTH.getOpposite()).isEqualTo(SOUTH);
    }

    @Test
    public void opposite_of_south_should_be_north() {
        assertThat(SOUTH.getOpposite()).isEqualTo(NORTH);
    }

    @Test
    public void opposite_of_east_should_be_west() {
        assertThat(EAST.getOpposite()).isEqualTo(WEST);
    }

    @Test
    public void opposite_of_west_should_be_east() {
        assertThat(WEST.getOpposite()).isEqualTo(EAST);
    }

    @Test
    public void right_hand_side_of_north_should_be_east() {
        assertThat(NORTH.getRightHandSide()).isEqualTo(EAST);
    }

    @Test
    public void right_hand_side_of_east_should_be_south() {
        assertThat(EAST.getRightHandSide()).isEqualTo(SOUTH);
    }

    @Test
    public void right_hand_side_of_south_should_be_west() {
        assertThat(SOUTH.getRightHandSide()).isEqualTo(WEST);
    }

    @Test
    public void right_hand_side_of_west_should_be_north() {
        assertThat(WEST.getRightHandSide()).isEqualTo(NORTH);
    }

    @Test
    public void left_hand_side_of_north_should_be_west() {
        assertThat(NORTH.getLeftHandSide()).isEqualTo(WEST);
    }

    @Test
    public void left_hand_side_of_east_should_be_north() {
        assertThat(EAST.getLeftHandSide()).isEqualTo(NORTH);
    }

    @Test
    public void left_hand_side_of_south_should_be_east() {
        assertThat(SOUTH.getLeftHandSide()).isEqualTo(EAST);
    }

    @Test
    public void left_hand_side_of_west_should_be_south() {
        assertThat(WEST.getLeftHandSide()).isEqualTo(SOUTH);
    }
}