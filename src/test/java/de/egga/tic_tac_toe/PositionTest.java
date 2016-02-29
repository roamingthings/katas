package de.egga.tic_tac_toe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void testNeighbour1() {
        assertThat(Position.CENTER.isNeighbourOf(Position.LOWER_RIGHT)).isTrue();
    }

    @Test
    public void testNeighbour2() {
        assertThat(Position.CENTER.isNeighbourOf(Position.RIGHT)).isTrue();
    }

    @Test
    public void testNeighbour3() {
        assertThat(Position.CENTER.isNeighbourOf(Position.LOWER_LEFT)).isTrue();
    }

    @Test
    public void testNeighbour4() {
        assertThat(Position.UPPER_LEFT.isNeighbourOf(Position.LOWER_RIGHT)).isFalse();
    }

    @Test
    public void testNeighbour5() {
        assertThat(Position.UPPER_LEFT.isNeighbourOf(Position.UP)).isTrue();
    }

    @Test
    public void testNeighbour6() {
        assertThat(Position.UPPER_LEFT.isNeighbourOf(Position.LOWER_LEFT)).isFalse();
    }

    @Test
    public void testNeighbour7() {
        assertThat(Position.LOWER_RIGHT.isNeighbourOf(Position.CENTER)).isTrue();
    }

    @Test
    public void testNeighbour8() {
        assertThat(Position.LOWER_RIGHT.isNeighbourOf(Position.UP)).isFalse();
    }

    @Test
    public void testNeighbour9() {
        assertThat(Position.LOWER_RIGHT.isNeighbourOf(Position.RIGHT)).isTrue();
    }
}