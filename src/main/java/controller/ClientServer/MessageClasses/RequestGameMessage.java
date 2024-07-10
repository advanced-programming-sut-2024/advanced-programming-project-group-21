package controller.ClientServer.MessageClasses;

public class RequestGameMessage extends ClientMessage{
    private String username;
    private String friendName;

    public RequestGameMessage(String username, String friendName) {
        this.type = ClientMessageType.requestGame;
        this.username = username;
        this.friendName = friendName;
    }

    public String getUsername() {
        return username;
    }

    public String getFriendName() {
        return friendName;
    }
}
