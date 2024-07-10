package ClientServer.MessageClasses;

public class EndGameMessage extends ClientMessage{
    public EndGameMessage() {
        this.type = ClientMessageType.endGame;
    }
}
