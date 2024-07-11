package ClientServer.MessageClasses;

public class GetRequestGameMessage extends ClientMessage{
    private String username;

    public GetRequestGameMessage(String username) {
        this.type = ClientMessageType.getRequestGame;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
