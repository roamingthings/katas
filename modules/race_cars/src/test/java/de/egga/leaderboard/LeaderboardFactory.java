package de.egga.leaderboard;

public class LeaderboardFactory {

    public static Leaderboard board(Driver... drivers) {
        Race race = RaceFactory.race(drivers);
        return new Leaderboard(race);
    }
}
