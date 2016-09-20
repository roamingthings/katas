package de.egga;

import org.junit.Test;

import static de.egga.DriverTest.anyDriver;
import static de.egga.DriverTest.assertThatBothDriversKnowEachOthersGossips;
import static de.egga.RouteTest.anyRoute;

public class ThingTest {

    @Test
    public void asd() {

        Driver anyDriver = anyDriver();
        Route anyRoute = anyRoute();

        Driver otherDriver = anyDriver();
        Route otherRoute = anyRoute();

        Thing thing = new Thing();

        thing.addGossipingDriver(anyDriver, anyRoute);
        thing.addGossipingDriver(otherDriver, otherRoute);

        thing.exchangeGossipsBetweenDrivers();

        assertThatBothDriversKnowEachOthersGossips(anyDriver, otherDriver);
    }
}
