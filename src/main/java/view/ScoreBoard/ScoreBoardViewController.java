package view.ScoreBoard;

import controller.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.User.User;
import view.Main.MainMenuView;
import view.Main.MainMenuViewController;
import view.UserInfo.UserInfoMenuView;

import static java.lang.Math.min;

public class ScoreBoardViewController {
    @FXML
    private Label username1;
    @FXML
    private Label score1;
    @FXML
    private Label wins1;
    @FXML
    private Label username2;
    @FXML
    private Label score2;
    @FXML
    private Label wins2;
    @FXML
    private Label username3;
    @FXML
    private Label score3;
    @FXML
    private Label wins3;
    @FXML
    private Label username4;
    @FXML
    private Label score4;
    @FXML
    private Label wins4;
    @FXML
    private Label username5;
    @FXML
    private Label score5;
    @FXML
    private Label wins5;
    @FXML
    private Label username6;
    @FXML
    private Label score6;
    @FXML
    private Label wins6;
    @FXML
    private Label username7;
    @FXML
    private Label score7;
    @FXML
    private Label wins7;
    @FXML
    private Label username8;
    @FXML
    private Label score8;
    @FXML
    private Label wins8;
    @FXML
    private Label username9;
    @FXML
    private Label score9;
    @FXML
    private Label wins9;
    @FXML
    private Label username10;
    @FXML
    private Label score10;
    @FXML
    private Label wins10;

    public void initialize() {
        int[] possible = new int[User.getUsers().size()];
        int maxNumber = -1;
        for (int i = 0; i < User.getUsers().size(); i++)
            possible[i] = 1;
        int size = min(10, User.getUsers().size());
        for (int i = 0; i < size; i++) {
            User max = null;
            for (int j = 0; j < User.getUsers().size(); j++) {
                if (max == null && possible[j] == 1) {
                    max = User.getUsers().get(j);
                    maxNumber = j;
                } else {
                    if (possible[j] == 1 && max.getHighestScore() < User.getUsers().get(j).getHighestScore()) {
                        max = User.getUsers().get(j);
                        maxNumber = j;
                    } else if (possible[j] == 1 && max.getHighestScore() == User.getUsers().get(j).getHighestScore() && max.getWins() > User.getUsers().get(j).getWins()) {
                        max = User.getUsers().get(j);
                        maxNumber = j;
                    }
                }
            }
            possible[maxNumber] = 0;
            String username = max.getUsername();
            String score = String.valueOf(max.getHighestScore());
            String wins = String.valueOf(max.getWins());

            if (i == 0) {
                username1.setText(username);
                score1.setText(score);
                wins1.setText(wins);

            }
            if (i == 1) {
                username2.setText(username);
                score2.setText(score);
                wins2.setText(wins);
            }
            if (i == 2) {
                username3.setText(max.getUsername());
                score3.setText(String.valueOf(max.getHighestScore()));
                wins3.setText(wins);
            }
            if (i == 3) {
                username4.setText(max.getUsername());
                score4.setText(String.valueOf(max.getHighestScore()));
                wins4.setText(wins);
            }
            if (i == 4) {
                username5.setText(max.getUsername());
                score5.setText(String.valueOf(max.getHighestScore()));
                wins5.setText(wins);
            }
            if (i == 5) {
                username6.setText(max.getUsername());
                score6.setText(String.valueOf(max.getHighestScore()));
                wins6.setText(wins);
            }
            if (i == 6) {
                username7.setText(max.getUsername());
                score7.setText(String.valueOf(max.getHighestScore()));
                wins7.setText(wins);
            }
            if (i == 7) {
                username8.setText(max.getUsername());
                score8.setText(String.valueOf(max.getHighestScore()));
                wins8.setText(wins);
            }
            if (i == 8) {
                username9.setText(max.getUsername());
                score9.setText(String.valueOf(max.getHighestScore()));
                wins9.setText(wins);
            }
            if (i == 9) {
                username10.setText(max.getUsername());
                score10.setText(String.valueOf(max.getHighestScore()));
                wins10.setText(wins);
            }
        }
    }

    public void back(MouseEvent mouseEvent) {
        try {
            new MainMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
