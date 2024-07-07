package controller.ClientServer;

import controller.ApplicationController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.Login.LoginMenuView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TCPClient {

    private DataInputStream receiveBuffer;
    private DataOutputStream sendBuffer;

    private void start() {
        try {
            Socket socket = new Socket("localhost",5000);
            sendBuffer = new DataOutputStream(
                    socket.getOutputStream()
            );
            receiveBuffer = new DataInputStream(
                    socket.getInputStream()
            );
            Platform.runLater(() -> {
                try {
                    new LoginMenuView().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Application.launch(LoginMenuView.class, args);
        TCPClient client = new TCPClient();
        client.start();
    }
}
