package de.egga.bowling._004;

public class Game {

    private final ScoreService scoreService;
    private final FrameService frameService;

    public Game(ScoreService scoreService, FrameService frameService) {
        this.scoreService = scoreService;
        this.frameService = frameService;
    }

    public int score() {
        return scoreService.calculateScore();
    }

    public void roll(int numberOfPins) {
        frameService.addRoll(numberOfPins);
    }
}
