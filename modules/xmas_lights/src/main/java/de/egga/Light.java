package de.egga;

public class Light {

    private boolean isTurnedOn = false;

    public void turnOn() {
        isTurnedOn = true;
    }

    public void turnOff() {
        isTurnedOn = false;

    }

    public void toggle() {
        if (isTurnedOn) {
            isTurnedOn =false;
        } else {
            isTurnedOn = true;
        }

    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }
}
