package de.egga.race_cars._001.leaderboard;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    public static final String RACE_NAME = "some race";
    public static final String COUNTRY_NAME = "some country";
    public static final String ALGORITHM_VERSION = "some algo";
    public static final String COMPANY_NAME = "some company";

    Driver winner = new Driver("some winner", COUNTRY_NAME);
    Driver second = new Driver("some second", COUNTRY_NAME);
    Driver third = new Driver("some third", COUNTRY_NAME);
    Race race = new Race(RACE_NAME, winner, second, third);

    SelfDrivingCar selfDrivingCar = new SelfDrivingCar(ALGORITHM_VERSION, COMPANY_NAME);

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
        Race race = new Race(RACE_NAME, selfDrivingCar);
        String driverName = race.getDriverName(selfDrivingCar);
        assertThat(driverName).isEqualTo("Self Driving Car - some company (some algo)");
    }

    @Test
    public void real_driver_name_should_not_be_altered() {
        Driver realDriver = new Driver("real name", COUNTRY_NAME);
        Race race = new Race(RACE_NAME, realDriver);
        String driverName = race.getDriverName(realDriver);
        assertThat(driverName).isEqualTo("real name");
    }

    @Test
    public void to_string_should_return_race_name() {
        assertThat(race.toString()).isEqualTo(RACE_NAME);
    }

    @Test
    public void results_should_return_drivers_in_order() {
        assertThat(race.getResults()).containsExactly(winner, second, third);
    }
}
