package de.egga;

public class Game {

    private final RollRepository rollRepository;

    public Game(RollRepository rollRepository) {
        this.rollRepository = rollRepository;
    }

    public void roll(int numberOfPins) {
        rollRepository.save(numberOfPins);
    }

    public int score() {
        return rollRepository.getSum();
    }
}
