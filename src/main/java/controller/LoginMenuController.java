package controller;

import model.User.User;

public class LoginMenuController {

    public void showCurrentMenu(){

    }

    public void exitMenu(){

    }

    public boolean enterMenu(String name){
        if(name.equals("register menu")){
            // TODO: (if console is required)
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isUsernameMade(String username){
        return false;
    }

    public int loginUser(String username, String password){
        // 3: Empty username. 2: User doesn't exist. 1: Wrong password. 0: Ok
        User user = User.getUserByUsername(username);
        if (username.equals("")) return 3;
        if (user == null) return 2;
        if (!user.getPassword().equals(password)) return 1;
        ApplicationController.setLoggedInUser(user);
        return 0;
    }

    public void forgetPassword(String username){

    }

    public void answerQuestion(int questionNumber, String answer){

    }

    public void setNewPassword(String password){

    }
}