package controller.ClientServer.MessageClasses;

public class ChangeUsernameMessage extends ClientMessage{
    private String newUsername;

    public ChangeUsernameMessage(String newUsername) {
        this.type = ClientMessageType.changeUsername;
        this.newUsername = newUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }
}
