package de.egga;

import java.util.HashSet;
import java.util.Set;

public class Driver {

    private final Set<Driver> gossips = new HashSet<>();

    public Driver() {
        gossips.add(this);
    }

    public void exchangeGossips(Driver other) {
        this.addGossip(other);
        other.addGossip(this);
    }

    public boolean knowsGossipsOf(Driver other) {
        return gossips.contains(other);
    }


    private void addGossip(Driver other) {
        gossips.addAll(other.gossips);
    }
}
