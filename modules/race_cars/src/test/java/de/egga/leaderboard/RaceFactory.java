package de.egga.leaderboard;

public class RaceFactory {

    public static final String RACE_NAME = "some race";

    public static Race race(Driver... drivers) {
        return new Race(RACE_NAME, drivers);
    }
}
