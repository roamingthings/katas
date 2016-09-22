package de.egga;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {

    @Test
    public void both_drivers_should_learn_each_others_gossips() {
        Driver thisDriver = anyDriver();
        Driver other = anyDriver();

        thisDriver.exchangeGossips(other);

        assertThatBothDriversKnowEachOthersGossips(thisDriver, other);
    }

    @Test
    public void driver_should_not_know_gossip_of_other() {
        Driver driver = anyDriver();

        assertThat(driver.knowsGossipsOf(anyDriver())).isFalse();
    }

    @Test
    public void driver_should_know_own_gossip() {
        Driver driver = anyDriver();

        assertThat(driver.knowsGossipsOf(driver)).isTrue();
    }

    @Test
    public void driver_should_tell_all_the_gossips_learned_so_far() {
        Driver driver1 = anyDriver();
        Driver driver2 = anyDriver();
        Driver driver3 = anyDriver();

        driver1.exchangeGossips(driver2);
        driver1.exchangeGossips(driver3);

        assertThatBothDriversKnowEachOthersGossips(driver1, driver2);
        assertThatBothDriversKnowEachOthersGossips(driver1, driver3);
        assertThat(driver2.knowsGossipsOf(driver3)).isFalse();
        assertThat(driver3.knowsGossipsOf(driver2)).isTrue();
    }



    public static Driver anyDriver() {
        return new Driver();
    }


    public static void assertThatBothDriversKnowEachOthersGossips(Driver driver, Driver other) {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(driver.knowsGossipsOf(other)).isTrue();
        assertions.assertThat(other.knowsGossipsOf(driver)).isTrue();
        assertions.assertAll();
    }
    public static void assertThatBothDriversDoNotKnowEachOthersGossips(Driver driver, Driver other) {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(driver.knowsGossipsOf(other)).isFalse();
        assertions.assertThat(other.knowsGossipsOf(driver)).isFalse();
        assertions.assertAll();
    }

}