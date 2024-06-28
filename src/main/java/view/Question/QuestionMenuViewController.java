package view.Question;

import controller.ApplicationController;
import controller.QuestionMenuController;
import enums.SecurityQuestions;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import view.Main.MainMenuView;

public class QuestionMenuViewController {

    @FXML
    private Button Back;
    @FXML
    private Button submitAnswer;
    @FXML
    private ChoiceBox<String> securityQuestionChoiceBox;
    @FXML
    private TextField securityAnswerField;

    QuestionMenuController controller = new QuestionMenuController();


    public void goToProfileMenu(MouseEvent mouseEvent) {
        try {
            new MainMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initialize() {
        populateQuestions();
    }

    private void populateQuestions() {
        for (SecurityQuestions question : SecurityQuestions.values()) {
            securityQuestionChoiceBox.getItems().add(question.question);
        }
    }


    public void submitAnswer(MouseEvent mouseEvent) {
        String question = securityQuestionChoiceBox.getValue();
        String answer = securityAnswerField.getText().strip().toLowerCase();
        int result = controller.submitAnswer(question, answer);
        if (result != 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            if (result == 1) {
                emptyQuestionError(alert);
            } else if (result == 2) {
                emptyAnswerError(alert);
            } else if (result == 3) {
                questionNotFound(alert);
            }
        } else {
            // TODO: 6/15/2021 go to change password menu
        }

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

    private void questionNotFound(Alert alert){
        alert.setTitle("Question not found");
        alert.setHeaderText("You didn't answer this question in your settings");
        alert.setContentText("Please enter a valid question");
        alert.show();
    }
}
