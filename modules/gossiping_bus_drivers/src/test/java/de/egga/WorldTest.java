package de.egga;

import org.junit.Test;

import static de.egga.BusFactory.anyBus;
import static org.assertj.core.api.Assertions.assertThat;

public class WorldTest {

    @Test
    public void one_bus_Driver_knows_his_gossip() {
        World world = new World();
        String result = world.simulate(anyBus());
        assertThat(result).isEqualTo("0");
    }

    @Test
    public void two_bus_Drivers_meet_at_the_first_stop() {
        World world = new World();
        String result = world.simulate(anyBus(), anyBus());
        assertThat(result).isEqualTo("1");
    }


}
