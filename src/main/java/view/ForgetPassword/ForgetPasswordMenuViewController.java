package view.ForgetPassword;

import controller.ApplicationController;
import controller.QuestionMenuController;
import enums.SecurityQuestions;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.Login.LoginMenuView;
import view.Main.MainMenuView;

public class ForgetPasswordMenuViewController {
    @FXML
    private TextField ConfirmPasswordField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button submitAnswer;
    @FXML
    private Button Back;
    @FXML
    private ChoiceBox<String> securityQuestionChoiceBox;
    @FXML
    private TextField securityAnswerField;
    @FXML
    private TextField usernameField;


    QuestionMenuController controller = new QuestionMenuController();

    public void initialize() {
        populateQuestions();
    }


    private void populateQuestions() {
        for (SecurityQuestions question : SecurityQuestions.values()) {
            securityQuestionChoiceBox.getItems().add(question.question);
        }
    }

    public void submitAnswer(MouseEvent mouseEvent) {
        String username = usernameField.getText();
        String question = securityQuestionChoiceBox.getValue();
        String answer = securityAnswerField.getText().strip().toLowerCase();
        String pass = passwordField.getText().strip().toLowerCase();
        String confirm = ConfirmPasswordField.getText().strip().toLowerCase();
        int result = controller.submitAnswer(username, question, answer, pass, confirm);
        if (result != 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if (result == 1) {
                emptyUsernameError(alert);
            } else if (result == 2) {
                emptyQuestionError(alert);
            } else if (result == 3) {
                emptyAnswerError(alert);
            } else if (result == 4) {
                userNotFound(alert);
            } else if (result == 5) {
                questionNotFound(alert);
            } else if (result == 6) {
                wrongAnswer(alert);
            } else if (result == 7) {
                emptyPassword(alert);
            } else if (result == 8) {
                passNotSame(alert);
            }
        } else {
            controller.changePassword(username,pass);
            enterMainMenu();
        }
    }

    private void emptyPassword(Alert alert) {
        alert.setTitle("Password field is empty");
        alert.setHeaderText("Password empty");
        alert.setContentText("Please fill password");
        alert.show();
    }

    private void passNotSame(Alert alert) {
        alert.setTitle("Password is not corrected");
        alert.setHeaderText("Password and Confirm must be the same");
        alert.setContentText("Please enter the confirm correctly");
        alert.show();
    }

    private void enterMainMenu() {
        try {
            new MainMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void emptyUsernameError(Alert alert) {
        alert.setTitle("Username field is empty");
        alert.setHeaderText("Username empty");
        alert.setContentText("Please fill username");
        alert.show();
    }

    private void emptyQuestionError(Alert alert) {
        alert.setTitle("Question field is empty");
        alert.setHeaderText("Question empty");
        alert.setContentText("Please fill question");
        alert.show();
    }

    private void emptyAnswerError(Alert alert) {
        alert.setTitle("Answer field is empty");
        alert.setHeaderText("Answer empty");
        alert.setContentText("Please fill answer");
        alert.show();
    }

    private void userNotFound(Alert alert) {
        alert.setTitle("User not found");
        alert.setHeaderText("User not found");
        alert.setContentText("Please enter a valid username");
        alert.show();
    }

    private void questionNotFound(Alert alert) {
        alert.setTitle("Question not found");
        alert.setHeaderText("You didn't answer this question in your settings");
        alert.setContentText("Please enter a valid question");
        alert.show();
    }

    private void wrongAnswer(Alert alert) {
        alert.setTitle("Wrong answer");
        alert.setHeaderText("Wrong answer");
        alert.setContentText("Please enter the correct answer");
        alert.show();
    }



    public void goBackToLogin(MouseEvent mouseEvent) {
        try {
            new LoginMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
