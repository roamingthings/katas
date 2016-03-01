package de.egga.race_cars._001.leaderboard;

public class TestData {

    public static Driver driver1= new Driver("Nico Rosberg", "DE");
    public static Driver driver2= new Driver("Lewis Hamilton", "UK");
    public static Driver driver3= new Driver("Sebastian Vettel", "DE");
    public static SelfDrivingCar driver4;

    public static Leaderboard sampleLeaderboard1;

    static {
        Race race1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race race2 = new Race("Malaysian Grand Prix", driver3, driver2, driver1);
        Race race3 = new Race("Chinese Grand Prix", driver2, driver1, driver3);

        sampleLeaderboard1 = new Leaderboard(race1, race2, race3);


        driver4 = new SelfDrivingCar("1.2", "Acme");
        driver4.setAlgorithmVersion("1.3");
    }
}