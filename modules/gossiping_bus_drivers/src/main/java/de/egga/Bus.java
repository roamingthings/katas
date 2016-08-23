package de.egga;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Iterables.cycle;
import static com.google.common.collect.Sets.newHashSet;

public class Bus {

    private final String driver;
    private final Iterator<Integer> stops;
    private Integer current;

    public Bus(String driver, List<Integer> stops) {
        this.driver = driver;
        this.stops = cycle(stops).iterator();
        goAhead();
    }

    public Integer currentStop() {
        return current;
    }

    public void goAhead() {
        current = stops.next();
    }

    public Set<String> knownGossips() {
        return newHashSet(driver);
    }
}
