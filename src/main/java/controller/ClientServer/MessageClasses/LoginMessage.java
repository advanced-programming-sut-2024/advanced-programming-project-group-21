package controller.ClientServer.MessageClasses;

public class LoginMessage extends ClientMessage{
    private String username;
    private String password;

    public LoginMessage(String username, String password) {
        this.type = ClientMessageType.login;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
