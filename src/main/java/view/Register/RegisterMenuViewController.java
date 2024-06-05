package view.Register;

import controller.ApplicationController;
import controller.LoginMenuController;
import controller.RegisterMenuController;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.User.User;
import view.Login.LoginMenuView;
import view.Main.MainMenuView;
import view.Question.QuestionMenuView;

public class RegisterMenuViewController {
    public TextField usernameField;
    public TextField nicknameField;
    public TextField emailField;
    public PasswordField passwordField;
    public TextField confirmPasswordField;

    RegisterMenuController controller = new RegisterMenuController();

    public void generateStrongPassword(MouseEvent mouseEvent) {
        String strongPassword = controller.createRandomPassword();
        passwordField.setText(strongPassword);
        confirmPasswordField.setText(strongPassword);
    }

    public void register(MouseEvent mouseEvent) {
        String username = usernameField.getText();
        String nickname = nicknameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        int registerAns = controller.register(nickname, username, email, password, confirmPassword);
        if (registerAns != 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if (registerAns == 1) {
                emptyNicknameError(alert);
            } else if (registerAns == 2) {
                emptyUsernameError(alert);
            } else if (registerAns == 3) {
                emptyEmailError(alert);
            } else if (registerAns == 4) {
                emptyPasswordError(alert);
            } else if (registerAns == 5) {
                emptyConfirmPasswordError(alert);
            } else if (registerAns == 6) {
                usernameExistsError(alert);
            } else if (registerAns == 7) {
                passwordMismatchError(alert);
            }
        } else {
            enterQuestionMenu();
        }
    }

    private void emptyUsernameError(Alert alert) {
        alert.setTitle("Username field is empty");
        alert.setHeaderText("Username empty");
        alert.setContentText("Please fill username");
        alert.show();
    }

    private void emptyPasswordError(Alert alert) {
        alert.setTitle("Password field is empty");
        alert.setHeaderText("Password empty");
        alert.setContentText("Please fill password");
        alert.show();
    }

    private void emptyNicknameError(Alert alert) {
        alert.setTitle("Nickname field is empty");
        alert.setHeaderText("Nickname empty");
        alert.setContentText("Please fill nickname");
        alert.show();
    }

    private void emptyEmailError(Alert alert) {
        alert.setTitle("Email field is empty");
        alert.setHeaderText("Email empty");
        alert.setContentText("Please fill email");
        alert.show();
    }

    private void emptyConfirmPasswordError(Alert alert) {
        alert.setTitle("Confirm password field is empty");
        alert.setHeaderText("Confirm password empty");
        alert.setContentText("Please fill confirm password");
        alert.show();
    }

    private void usernameExistsError(Alert alert) {
        alert.setTitle("Username already exists");
        alert.setHeaderText("User exists");
        alert.setContentText("Please choose another username, a new username has been generated for you.");
        alert.show();
        usernameField.setText(controller.createNewUsername(usernameField.getText()));
    }

    private void passwordMismatchError(Alert alert) {
        alert.setTitle("Password mismatch");
        alert.setHeaderText("Password mismatch");
        alert.setContentText("Please enter matching passwords with your confirm password");
        alert.show();
    }

    private void enterQuestionMenu(){
        try {
            new QuestionMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goBackToLoginMenu(MouseEvent mouseEvent) {
        try {
            new LoginMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
