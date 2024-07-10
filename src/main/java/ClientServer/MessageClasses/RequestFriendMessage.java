package ClientServer.MessageClasses;

public class RequestFriendMessage extends ClientMessage{
    private String username;
    private String friendUsername;

    public RequestFriendMessage(String username, String friendUsername) {
        this.type = ClientMessageType.requestFriend;
        this.friendUsername = friendUsername;
        this.username = username;
    }

    public String getFriendUsername() {
        return friendUsername;
    }

    public String getUsername() {
        return username;
    }
}
