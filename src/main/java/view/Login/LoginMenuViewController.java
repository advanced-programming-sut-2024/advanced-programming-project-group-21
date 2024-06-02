package view.Login;

import controller.ApplicationController;
import controller.LoginMenuController;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User.User;
import view.Main.MainMenuView;
import view.Question.QuestionMenuView;
import view.Register.RegisterMenuView;

import java.io.IOException;

public class LoginMenuViewController {
    public TextField usernameField;
    public PasswordField passwordField;
    public Label topText;
    public LoginMenuController loginMenuController = new LoginMenuController();

    public void loginClicked(MouseEvent mouseEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        int loginAns = loginMenuController.loginUser(username,password);
        if(loginAns!=0){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if(loginAns==3){
                alert.setTitle("Username field is empty");
                alert.setHeaderText("Username empty");
                alert.setContentText("Please fill username");
                alert.show();
            }
            if(loginAns==2){
                alert.setTitle("User was not found");
                alert.setHeaderText("User doesn't exist");
                alert.setContentText("Please enter valid username");
                alert.show();
            }
            if(loginAns==1){
                alert.setTitle("Wrong password");
                alert.setHeaderText("Password was incorrect");
                alert.setContentText("Please enter correct password");
                alert.show();
            }
        }
        else{
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
        User.loadUsersFromJson();
    }

    public void goToQuestion(MouseEvent mouseEvent) {
        try {
            new QuestionMenuView().start(ApplicationController.getStage());
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
}
