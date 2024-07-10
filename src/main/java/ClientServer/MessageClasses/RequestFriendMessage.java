package ClientServer.MessageClasses;

public class RequestFriendMessage extends ClientMessage{
    private String friendUsername;

    public RequestFriendMessage(String friendUsername) {
        this.type = ClientMessageType.requestFriend;
        this.friendUsername = friendUsername;
    }

    public String getFriendUsername() {
        return friendUsername;
    }
}
