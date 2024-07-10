package controller.ClientServer.MessageClasses;

public class AcceptFriendMessage extends ClientMessage{
    private String username;
    private String friendName;
    private boolean accept;

    public AcceptFriendMessage(String username, String friendName, boolean accept) {
        this.type = ClientMessageType.acceptFriend;
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
