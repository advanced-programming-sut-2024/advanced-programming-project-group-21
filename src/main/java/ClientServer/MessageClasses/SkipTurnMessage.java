package ClientServer.MessageClasses;

public class SkipTurnMessage extends ClientMessage{
    public SkipTurnMessage() {
        this.type = ClientMessageType.skipTurn;
    }
}
