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
import model.User.User;
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
    User currentUser = User.getLoggedInUser();


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
        int result = controller.submitAnswer(answer, question);
        if (result != 0) {
            if (result != 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                if (result == 1) {
                    emptyQuestionError(alert);
                } else if (result == 2) {
                    emptyAnswerError(alert);
                }
            } else {
                currentUser.addToQuestionAnswers(question, answer);
            }
        }

    }

    private void emptyAnswerError(Alert alert) {
        alert.setTitle("Answer field is empty");
        alert.setHeaderText("Answer empty");
        alert.setContentText("Please fill answer");
        alert.show();
    }

    private void emptyQuestionError(Alert alert){
        alert.setTitle("Question field is empty");
        alert.setHeaderText("Question empty");
        alert.setContentText("Please fill question");
        alert.show();
    }
}
