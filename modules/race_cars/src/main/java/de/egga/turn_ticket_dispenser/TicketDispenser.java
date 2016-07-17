package de.egga.turn_ticket_dispenser;

public class TicketDispenser {

    public TurnTicket getTurnTicket() {
        int newTurnNumber = TurnNumberSequence.getNextTurnNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}