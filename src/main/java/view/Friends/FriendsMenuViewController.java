package view.Friends;

import ClientServer.Client.TCPClient;
import controller.ApplicationController;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.User.User;
import view.Profile.ProfileMenuView;

public class FriendsMenuViewController {

    public TextField usernameTextField;
    public Label usernameLabel;
    public Label highestScore;
    public Label gamesPlayed;
    public VBox friendProfile;

    public void initialize() {
        friendProfile.setVisible(false);
    }
    public void back(MouseEvent mouseEvent) {
        try {
            new ProfileMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void find(MouseEvent mouseEvent) {
        String username = usernameTextField.getText();
        int result = Integer.parseInt(TCPClient.getInstance().friendRequest(
                ApplicationController.getLoggedInUser().getUsername(), username));
        if (result != 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if (result == 1) {
                alert.setTitle("Invalid token");
                alert.setHeaderText("token not found");
                alert.setContentText("token not found");
                alert.showAndWait();
            } else if (result == 2) {
                alert.setTitle("User not found");
                alert.setHeaderText("No user with this username found");
                alert.setContentText("Please enter a proper name");
                alert.showAndWait();
            } else if (result == 3) {
                alert.setTitle("Already friends");
                alert.setHeaderText("You are already friends with this user");
                alert.setContentText("You are already friends with this user");
                alert.showAndWait();
            } else if (result == 4) {
                alert.setTitle("Already sent friend request to this user");
                alert.setHeaderText("Friend request already sent");
                alert.setContentText("Friend request already sent");
                alert.showAndWait();
            }
        } else {
            User user = User.getUserByUsername(username);
            usernameLabel.setText(username);
            highestScore.setText(String.valueOf(user.getHighestScore()));
            gamesPlayed.setText(String.valueOf(user.getGamesPlayed()));
            friendProfile.setVisible(true);
        }
    }
}
