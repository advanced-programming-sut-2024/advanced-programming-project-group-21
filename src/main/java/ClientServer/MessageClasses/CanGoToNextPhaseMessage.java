package ClientServer.MessageClasses;

public class CanGoToNextPhaseMessage extends ClientMessage{
    public CanGoToNextPhaseMessage() {
        this.type = ClientMessageType.canGoToNextPhase;
    }
}
