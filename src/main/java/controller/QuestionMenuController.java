package controller;

import model.User.User;

public class QuestionMenuController {
    public int submitAnswer(String username, String question, String answer, String pass, String confirm) {
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
        if (pass.equals("")) {
            return 7;
        }
        if (!pass.equals(confirm)) {
            return 8;
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

    public void changePassword(String username, String pass) {
        User user = User.getUserByUsername(username);
        assert user != null;
        user.setPassword(pass);
        ApplicationController.setLoggedInUser(user);
    }
}
