package controller;

import javafx.stage.Stage;
import model.Game;
import model.User.User;

import java.util.Random;

public class ApplicationController {
    private static Stage stage;
    private static User loggedInUser;
    private static boolean UserAGuest;
    public static final Random random = new Random();
    public static Game game = null;

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ApplicationController.stage = stage;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        ApplicationController.loggedInUser = loggedInUser;
    }

    public static boolean isUserAGuest() {
        return UserAGuest;
    }

    public static void setUserAGuest(boolean userAGuest) {
        UserAGuest = userAGuest;
    }

}
