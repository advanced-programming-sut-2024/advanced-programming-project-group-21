package view.ScoreBoard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.Main.MainMenuView;

import java.net.URL;

public class ScoreBoardView extends Application {
    ScoreboardViewController controller;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = MainMenuView.class.getResource("/FXML/Scoreboard.fxml");
        AnchorPane root = fxmlLoader.load(url);
        setBackGround(root);
        controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    private static void setBackGround(AnchorPane root) {
        Image image = new Image("file:src/main/resources/Images/BackGrounds/ProfileMenu.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
    }
}
