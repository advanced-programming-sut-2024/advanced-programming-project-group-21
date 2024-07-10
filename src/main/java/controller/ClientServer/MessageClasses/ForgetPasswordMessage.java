package controller.ClientServer.MessageClasses;

public class ForgetPasswordMessage extends ClientMessage {
    private String username;
    private String question;
    private String answer;
    private String newPassword;

    public ForgetPasswordMessage(String username, String question, String answer, String newPassword) {
        this.type = ClientMessageType.forgetPassword;
        this.username = username;
        this.question = question;
        this.answer = answer;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
