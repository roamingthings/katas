package de.egga;

import java.util.Iterator;

import static com.google.common.collect.Iterables.cycle;
import static java.util.Arrays.asList;

public class Route {

    private final Iterator<Integer> stops;
    private Integer currentStop;

    public Route(Integer... route) {
        this.stops = cycle(asList(route)).iterator();
        currentStop = stops.next();
    }

    public boolean isAtStop(int stop) {
        return stop == currentStop;
    }

    public void proceed() {
        currentStop = stops.next();
    }
}
