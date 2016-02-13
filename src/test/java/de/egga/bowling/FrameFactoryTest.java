package de.egga.bowling;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class FrameFactoryTest {

    @Test
    public void it_should_add_number_of_pins() {
        List<Integer> rolls = asList(1, 2, 3, 4);
        FrameFactory factory = new FrameFactory(rolls);
        assertThat(factory.score()).isEqualTo(1+2+3+4);
    }

    @Test
    public void it_should_add_bonus_for_spare() {
        List<Integer> rolls = asList(5, 5, 1, 1);
        FrameFactory factory = new FrameFactory(rolls);
        assertThat(factory.score()).isEqualTo(5+5+2+1);
    }
    @Test
    public void it_should_add_bonus_twice_for_strike() {
        List<Integer> rolls = asList(10, 1, 1);
        FrameFactory factory = new FrameFactory(rolls);
        assertThat(factory.score()).isEqualTo(10+2+2);
    }
}
