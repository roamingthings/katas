package de.egga;

import org.junit.Test;

import static de.egga.DriverTest.anyDriver;
import static de.egga.DriverTest.assertThatBothDriversDoNotKnowEachOthersGossips;
import static de.egga.DriverTest.assertThatBothDriversKnowEachOthersGossips;
import static de.egga.RouteTest.FIRST_STOP;
import static de.egga.RouteTest.SECOND_STOP;
import static de.egga.RouteTest.anyRoute;

public class AppTest {

    @Test
    public void drivers_on_the_same_stop_should_learn_each_others_gossips() {

        Driver thisDriver = anyDriver();
        Route thisRoute = anyRoute();

        Driver otherDriver = anyDriver();
        Route otherRoute = anyRoute();

        App app = new App();

        app.addCoach(new Coach(thisDriver, thisRoute));
        app.addCoach(new Coach(otherDriver, otherRoute));

        app.exchangeGossipsBetweenDrivers();

        assertThatBothDriversKnowEachOthersGossips(thisDriver, otherDriver);
    }

    @Test
    public void drivers_on_different_stop_should_not_learn_each_others_gossips() {

        Driver thisDriver = anyDriver();
        Route thisRoute = anyRoute();

        Driver otherDriver = anyDriver();
        Route otherRoute = new Route(SECOND_STOP, 3, FIRST_STOP);

        App app = new App();
        app.addCoach(new Coach(thisDriver, thisRoute));
        app.addCoach(new Coach(otherDriver, otherRoute));


        app.exchangeGossipsBetweenDrivers();

        assertThatBothDriversDoNotKnowEachOthersGossips(thisDriver, otherDriver);
    }
}
