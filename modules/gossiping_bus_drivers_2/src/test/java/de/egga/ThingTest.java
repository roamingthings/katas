package de.egga;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThingTest {

    @Test
    public void it_should_call_for_action() {
        new Driver();
        assertThat("as").isEqualTo("Done.");
    }
}