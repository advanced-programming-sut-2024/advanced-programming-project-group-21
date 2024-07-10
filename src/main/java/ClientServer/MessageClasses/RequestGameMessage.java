package ClientServer.MessageClasses;

public class RequestGameMessage extends ClientMessage{
    private String friendName;

    public RequestGameMessage(String username, String friendName) {
        this.type = ClientMessageType.requestGame;
        this.friendName = friendName;
    }

    public String getFriendName() {
        return friendName;
    }
}
