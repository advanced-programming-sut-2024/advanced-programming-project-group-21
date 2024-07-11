package ClientServer.MessageClasses;

public class ForgetPasswordMessage extends ClientMessage {
    private String username;
    private String question;
    private String answer;
    private String newPassword;
    private String confirmPassword;

    public ForgetPasswordMessage(String username, String question, String answer,String newPassword, String confirmPassword) {
        this.type = ClientMessageType.forgetPassword;
        this.username = username;
        this.question = question;
        this.answer = answer;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
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
    public String getConfirmPassword() {
        return confirmPassword;
    }
}
