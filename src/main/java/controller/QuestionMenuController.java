package controller;

import model.User.User;

public class QuestionMenuController {
    public int submitAnswer(String username, String question, String answer, String newPass, String confirmPass) {
        User user = User.getUserByUsername(username);
        if (username.equals("")) {
            return 1;
        }
        if (question == null) {
            return 2;
        }
        if (answer.equals("")) {
            return 3;
        }
        if (user == null) {
            return 4;
        }
        if (!user.containsQuestion(question)) {
            return 5;
        }
        if (!user.getAnswer(question).equals(answer)) {
            return 6;
        }
        if (newPass.equals("")) {
            return 7;
        }
        if (confirmPass.equals("")) {
            return 8;
        }
        if (!newPass.equals(confirmPass)) {
            return 9;
        }
        return 0;
    }

    public int submitAnswer(String answer, String question) {
        if (question == null) {
            return 1;
        }
        if (answer.equals("")) {
            return 2;
        }
        return 0;
    }

    public void setUserNewPassword(String username, String newPass) {
        User user = User.getUserByUsername(username);
        assert user != null;
        user.setPassword(newPass);
    }
}
