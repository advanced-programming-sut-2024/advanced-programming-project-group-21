package view.Profile;

import controller.ApplicationController;
import javafx.fxml.FXML;
import controller.ProfileMenuController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.App;
import model.PreGame;
import model.User.User;
import view.Main.MainMenuView;
import view.Question.QuestionMenuView;
import view.UserInfo.UserInfoMenuView;


public class ProfileMenuViewController {
    @FXML
    private TextField gameHistoryNumber;
    public AnchorPane pane;
    public VBox vbox;
    public Button usernameButton;
    public CheckBox loggedInCheckBox;
    double answerTextFieldWidth = 200;
    TextField answerTextField = null;
    Button submitChange = null;
    double distanceBetweenButtons = 33;
    String answer;
    ProfileMenuController controller = new ProfileMenuController();

    public void initialize() {
        if (ApplicationController.getLoggedInUser().isStayingLoggedIn()) {
            loggedInCheckBox.setSelected(true);
        }
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
            ApplicationController.getLoggedInUser().setUsername(answer);
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
            ApplicationController.getLoggedInUser().setNickname(answer);
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
            ApplicationController.getLoggedInUser().setEmail(answer);
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
            ApplicationController.getLoggedInUser().setPassword(answer);
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
            String inputText = gameHistoryNumber.getText();
            if (inputText.isEmpty()) {
                int numberOfGames = inputText.isEmpty() ? 5 : Integer.parseInt(inputText);
                new view.GameHistory.GameHistoryMenuView(numberOfGames).start(ApplicationController.getStage());
            } else {
                int numberOfGames = Integer.parseInt(inputText);
                if (numberOfGames == 0) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid input");
                    alert.setHeaderText("Invalid input");
                    alert.setContentText("you didn't play any games yet");
                    alert.showAndWait();
                } else if (!(numberOfGames > 1)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Invalid input");
                    alert.setHeaderText("Invalid input");
                    alert.setContentText("please enter a valid number");
                    alert.showAndWait();
                } else if (numberOfGames > 1) {
                    new view.GameHistory.GameHistoryMenuView(numberOfGames).start(ApplicationController.getStage());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stayLoggedIn(ActionEvent actionEvent) {
        if (loggedInCheckBox.isSelected()) {
            ApplicationController.getLoggedInUser().setStayingLoggedIn(true);
            controller.setLoggedInUser(ApplicationController.getLoggedInUser());
        } else {
            ApplicationController.getLoggedInUser().setStayingLoggedIn(false);
            controller.clearLoggedInUser();
        }
    }
}



