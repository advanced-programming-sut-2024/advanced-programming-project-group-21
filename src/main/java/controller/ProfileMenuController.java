package controller;

import model.User.User;

public class ProfileMenuController {
    public void setLoggedInUser(User loggedInUser) {
        DataBaseController.saveLoggedInUser(loggedInUser);
    }

    public void clearLoggedInUser() {
        DataBaseController.clearLoggedInUser();
    }
}
