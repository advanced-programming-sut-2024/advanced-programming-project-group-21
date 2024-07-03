package view.ScoreBoard;

import controller.ApplicationController;
import controller.ScoreBoardController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import view.Main.MainMenuView;

import static java.lang.Math.min;

public class ScoreBoardViewController {
    @FXML
    public Label username1;
    @FXML
    public Label score1;
    @FXML
    public Label wins1;
    @FXML
    public Label username2;
    @FXML
    public Label score2;
    @FXML
    public Label wins2;
    @FXML
    public Label username3;
    @FXML
    public Label score3;
    @FXML
    public Label wins3;
    @FXML
    public Label username4;
    @FXML
    public Label score4;
    @FXML
    public Label wins4;
    @FXML
    public Label username5;
    @FXML
    public Label score5;
    @FXML
    public Label wins5;
    @FXML
    public Label username6;
    @FXML
    public Label score6;
    @FXML
    public Label wins6;
    @FXML
    public Label username7;
    @FXML
    public Label score7;
    @FXML
    public Label wins7;
    @FXML
    public Label username8;
    @FXML
    public Label score8;
    @FXML
    public Label wins8;
    @FXML
    public Label username9;
    @FXML
    public Label score9;
    @FXML
    public Label wins9;
    @FXML
    public Label username10;
    @FXML
    public Label score10;
    @FXML
    public Label wins10;

    public void initialize() {
        ScoreBoardController.setData(this);
    }

    public void back(MouseEvent mouseEvent) {
        try {
            new MainMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
