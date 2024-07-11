package ClientServer.MessageClasses;

public class GetRequestFriendMessages extends ClientMessage{
    private String username;

    public GetRequestFriendMessages(String username) {
        this.type = ClientMessageType.getRequestFriend;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
