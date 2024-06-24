package view.Main;

import controller.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.User.User;
import view.Login.LoginMenuView;
import view.Profile.ProfileMenuView;

public class MainMenuViewController {
    @FXML
    private Button Start;
    @FXML
    private Button ProfileMenu;
    @FXML
    private Button Logout;
    @FXML
    private Button Exit;
    @FXML
    private Button Back;
    @FXML
    private Button Setting;

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
        User.saveUsersToJson();
        System.exit(0);
    }

    public void goToSettingMenu(MouseEvent mouseEvent) {
    }
}
