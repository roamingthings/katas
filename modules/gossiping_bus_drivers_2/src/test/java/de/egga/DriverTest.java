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

        assertThatBothDriversKnowEachOthersGossips(driver, other);
    }

    @Test
    public void driver_should_not_know_gossip_of_other() {
        Driver driver = new Driver();

        assertThat(driver.knowsGossipsOf(new Driver())).isFalse();
    }

    @Test
    public void driver_should_know_own_gossip() {
        Driver driver = new Driver();

        assertThat(driver.knowsGossipsOf(driver)).isTrue();
    }

    @Test
    public void both_drivers_should_learn_each_others_gossips2() {
        Driver driver1 = new Driver();
        Driver driver2 = new Driver();
        Driver driver3 = new Driver();

        driver1.exchangeGossips(driver2);
        driver1.exchangeGossips(driver3);

        assertThatBothDriversKnowEachOthersGossips(driver1, driver2);
        assertThatBothDriversKnowEachOthersGossips(driver1, driver3);
        assertThat(driver2.knowsGossipsOf(driver3)).isFalse();
        assertThat(driver3.knowsGossipsOf(driver2)).isTrue();
    }


    private void assertThatBothDriversKnowEachOthersGossips(Driver driver, Driver other) {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(driver.knowsGossipsOf(other)).isTrue();
        assertions.assertThat(other.knowsGossipsOf(driver)).isTrue();
        assertions.assertAll();
    }

}