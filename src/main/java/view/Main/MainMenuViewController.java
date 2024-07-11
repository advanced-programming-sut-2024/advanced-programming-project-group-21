package view.Main;

import ClientServer.Client.TCPClient;
import controller.ApplicationController;
import controller.DataBaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User.User;
import view.Login.LoginMenuView;
import view.Pregame.PregameMenu;
import view.Pregame.PregameMenuView;
import view.Profile.ProfileMenuView;
import view.ScoreBoard.ScoreBoardView;

public class MainMenuViewController {
    public Label requestedPlayer;
    public Label requestStatus;
    public TextField playerToRequest;
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
        if (requestedPlayer.getText().equals("...")) return;
        int answer = Integer.parseInt(TCPClient.getInstance().acceptGameRequest(ApplicationController.getLoggedInUser().getUsername(),
                requestedPlayer.getText()));
        if(answer==0){
            requestStatus.setText("ENTER GAME");
        }
    }

    public void rejectGameRequest(MouseEvent mouseEvent) {
        if (requestedPlayer.getText().equals("...")) return;
        int answer = Integer.parseInt(TCPClient.getInstance().rejectGameRequest(ApplicationController.getLoggedInUser().getUsername(),
                requestedPlayer.getText()));
        if(answer==0){
            requestStatus.setText("...");
        }
    }

    public void checkForGameRequests(MouseEvent mouseEvent) {
        String response = TCPClient.getInstance().getGameRequest();
        //if (!response.equals("1") && !response.equals("2") && !response.equals("3"))
            requestedPlayer.setText(response);

    }

    public void sendRequest(MouseEvent mouseEvent) {
        int answer = Integer.parseInt(TCPClient.getInstance().requestGame(ApplicationController.getLoggedInUser().getUsername(),
                playerToRequest.getText()));
        if (answer == 1) {
            requestStatus.setText("Invalid token");
        } else if (answer == 2) {
            requestStatus.setText("No user found");
        } else if (answer == 3) {
            requestStatus.setText("User is in game");
        } else {
            requestStatus.setText("Request sent");
        }
    }
}
