package controller.ClientServer.MessageClasses;

import org.testng.IConfigurable;

public class SignupMessage extends ClientMessage {
    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String nickname;

    public SignupMessage(String username, String password, String email, String nickname, String confirmPassword) {
        this.type = ClientMessageType.signup;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
