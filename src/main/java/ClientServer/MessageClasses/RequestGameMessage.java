package ClientServer.MessageClasses;

public class RequestGameMessage extends ClientMessage{
    private String username;
    private String friendUsername;

    public RequestGameMessage(String username, String friendName) {
        this.type = ClientMessageType.requestGame;
        this.friendUsername = friendName;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getFriendUsername() {
        return friendUsername;
    }
}
