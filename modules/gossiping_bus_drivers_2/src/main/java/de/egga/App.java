package de.egga;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {

    private final Map<Driver, Route> asd = new HashMap<>();

    private final Set<Coach> coaches = new HashSet<>();

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }


    public void exchangeGossipsBetweenDrivers() {

        for (Coach thisCoach : coaches) {
            for (Coach otherCoach : coaches) {
                if (thisCoach.isAtSameStop(otherCoach)) {
                    thisCoach.exchangeGossips(otherCoach);
                }
            }
        }
    }
}
