package controller.ClientServer.MessageClasses;

import java.util.ArrayList;

public class PreGameMessage extends ClientMessage{
    private ArrayList<Integer> cardIds;
    private int commanderId;
    private int factionId;

    public PreGameMessage(ArrayList<Integer> cardIds, int commanderId, int factionId) {
        this.type = ClientMessageType.preGame;
        this.cardIds = cardIds;
        this.commanderId = commanderId;
        this.factionId = factionId;
    }

    public ArrayList<Integer> getCardIds() {
        return cardIds;
    }

    public int getCommanderId() {
        return commanderId;
    }

    public int getFactionId() {
        return factionId;
    }
}
