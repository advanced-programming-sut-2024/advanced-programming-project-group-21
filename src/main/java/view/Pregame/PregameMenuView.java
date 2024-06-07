package view.Pregame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;

public class PregameMenuView extends Application {
    PregameMenuViewController controller;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = PregameMenuView.class.getResource("/FXML/Pregame.fxml");
        AnchorPane root = fxmlLoader.load(url);
        controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
