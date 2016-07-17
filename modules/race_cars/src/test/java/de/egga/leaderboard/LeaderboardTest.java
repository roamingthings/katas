package de.egga.leaderboard;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static de.egga.leaderboard.LeaderboardFactory.board;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeaderboardTest {

    Race race1 = RaceFactory.race(TestData.driver1, TestData.driver2, TestData.driver3);
    Race race2 = RaceFactory.race(TestData.driver3, TestData.driver2, TestData.driver1);
    Race race3 = RaceFactory.race(TestData.driver2, TestData.driver1, TestData.driver3);

    Leaderboard leaderboard = new Leaderboard(race1, race2, race3);

    @Test
    public void itShouldSumThePoints() {
        Map<String, Integer> results = leaderboard.driverResults();
        assertTrue("results " + results, results.containsKey("Lewis Hamilton"));
        assertEquals(18 + 18 + 25, (int) results.get("Lewis Hamilton"));
    }

    @Test
    public void self_driving_car_name_should_be_translated() {
        List<String> rankings = board(DriverFactory.selfDrivingCar()).driverRankings();
        assertThat(rankings.get(0)).isEqualTo("Self Driving Car - some company (some algo)");
    }

    @Test
    public void self_driving_car_name_should_be_translated2s() {
        List<String> rankings = board(DriverFactory.winner, DriverFactory.second, DriverFactory.third).driverRankings();
        assertThat(rankings).containsExactly(DriverFactory.winner.getName(), DriverFactory.second.getName(), DriverFactory.third.getName());
    }

    @Test
    public void isShouldFindTheWinner() {
        assertEquals("Lewis Hamilton", leaderboard.driverRankings().get(0));
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePoints() {
        // bug, drops drivers with same points
        Race winDriver1 = RaceFactory.race(TestData.driver1, TestData.driver2, TestData.driver3);
        Race winDriver2 = RaceFactory.race(TestData.driver2, TestData.driver1, TestData.driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        List<String> rankings = exEquoLeaderBoard.driverRankings();
        assertEquals(Arrays.asList(TestData.driver1.getName(), TestData.driver2.getName(), TestData.driver3.getName()), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
