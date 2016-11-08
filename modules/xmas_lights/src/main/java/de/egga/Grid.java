package de.egga;

import java.util.ArrayList;
import java.util.List;

/**
 * @author egga
 */
public class Grid {

    private final int size;
    private List<List<Light>> lights = new ArrayList<>();

    public Grid(int size) {
        this.size = size;
        for (int x = 0; x < size; x++) {
            ArrayList<Light> row = new ArrayList<>();

            for (int y = 0; y < size; y++) {
                row.add(new Light());
            }

            lights.add(row);
        }
    }

    public void turnOn(int startX, int startY, int endX, int endY) {

        if (startX > maxIndex()) {
            return;
        }
        if (startY > maxIndex()) {
            return;
        }
        if (endX > maxIndex()) {
            endX = maxIndex();
        }
        if (endY > maxIndex()) {
            endY = maxIndex();
        }


        for (int currentX = startX; currentX <= endX; currentX++) {
            for (int currentY = startY; currentY <= endY; currentY++) {
                lights.get(currentX).get(currentY).turnOn();
            }
        }
    }

    public int maxIndex() {
        return size - 1;
    }

    public int countLights() {
        int sum = 0;

        for (List<Light> row : lights) {
            for (Light light : row) {
                if (light.isTurnedOn()) {
                    sum++;
                }
            }

        }
        return sum;
    }

    public void turnOff(int startX, int startY, int endX, int endY) {
        if (startX > maxIndex()) {
            return;
        }
        if (startY > maxIndex()) {
            return;
        }
        if (endX > maxIndex()) {
            endX = maxIndex();
        }
        if (endY > maxIndex()) {
            endY = maxIndex();
        }


        for (int currentX = startX; currentX <= endX; currentX++) {
            for (int currentY = startY; currentY <= endY; currentY++) {
                lights.get(currentX).get(currentY).turnOff();
            }
        }
    }

    public void toggle(int startX, int startY, int endX, int endY) {

        if (startX > maxIndex()) {
            return;
        }
        if (startY > maxIndex()) {
            return;
        }
        if (endX > maxIndex()) {
            endX = maxIndex();
        }
        if (endY > maxIndex()) {
            endY = maxIndex();
        }


        for (int currentX = startX; currentX <= endX; currentX++) {
            for (int currentY = startY; currentY <= endY; currentY++) {
                lights.get(currentX).get(currentY).toggle();
            }
        }
    }
}
