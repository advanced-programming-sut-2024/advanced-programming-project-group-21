package view.Main;

import controller.ApplicationController;
import javafx.scene.input.MouseEvent;
import view.Login.LoginMenuView;
import view.Profile.ProfileMenuView;

public class MainMenuViewController {
    public void goToPreGameMenu(MouseEvent mouseEvent) {

    }

    public void goToProfileMenu(MouseEvent mouseEvent) {
        try {
            new ProfileMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logout(MouseEvent mouseEvent) {
        ApplicationController.setLoggedInUser(null);
        try {
            new LoginMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exitGame(MouseEvent mouseEvent) {
        System.exit(0);
    }
}
