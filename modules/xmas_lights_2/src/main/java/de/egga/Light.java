package de.egga;

public class Light {

    private int brightness;

    public Light() {
        turnOff();
    }

    public void turnOff() {
        brightness = 0;
    }

    public void turnOn() {
        brightness = 1;
    }

    public boolean isTurnedOn() {
        return brightness == 1;
    }

    public void toggle() {

        if (isTurnedOn()) {
            turnOff();

        } else {
            turnOn();

        }
    }

    public int getBrightness() {
        return brightness;
    }
}
