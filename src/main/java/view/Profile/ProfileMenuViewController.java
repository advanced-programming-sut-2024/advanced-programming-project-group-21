package view.Profile;

import controller.ApplicationController;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ProfileMenuViewController {
    public AnchorPane pane;
    public VBox vbox;
    public Button usernameButton;
    double answerTextFieldWidth = 200;
    TextField answerTextField = null;
    Button submitChange = null;
    public void openChangeUsername(MouseEvent mouseEvent) {
        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 38);
        createSubmitButton();
    }

    public void openChangeNickname(MouseEvent mouseEvent) {

        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 38 + 40);
        createSubmitButton();
    }

    public void openChangeEmail(MouseEvent mouseEvent) {
        //createAnswerTextField(emailButton.getLayoutX() - answerTextFieldWidth, emailButton.getLayoutY());

      //  createSubmitButton();
    }

    public void openChangePassword(MouseEvent mouseEvent) {
     //   createAnswerTextField(passwordButton.getLayoutX() - answerTextFieldWidth, passwordButton.getLayoutY());

       // createSubmitButton();
    }

    public void goToQuestionMenu(MouseEvent mouseEvent) {
    }

    public void goToMainMenu(MouseEvent mouseEvent) {

    }

    private void createSubmitButton() {
        double answerTextFieldHeight = usernameButton.getHeight();
        submitChange = new Button();
        submitChange.setText("Submit");
        submitChange.setMaxHeight(30);
        submitChange.setMinHeight(30);
        submitChange.setMaxWidth(70);
        submitChange.setMinWidth(70);

        submitChange.setLayoutX(answerTextField.getLayoutX() + answerTextField.getMaxWidth()/2 - submitChange.getMaxWidth()/2);
        submitChange.setLayoutY(answerTextField.getLayoutY() + answerTextFieldHeight + 10);
        pane.getChildren().add(submitChange);
    }

    private void createAnswerTextField(double x, double y) {
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
}
