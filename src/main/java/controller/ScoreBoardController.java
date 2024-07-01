package controller;

import model.User.User;
import view.ScoreBoard.ScoreBoardViewController;

import static java.lang.Math.min;

public class ScoreBoardController {
    public static void setData(ScoreBoardViewController controller) {
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
                controller.username1.setText(username);
                controller.score1.setText(score);
                controller.wins1.setText(wins);

            }
            if (i == 1) {
                controller.username2.setText(username);
                controller.score2.setText(score);
                controller.wins2.setText(wins);
            }
            if (i == 2) {
                controller.username3.setText(max.getUsername());
                controller.score3.setText(String.valueOf(max.getHighestScore()));
                controller.wins3.setText(wins);
            }
            if (i == 3) {
                controller.username4.setText(max.getUsername());
                controller.score4.setText(String.valueOf(max.getHighestScore()));
                controller.wins4.setText(wins);
            }
            if (i == 4) {
                controller.username5.setText(max.getUsername());
                controller.score5.setText(String.valueOf(max.getHighestScore()));
                controller.wins5.setText(wins);
            }
            if (i == 5) {
                controller.username6.setText(max.getUsername());
                controller.score6.setText(String.valueOf(max.getHighestScore()));
                controller.wins6.setText(wins);
            }
            if (i == 6) {
                controller.username7.setText(max.getUsername());
                controller.score7.setText(String.valueOf(max.getHighestScore()));
                controller.wins7.setText(wins);
            }
            if (i == 7) {
                controller.username8.setText(max.getUsername());
                controller.score8.setText(String.valueOf(max.getHighestScore()));
                controller.wins8.setText(wins);
            }
            if (i == 8) {
                controller.username9.setText(max.getUsername());
                controller.score9.setText(String.valueOf(max.getHighestScore()));
                controller.wins9.setText(wins);
            }
            if (i == 9) {
                controller.username10.setText(max.getUsername());
                controller.score10.setText(String.valueOf(max.getHighestScore()));
                controller.wins10.setText(wins);
            }
        }
    }
}
