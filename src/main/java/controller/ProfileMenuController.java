package controller;

import model.User.User;

public class ProfileMenuController {
    public void setLoggedInUser(User loggedInUser) {
        DataBaseController.saveLoggedInUser(loggedInUser);
    }
    public User getLoggedInUser() {
        return DataBaseController.loadLoggedInUser();
    }

    public void clearLoggedInUser() {
        DataBaseController.clearLoggedInUser();
    }

    public void showCurrentMenu(){

    }

    public void exitMenu(){

    }
    public void enterMenu(String name){

    }

    public void showGameHistory(int n){

    }
    public void showGameHistory(){
        showGameHistory(5);
    }

    public void showUserInfo(){}
}
