package ClientServer.MessageClasses;

public class GetEnemyDeckMessage extends ClientMessage{

    public GetEnemyDeckMessage() {
        this.type = ClientMessageType.getEnemyDeck;
    }

}
