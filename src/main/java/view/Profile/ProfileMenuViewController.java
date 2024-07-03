package view.Profile;

import controller.ApplicationController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.User.User;
import view.Main.MainMenuView;
import view.Question.QuestionMenuView;
import view.UserInfo.UserInfoMenuView;

import java.awt.desktop.AppForegroundListener;

public class ProfileMenuViewController {
    public AnchorPane pane;
    public VBox vbox;
    public Button usernameButton;
    double answerTextFieldWidth = 200;
    TextField answerTextField = null;
    //TextField passwordAnswerTextField = null;
    Button submitChange = null;
    double distanceBetweenButtons = 33;
    String answer;

    public void initialize() {
        User.setLoggedInUser(ApplicationController.getLoggedInUser());
    }

    public void openChangeUsername(MouseEvent mouseEvent) {
        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 50);
        createSubmitButton();
        submitChange.setOnMouseClicked((MouseEvent event) -> {
            answer = answerTextField.getText();
            usernameSubmitChange(answer);
        });
    }

    public void openChangeNickname(MouseEvent mouseEvent) {
        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 50 + distanceBetweenButtons);
        createSubmitButton();
        submitChange.setOnMouseClicked((MouseEvent event) -> {
            answer = answerTextField.getText();
            nicknameSubmitChange(answer);
        });

    }

    public void openChangeEmail(MouseEvent mouseEvent) {
        createAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 50 + distanceBetweenButtons * 2);
        createSubmitButton();
        submitChange.setOnMouseClicked((MouseEvent event) -> {
            answer = answerTextField.getText();
            emailSubmitChange(answer);
        });
    }

    public void openChangePassword(MouseEvent mouseEvent) {
        removePasswordAnswerTextField();
        createFirstPasswordAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 50 + distanceBetweenButtons * 3);
        createSecondPasswordAnswerTextField(vbox.getLayoutX() - answerTextFieldWidth, vbox.getLayoutY() + 50 + (distanceBetweenButtons * 3) + distanceBetweenButtons);
        createSubmitButton();
        submitChange.setOnMouseClicked((MouseEvent event) -> {
            answer = answerTextField.getText();
            passwordSubmitChange(answer);
        });
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
        removePasswordAnswerTextField();
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

    private void createFirstPasswordAnswerTextField(double x, double y) {
        double answerTextFieldHeight = usernameButton.getHeight();
        answerTextField = new TextField();

        answerTextField.setMaxWidth(answerTextFieldWidth);
        answerTextField.setMinWidth(answerTextFieldWidth);
        answerTextField.setMaxHeight(answerTextFieldHeight);
        answerTextField.setMinHeight(answerTextFieldHeight);
        answerTextField.setPromptText("current password");

        answerTextField.setLayoutX(x);
        answerTextField.setLayoutY(y);
        pane.getChildren().add(answerTextField);
    }

    private void createSecondPasswordAnswerTextField(double x, double y) {
        removeAnswerTextField();
        double answerTextFieldHeight = usernameButton.getHeight();
        answerTextField = new TextField();

        answerTextField.setMaxWidth(answerTextFieldWidth);
        answerTextField.setMinWidth(answerTextFieldWidth);
        answerTextField.setMaxHeight(answerTextFieldHeight);
        answerTextField.setMinHeight(answerTextFieldHeight);
        answerTextField.setId("secondPassword");
        answerTextField.setPromptText("new password");

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

    private void removePasswordAnswerTextField() {
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

    public void usernameSubmitChange(String answer) {
        if (User.getUserByUsername(answer) != null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Username already exists");
            alert.setHeaderText("Username already exists");
            alert.setContentText("Please enter another username");
            alert.showAndWait();
        } else if (answer.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Username field is empty");
            alert.setHeaderText("Username empty");
            alert.setContentText("Please fill username");
            alert.showAndWait();
        } else if (ApplicationController.getLoggedInUser().getUsername().equals(answer)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Username is the same");
            alert.setHeaderText("Username is the same");
            alert.setContentText("Please enter another username");
            alert.showAndWait();
        } else {
            User.changeUsername(answer);
            try {
                new ProfileMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void nicknameSubmitChange(String answer) {
        if (answer.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nickname field is empty");
            alert.setHeaderText("Nickname empty");
            alert.setContentText("Please fill nickname");
            alert.showAndWait();
        } else if (ApplicationController.getLoggedInUser().getNickname().equals(answer)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nickname is the same");
            alert.setHeaderText("Nickname is the same");
            alert.setContentText("Please enter another nickname");
            alert.showAndWait();
        } else {
            User.changeNickname(answer);
            try {
                new ProfileMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void emailSubmitChange(String answer) {
        if (answer.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Email field is empty");
            alert.setHeaderText("Email empty");
            alert.setContentText("Please fill email");
            alert.showAndWait();
        } else if (ApplicationController.getLoggedInUser().getEmail().equals(answer)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Email is the same");
            alert.setHeaderText("Email is the same");
            alert.setContentText("Please enter another email");
            alert.showAndWait();
        } else {
            User.changeEmail(answer);
            try {
                new ProfileMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void passwordSubmitChange(String answer) {
        if (answer.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Password field is empty");
            alert.setHeaderText("Password empty");
            alert.setContentText("Please fill password");
            alert.showAndWait();
        } else if (ApplicationController.getLoggedInUser().getPassword().equals(answer)) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Password is the same");
            alert.setHeaderText("Password is the same");
            alert.setContentText("Please enter another password");
            alert.showAndWait();
        } else {
            User.changePassword(answer);
            try {
                new ProfileMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void goToUserInfoMenu(MouseEvent mouseEvent) {
        try {
            new UserInfoMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToGameHistoryInfoMenu(MouseEvent mouseEvent) {
        try {
            new view.GameHistory.GameHistoryMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



