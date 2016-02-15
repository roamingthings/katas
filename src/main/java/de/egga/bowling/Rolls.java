package de.egga.bowling;

import java.util.ArrayList;
import java.util.List;


public class Rolls {

    public static final int TOTAL_NUMBER_OF_PINS = 10;
    public static final int ROLLS_PER_FRAME = 2;


    private List<Integer> pinsKnockedDown = new ArrayList<>();

    public void add(int numberOfPins) {
        pinsKnockedDown.add(numberOfPins);
    }

    public int getNUmberOfPinsKnockedDown() {
        int sum = 0;
        for (Integer roll : pinsKnockedDown) {
            sum += roll;
        }
        return sum;
    }

    public int getSpareBonus() {
        return pinsKnockedDown.get(0);
    }

    public int getStrikeBonus() {
        return getNUmberOfPinsKnockedDown();
    }

    public int pinsLeft() {
        return TOTAL_NUMBER_OF_PINS - getNUmberOfPinsKnockedDown();
    }

    public int rollsLeft() {
        return ROLLS_PER_FRAME - pinsKnockedDown.size();
    }
}
