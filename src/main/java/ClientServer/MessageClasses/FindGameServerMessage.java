package ClientServer.MessageClasses;

import model.Card;

import java.util.ArrayList;

public class FindGameServerMessage extends ClientMessage{
    private ArrayList<Card> deckCards;

    public FindGameServerMessage(ArrayList<Card> deckCards) {
        this.deckCards = deckCards;
        this.type = ClientMessageType.findGameServer;
    }


    public ArrayList<Card> getDeckCards() {
        return deckCards;
    }

}
