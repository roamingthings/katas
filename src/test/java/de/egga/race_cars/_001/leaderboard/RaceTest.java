package de.egga.race_cars._001.leaderboard;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static de.egga.race_cars._001.leaderboard.DriverFactory.*;
import static de.egga.race_cars._001.leaderboard.RaceFactory.RACE_NAME;
import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    private final Race race = RaceFactory.race(winner, second, third);

    @Test
    public void drivers_should_have_right_positions() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(race.position(winner)).isEqualTo(0);
        softly.assertThat(race.position(second)).isEqualTo(1);
        softly.assertThat(race.position(third)).isEqualTo(2);

        softly.assertAll();
    }

    @Test
    public void drivers_should_have_right_points() {
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(race.getPoints(winner)).isEqualTo(25);
        softly.assertThat(race.getPoints(second)).isEqualTo(18);
        softly.assertThat(race.getPoints(third)).isEqualTo(15);

        softly.assertAll();
    }

    @Test
    public void self_driving_car_name_should_be_altered() {
        SelfDrivingCar driver = selfDrivingCar();
        String driverName = RaceFactory.race(driver).getDriverName(driver);
        assertThat(driverName).isEqualTo("Self Driving Car - some company (some algo)");
    }

    @Test
    public void real_driver_name_should_not_be_altered() {
        Driver driver = realDriver();
        String driverName = RaceFactory.race(driver).getDriverName(driver);
        assertThat(driverName).isEqualTo("real name");
    }

    @Test
    public void to_string_should_return_race_name() {
        Race race = new Race(RACE_NAME);
        assertThat(race.toString()).isEqualTo(RACE_NAME);
    }

    @Test
    public void results_should_return_drivers_in_order() {
        assertThat(race.getResults()).containsExactly(winner, second, third);
    }
}
