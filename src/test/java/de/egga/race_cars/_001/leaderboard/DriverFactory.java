package de.egga.race_cars._001.leaderboard;

public class DriverFactory {

    public static final String COUNTRY_NAME = "some country";
    public static final String ALGORITHM_VERSION = "some algo";
    public static final String COMPANY_NAME = "some company";

    public static final Driver third = new Driver("some third", COUNTRY_NAME);
    public static final Driver second = new Driver("some second", COUNTRY_NAME);
    public static final Driver winner = new Driver("some winner", COUNTRY_NAME);

    public static SelfDrivingCar selfDrivingCar() {
        return new SelfDrivingCar(ALGORITHM_VERSION, COMPANY_NAME);
    }

    public static Driver realDriver() {
        return new Driver("real name", COUNTRY_NAME);
    }
}
