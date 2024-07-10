package ClientServer.MessageClasses;

import java.util.ArrayList;

public class VetoMessage extends ClientMessage {
    private ArrayList<Integer> cardIdsToVeto;
    private ArrayList<Integer> newCardIds;

    public VetoMessage(ArrayList<Integer> cardIdsToVeto, ArrayList<Integer> newCardIds) {
        this.type = ClientMessageType.veto;
        this.cardIdsToVeto = cardIdsToVeto;
        this.newCardIds = newCardIds;
    }

    public ArrayList<Integer> getCardIdsToVeto() {
        return cardIdsToVeto;
    }

    public ArrayList<Integer> getNewCardIds() {
        return newCardIds;
    }
}
