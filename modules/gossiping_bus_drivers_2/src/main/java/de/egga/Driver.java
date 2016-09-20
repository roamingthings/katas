package de.egga;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    private final List<Driver> gossips= new ArrayList<>();

    public Driver() {
        this.addGossip(this);
    }

    public void exchangeGossips(Driver other) {
        this.addGossip(other);
        other.addGossip(this);
    }

    public boolean knowsGossipsOf(Driver other) {
        return gossips.contains(other);
    }


    private void addGossip(Driver other) {
        gossips.add(other);
    }
}
