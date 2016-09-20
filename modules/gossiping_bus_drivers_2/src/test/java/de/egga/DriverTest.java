package de.egga;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {

    @Test
    public void both_drivers_should_learn_each_others_gossips() {
        Driver driver = new Driver();
        Driver other = new Driver();

        driver.exchangeGossips(other);

        assertThatBothDriversKnowEachOthersGOssips(driver, other);
    }

    @Test
    public void driver_should_not_know_gossip_of_other() {
        Driver driver = new Driver();

        assertThat(driver.knowsGossipsOf(new Driver())).isFalse();
    }

    @Test
    public void driver_should_not_know_own_gossip() {
        Driver driver = new Driver();

        assertThat(driver.knowsGossipsOf(driver)).isTrue();
    }


    private void assertThatBothDriversKnowEachOthersGOssips(Driver driver, Driver other) {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(driver.knowsGossipsOf(other)).isTrue();
        assertions.assertThat(other.knowsGossipsOf(driver)).isTrue();
        assertions.assertAll();
    }

}