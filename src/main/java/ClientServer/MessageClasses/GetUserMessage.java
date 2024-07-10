package ClientServer.MessageClasses;

public class GetUserMessage extends ClientMessage{
    private String username;

    public GetUserMessage(String username) {
        this.type = ClientMessageType.getUser;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
