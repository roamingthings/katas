package de.egga.race_cars._001.turn_ticket_dispenser;


public class TurnNumberSequence {

    private static int _turnNumber = 0;

    public static int getNextTurnNumber() {
        return _turnNumber++;
    }
}
