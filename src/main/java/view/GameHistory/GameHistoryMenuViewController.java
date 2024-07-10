package view.GameHistory;

import controller.ApplicationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.User.User;

import java.util.ArrayList;
import java.util.HashMap;

import model.Player;
import view.Profile.ProfileMenuView;


public class GameHistoryMenuViewController {
    User loggedInUser = ApplicationController.getLoggedInUser();

    @FXML
    private ScrollPane scrollPane;

    public void initialize() {
        displayLastGamesInfo(5);
    }

    public void displayLastGamesInfo(int numberOfGames) {
        ArrayList<HashMap<String, String>> lastGames = loggedInUser.getGameHistories();
        for (int i = lastGames.size(); i > ((lastGames.size()) - (numberOfGames)); i--) {

            VBox gameInfoBox = new VBox();
            for (HashMap<String, String> game : lastGames) {
                Label gameLabel = new Label(game.toString());
                gameInfoBox.getChildren().add(gameLabel);
            }
            scrollPane.setContent(gameInfoBox);
        }
    }

    public void back(ActionEvent actionEvent) {
        try {
            new ProfileMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}