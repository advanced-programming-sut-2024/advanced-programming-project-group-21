package view.Main;

import controller.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.User.User;
import view.Login.LoginMenuView;
import view.Pregame.PregameMenu;
import view.Pregame.PregameMenuView;
import view.Profile.ProfileMenuView;
import view.ScoreBoard.ScoreBoardView;

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
        try {
            new PregameMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        User.saveUsersToJson();
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

    public void goToScoreboard(MouseEvent mouseEvent) {
        try {
            new ScoreBoardView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
