package de.egga;

public class Coach {

    private final Driver driver;
    private final Route route;

    public Coach(Driver driver, Route route) {
        this.driver = driver;
        this.route = route;
    }

    public boolean isAtSameStop(Coach other) {
        return this.route.isAtSameStop(other.route);
    }

    public void exchangeGossips(Coach other) {
        this.driver.exchangeGossips(other.driver);
    }
}
