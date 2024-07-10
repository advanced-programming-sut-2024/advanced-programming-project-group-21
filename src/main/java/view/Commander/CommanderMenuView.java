package view.Commander;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.net.URL;

public class CommanderMenuView extends Application {
    CommanderMenuViewController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        stage.centerOnScreen();
        ApplicationController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = CommanderMenuView.class.getResource("/FXML/Commander.fxml");
        AnchorPane root = fxmlLoader.load(url);
        controller = fxmlLoader.getController();
        setBackGround(root);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
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
