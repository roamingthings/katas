package de.egga;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private final List<List<Light>> lights;

    public Grid() {
        lights = new ArrayList<>();
        for (int x = 0; x < 1000; x++) {

            ArrayList<Light> column = new ArrayList<>();
            for (int y = 0; y < 1000; y++) {
                column.add(new Light());
            }
            lights.add(column);
        }
    }

    public void turnOn(Range range) {
        for (Coordinate coordinate : range.getCoordinates()) {
            lights.get(coordinate.x).get(coordinate.y).turnOn();
        }
    }

    public Integer countBurningLights() {
        int sum = 0;
        for (List<Light> column : lights) {
            for (Light light : column) {
                sum += light.getBrightness();
            }

        }

        return sum;
    }

    public void toggle(Range range) {
        for (Coordinate coordinate : range.getCoordinates()) {
            lights.get(coordinate.x).get(coordinate.y).toggle();
        }
    }

    public void turnOff(Range range) {
        for (Coordinate coordinate : range.getCoordinates()) {
            lights.get(coordinate.x).get(coordinate.y).turnOff();
        }
    }
}
