package view.AuthenticationCode;

import controller.ApplicationController;
import controller.AuthenticationMenuController;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.User.User;
import view.Login.LoginMenuView;
import view.Login.LoginMenuViewController;
import view.Main.MainMenuView;


public class AuthenticationMenuViewController {
    public  TextField confirmLogin;

    public void confirmChecked(MouseEvent mouseEvent) {
        if (AuthenticationMenuController.checkLogin(confirmLogin.getText())) {
            String username = LoginMenuViewController.username;
            User user = User.getUserByUsername(username);
            ApplicationController.setLoggedInUser(user);
            try {
                LoginMenuViewController.authStage.close();
                LoginMenuView.close();
                new MainMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Oops!");
            alert.setHeaderText("Wrong code");
            alert.setContentText("Please enter the code correctly");
            alert.showAndWait();
            confirmLogin.setText("");
            confirmLogin.setPromptText("Try again");

        }
    }

}
