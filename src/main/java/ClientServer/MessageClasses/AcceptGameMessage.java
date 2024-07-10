package ClientServer.MessageClasses;

public class AcceptGameMessage extends ClientMessage{
    private String username;
    private String friendName;
    private boolean accept;

    public AcceptGameMessage(String username, String friendName, boolean accept) {
        this.type = ClientMessageType.acceptGame;
        this.username = username;
        this.friendName = friendName;
        this.accept = accept;
    }

    public String getUsername() {
        return username;
    }

    public String getFriendName() {
        return friendName;
    }

    public boolean isAccept() {
        return accept;
    }
}
