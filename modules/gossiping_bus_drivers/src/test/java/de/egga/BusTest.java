package de.egga;

import org.junit.Test;

import static de.egga.BusFactory.anyRoute;
import static org.assertj.core.api.Assertions.assertThat;

public class BusTest {

    @Test
    public void it_should_start_at_first_stop() {
        Bus bus = new Bus("A", anyRoute());
        Integer currentStop = bus.currentStop();
        assertThat(currentStop).isEqualTo(1);
    }

    @Test
    public void it_should_advance_on_route() {
        Bus bus = new Bus("A", anyRoute());
        bus.goAhead();
        assertThat(bus.currentStop()).isEqualTo(2);
    }

    @Test
    public void it_should_start_over_again() {
        Bus bus = new Bus("A", anyRoute());
        bus.goAhead();
        bus.goAhead();
        bus.goAhead();
        assertThat(bus.currentStop()).isEqualTo(1);
    }


}