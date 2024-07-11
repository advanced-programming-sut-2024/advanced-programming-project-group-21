package view.Main;

import ClientServer.Client.TCPClient;
import controller.ApplicationController;
import controller.DataBaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.User.User;
import view.Login.LoginMenuView;
import view.Pregame.PregameMenu;
import view.Pregame.PregameMenuView;
import view.Profile.ProfileMenuView;
import view.ScoreBoard.ScoreBoardView;

public class MainMenuViewController {
    public Label requestedPlayer;
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
        String result = TCPClient.getInstance().logout(ApplicationController.getLoggedInUser().getUsername());
        if (result.equals("logged out successfully")) {
            ApplicationController.setLoggedInUser(null);
            DataBaseController.saveUsersToJson();
            try {
                new LoginMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("!");
        }
    }

    public void exitGame(MouseEvent mouseEvent) {
        DataBaseController.saveUsersToJson();
        System.exit(0);
    }

    public void goToScoreboard(MouseEvent mouseEvent) {
        try {
            new ScoreBoardView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void acceptGameRequest(MouseEvent mouseEvent) {
        //TCPClient.getInstance().acceptGameRequest();
    }

    public void rejectGameRequest(MouseEvent mouseEvent) {
        //TCPClient.getInstance().rejectGameRequest();
    }

    public void checkForGameRequests(MouseEvent mouseEvent) {
        //TCPClient.getInstance().checkForGameRequest();
    }
}
