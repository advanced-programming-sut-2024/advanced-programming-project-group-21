package ClientServer.MessageClasses;

public class LogoutMessage extends ClientMessage{
    private String username;

    public LogoutMessage (String username) {
        this.username = username;
        this.type = ClientMessageType.logout;
    }

    public String getUsername() {
        return username;
    }
}
