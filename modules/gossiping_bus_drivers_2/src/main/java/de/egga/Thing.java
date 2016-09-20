package de.egga;

import java.util.HashMap;
import java.util.Map;

public class Thing {

    private final Map<Driver, Route> asd = new HashMap<>();

    public void addGossipingDriver(Driver driver, Route route) {
        asd.put(driver, route);
    }

    public void exchangeGossipsBetweenDrivers() {

    }
}
