package ClientServer.MessageClasses;

public class ChangePasswordMessage extends ClientMessage {
    private String oldPassword;
    private String newPassword;

    public ChangePasswordMessage(String oldPassword, String newPassword) {
        this.type = ClientMessageType.changePassword;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
