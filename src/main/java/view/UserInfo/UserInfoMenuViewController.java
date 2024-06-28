package view.UserInfo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.User.User;

public class UserInfoMenuViewController {

    @FXML
    private Label usernameLabel;
    private Label nicknameLabel;
    private Label HighestScoreLabel;
    private Label RankLabel;
    private Label playedGamesLabel;
    private Label drawsLabel;
    private Label winsLabel;
    private Label losesLabel;
    User currentUser = User.getLoggedInUser();


    public void showUsername(ActionEvent actionEvent) {
        if (currentUser != null) {
            usernameLabel.setText(currentUser.getUsername());
        } else {
            usernameLabel.setText("User not found");
        }
    }

    public void showNickname(ActionEvent actionEvent) {
        if (currentUser != null) {
            nicknameLabel.setText(currentUser.getNickname());
        } else {
            nicknameLabel.setText("User not found");
        }
    }

    public void showHighestScore(ActionEvent actionEvent) {
        if (currentUser != null) {
            HighestScoreLabel.setText(String.valueOf(currentUser.getHighestScore()));
        } else {
            HighestScoreLabel.setText("User not found");
        }
    }

    public void showRank(ActionEvent actionEvent) {
        if (currentUser != null) {
            RankLabel.setText(String.valueOf(currentUser.getRank()));
        } else {
            RankLabel.setText("User not found");
        }
    }

    public void showPlayedGames(ActionEvent actionEvent) {
        if (currentUser != null) {
            playedGamesLabel.setText(String.valueOf(currentUser.getGamesPlayed()));
        } else {
            playedGamesLabel.setText("User not found");
        }
    }

    public void showDraws(ActionEvent actionEvent) {
        if (currentUser != null) {
            drawsLabel.setText(String.valueOf(currentUser.getDraw()));
        } else {
            drawsLabel.setText("User not found");
        }
    }

    public void showWins(ActionEvent actionEvent) {
        if (currentUser != null) {
            winsLabel.setText(String.valueOf(currentUser.getWins()));
        } else {
            winsLabel.setText("User not found");
        }
    }

    public void showLoses(ActionEvent actionEvent) {
        if (currentUser != null) {
            losesLabel.setText(String.valueOf(currentUser.getLose()));
        } else {
            losesLabel.setText("User not found");
        }
    }
}
