package de.egga.turn_ticket_dispenser;


public class TurnNumberSequence {

    private static int _turnNumber = 0;

    public static int getNextTurnNumber() {
        return _turnNumber++;
    }
}
