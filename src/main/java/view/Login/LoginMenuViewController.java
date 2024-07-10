package view.Login;

import controller.ApplicationController;
import controller.DataBaseController;
import controller.LoginMenuController;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.App;
import model.User.User;
import view.AuthenticationCode.AuthenticationMenuView;
import view.ForgetPassword.ForgetPasswordMenuView;
import view.Main.MainMenuView;
import view.Register.RegisterMenuView;

import java.io.IOException;

public class LoginMenuViewController {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label topText;
    public LoginMenuController loginMenuController = new LoginMenuController();
    public static String username;
    public static Stage authStage;

    public void loginClicked(MouseEvent mouseEvent) {
        String username = usernameField.getText();
        LoginMenuViewController.username = username;
        String password = passwordField.getText();
        int loginAns = loginMenuController.loginUser(username, password);
        if (loginAns != 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if (loginAns == 3) {
                alert.setTitle("Username field is empty");
                alert.setHeaderText("Username empty");
                alert.setContentText("Please fill username");
                alert.showAndWait();
            }
            if (loginAns == 2) {
                alert.setTitle("User was not found");
                alert.setHeaderText("User doesn't exist");
                alert.setContentText("Please enter valid username");
                alert.showAndWait();
            }
            if (loginAns == 1) {
                alert.setTitle("Wrong password");
                alert.setHeaderText("Password was incorrect");
                alert.setContentText("Please enter correct password");
                alert.showAndWait();
            }
        } else {
//            try {
//                loginMenuController.sendEmail(username);
//                authStage = new Stage();
//                new AuthenticationMenuView().start(authStage);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            //TODO: remove when releasing
            try {
                new MainMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void initialize() throws IOException {
        loadData();
    }

    public void loadData() throws IOException {
        DataBaseController.loadUsersFromJson();
    }

    public void goToQuestion(MouseEvent mouseEvent) {
        try {
            new ForgetPasswordMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToRegister(MouseEvent mouseEvent) {
        try {
            new RegisterMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Exit(MouseEvent mouseEvent) {
        DataBaseController.saveUsersToJson();
        System.exit(0);
    }

    public static boolean checkLoggedIn() {
        User loggedInUser = DataBaseController.loadLoggedInUser();
        if (loggedInUser != null) {
            System.out.println("User is logged in");
            ApplicationController.setLoggedInUser(loggedInUser);
            try {
                Platform.runLater(() -> {
                    try {
                        ApplicationController.setStage(new Stage());
                        DataBaseController.loadUsersFromJson();
                        new MainMenuView().start(ApplicationController.getStage());
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Failed to start MainMenuView");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            System.out.println("no user found");
            return false;
        }
    }
}
