package controller;

import model.User.User;

public class QuestionMenuController {
    public int submitAnswer(String username, String question, String answer) {
        User user = User.getUserByUsername(username);
        if(username.equals("")){
            return 1;
        }
        if(question == null){
            return 2;
        }
        if(answer.equals("")){
            return 3;
        }
        if(user == null){
            return 4;
        }
        if(!user.containsQuestion(question)){
            return 5;
        }
        if(!user.getAnswer(question).equals(answer)){
            return 6;
        }
        return 0;
    }
}
