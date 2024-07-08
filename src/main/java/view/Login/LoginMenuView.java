package view.Login;

import controller.ApplicationController;
import controller.DataBaseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import view.Register.RegisterMenu;

import java.net.URL;

public class LoginMenuView extends Application {
    LoginMenuViewController controller;
    private static Stage stage;

    public static void main(String[] args) {
        if (!checkLoggedIn()) {
            launch(args);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        ApplicationController.setStage(stage);
        LoginMenuView.stage = stage;
        stage.setResizable(false);
        stage.centerOnScreen();
        FXMLLoader fxmlLoader = new FXMLLoader();
        URL url = RegisterMenu.class.getResource("/FXML/Login.fxml");
        AnchorPane root = fxmlLoader.load(url);
        setBackGround(root);
        controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private static boolean checkLoggedIn() {
        return LoginMenuViewController.checkLoggedIn();
    }

    private static void setBackGround(AnchorPane root) {
        Image image = new Image("file:src/main/resources/Images/BackGrounds/LoginMenu.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        root.setBackground(background);
    }

    public static void close() {
        stage.close();
    }
}
