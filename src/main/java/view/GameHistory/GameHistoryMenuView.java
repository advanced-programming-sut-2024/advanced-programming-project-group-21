package view.GameHistory;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.Register.RegisterMenu;
import java.net.URL;


public class GameHistoryMenuView extends Application {
    GameHistoryMenuViewController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        stage.centerOnScreen();
        ApplicationController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = RegisterMenu.class.getResource("/FXML/GameHistory.fxml");
        AnchorPane root = fxmlLoader.load(url);
        controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
