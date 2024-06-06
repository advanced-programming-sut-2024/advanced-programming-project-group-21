package view.Profile;

import controller.ApplicationController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view.Main.MainMenuView;
import view.Question.QuestionMenuView;

public class ProfileMenuViewController {
    public AnchorPane pane;
    public VBox vbox;
    public Button usernameButton;
    double answerTextFieldWidth = 200;
    TextField answerTextField = null;
    Button submitChange = null;
    double distanceBetweenButtons = 33;

    public void openChangeUsername(MouseEvent mouseEvent) {
        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 38);
        createSubmitButton();
    }

    public void openChangeNickname(MouseEvent mouseEvent) {
        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 38 + distanceBetweenButtons);
        createSubmitButton();
    }

    public void openChangeEmail(MouseEvent mouseEvent) {
        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 38 + distanceBetweenButtons * 2);
        createSubmitButton();
    }

    public void openChangePassword(MouseEvent mouseEvent) {
        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 38 + distanceBetweenButtons * 3);
        createSubmitButton();
    }

    public void goToQuestionMenu(MouseEvent mouseEvent) {
        try {
            new QuestionMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToMainMenu(MouseEvent mouseEvent) {
        try {
            new MainMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createSubmitButton() {
        removeSubmitButton();
        double answerTextFieldHeight = usernameButton.getHeight();
        submitChange = new Button();
        submitChange.setText("Submit");
        submitChange.setMaxHeight(30);
        submitChange.setMinHeight(30);
        submitChange.setMaxWidth(70);
        submitChange.setMinWidth(70);

        submitChange.setLayoutX(answerTextField.getLayoutX() + answerTextField.getMaxWidth() / 2 - submitChange.getMaxWidth() / 2);
        submitChange.setLayoutY(answerTextField.getLayoutY() + answerTextFieldHeight + 5);
        pane.getChildren().add(submitChange);
    }

    private void createAnswerTextField(double x, double y) {
        removeAnswerTextField();
        double answerTextFieldHeight = usernameButton.getHeight();
        answerTextField = new TextField();

        answerTextField.setMaxWidth(answerTextFieldWidth);
        answerTextField.setMinWidth(answerTextFieldWidth);
        answerTextField.setMaxHeight(answerTextFieldHeight);
        answerTextField.setMinHeight(answerTextFieldHeight);

        answerTextField.setLayoutX(x);
        answerTextField.setLayoutY(y);
        pane.getChildren().add(answerTextField);
    }

    private void removeAnswerTextField() {
        if (answerTextField != null) {
            pane.getChildren().remove(answerTextField);
            answerTextField = null;
        }
    }

    private void removeSubmitButton() {
        if (submitChange != null) {
            pane.getChildren().remove(submitChange);
            submitChange = null;
        }
    }
}
