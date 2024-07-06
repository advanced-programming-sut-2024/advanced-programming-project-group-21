package view.AuthenticationCode;

import controller.ApplicationController;
import controller.AuthenticationMenuController;
import controller.LoginMenuController;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User.User;
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
                new MainMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
