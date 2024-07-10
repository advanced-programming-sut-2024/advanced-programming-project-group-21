package view.GameHistory;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.Register.RegisterMenu;

import java.net.URL;


public class GameHistoryMenuView extends Application {
    GameHistoryMenuViewController controller;
    private int numberOfGames;

    public GameHistoryMenuView() {
        this.numberOfGames = 5; // Default value
    }

    public GameHistoryMenuView(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

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
        setBackGround(root);
        controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private static void setBackGround(AnchorPane root) {
        Image image = new Image("file:src/main/resources/Images/BackGrounds/PreGame.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
    }
}
