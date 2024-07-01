package view.ScoreBoard;

import controller.ApplicationController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import view.Main.MainMenuView;
import view.Main.MainMenuViewController;
import view.UserInfo.UserInfoMenuView;

public class ScoreBoardViewController {
    @FXML
    private Label username1;
    @FXML
    private Label score1;
    @FXML
    private Label wins1;
    @FXML
    private Label username2;
    @FXML
    private Label score2;
    @FXML
    private Label wins2;
    @FXML
    private Label username3;
    @FXML
    private Label score3;
    @FXML
    private Label wins3;
    @FXML
    private Label username4;
    @FXML
    private Label score4;
    @FXML
    private Label wins4;
    @FXML
    private Label username5;
    @FXML
    private Label score5;
    @FXML
    private Label wins5;
    @FXML
    private Label username6;
    @FXML
    private Label score6;
    @FXML
    private Label wins6;
    @FXML
    private Label username7;
    @FXML
    private Label score7;
    @FXML
    private Label wins7;
    @FXML
    private Label username8;
    @FXML
    private Label score8;
    @FXML
    private Label wins8;
    @FXML
    private Label username9;
    @FXML
    private Label score9;
    @FXML
    private Label wins9;
    @FXML
    private Label username10;
    @FXML
    private Label score10;
    @FXML
    private Label wins10;

    public void initialize() {

    }

    public void back(MouseEvent mouseEvent) {
        try {
            new MainMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
