package de.egga.race_cars._001.leaderboard;

public class LeaderboardFactory {

    public static Leaderboard board(Driver... drivers) {
        Race race = RaceFactory.race(drivers);
        return new Leaderboard(race);
    }
}
