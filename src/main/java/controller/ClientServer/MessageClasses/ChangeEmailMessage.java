package controller.ClientServer.MessageClasses;

public class ChangeEmailMessage extends ClientMessage{
    private String newEmail;

    public ChangeEmailMessage(String newEmail) {
        this.type = ClientMessageType.changeEmail;
        this.newEmail = newEmail;
    }

    public String getNewEmail() {
        return newEmail;
    }
}
