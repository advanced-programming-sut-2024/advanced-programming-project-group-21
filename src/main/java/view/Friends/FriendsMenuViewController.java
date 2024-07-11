package view.Friends;

import controller.ApplicationController;
import javafx.scene.input.MouseEvent;
import view.Profile.ProfileMenuView;

public class FriendsMenuViewController {


    public void back(MouseEvent mouseEvent) {
        try {
            new ProfileMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
