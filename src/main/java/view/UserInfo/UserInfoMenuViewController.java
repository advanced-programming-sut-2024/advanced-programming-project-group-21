package view.UserInfo;

import controller.ApplicationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.User.User;
import view.Profile.ProfileMenuView;

public class

UserInfoMenuViewController {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label nicknameLabel;
    @FXML
    private Label HighestScoreLabel;
    @FXML
    private Label RankLabel;
    @FXML
    private Label playedGamesLabel;
    @FXML
    private Label drawsLabel;
    @FXML
    private Label winsLabel;
    @FXML
    private Label losesLabel;
    User currentUser = ApplicationController.getLoggedInUser();

    public void initialize() {
        if (currentUser == null) {
            usernameLabel.setText("User not found");
            nicknameLabel.setText("User not found");
            HighestScoreLabel.setText("User not found");
            RankLabel.setText("User not found");
            playedGamesLabel.setText("User not found");
            drawsLabel.setText("User not found");
            winsLabel.setText("User not found");
            losesLabel.setText("User not found");
            return;
        }
        usernameLabel.setText(currentUser.getUsername());
        nicknameLabel.setText(currentUser.getNickname());
        HighestScoreLabel.setText(String.valueOf(currentUser.getHighestScore()));
        RankLabel.setText(String.valueOf(currentUser.getRank()));
        playedGamesLabel.setText(String.valueOf(currentUser.getGamesPlayed()));
        drawsLabel.setText(String.valueOf(currentUser.getDraw()));
        winsLabel.setText(String.valueOf(currentUser.getWins()));
        losesLabel.setText(String.valueOf(currentUser.getLose()));
    }


    public void showUsername(ActionEvent actionEvent) {
        if (currentUser != null) {
            usernameLabel.setText(currentUser.getUsername());
        }

    }

    public void showNickname(ActionEvent actionEvent) {
        if (currentUser != null) {
            nicknameLabel.setText(currentUser.getNickname());
        }

    }

    public void showHighestScore(ActionEvent actionEvent) {
        if (currentUser != null) {
            HighestScoreLabel.setText(String.valueOf(currentUser.getHighestScore()));
        }

    }

    public void showRank(ActionEvent actionEvent) {
        if (currentUser != null) {
            RankLabel.setText(String.valueOf(currentUser.getRank()));
        }

    }

    public void showPlayedGames(ActionEvent actionEvent) {
        if (currentUser != null) {
            playedGamesLabel.setText(String.valueOf(currentUser.getGamesPlayed()));
        }

    }

    public void showDraws(ActionEvent actionEvent) {
        if (currentUser != null) {
            drawsLabel.setText(String.valueOf(currentUser.getDraw()));
        }

    }

    public void showWins(ActionEvent actionEvent) {
        if (currentUser != null) {
            winsLabel.setText(String.valueOf(currentUser.getWins()));
        }

    }

    public void showLoses(ActionEvent actionEvent) {
        if (currentUser != null) {
            losesLabel.setText(String.valueOf(currentUser.getLose()));
        }

    }

    public void goToProfileMenu(MouseEvent mouseEvent) {
        try {
            new ProfileMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
