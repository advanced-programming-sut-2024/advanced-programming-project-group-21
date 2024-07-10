package controller.ClientServer.Client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.ClientServer.MessageClasses.ServerMessage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import view.Login.LoginMenuView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPClient {

    private Socket socket;
    private DataInputStream receiveBuffer;
    private DataOutputStream sendBuffer;
    private Gson gsonAgent;
    private ServerMessage lastServerMessage;

    private TCPClient() {
        GsonBuilder builder = new GsonBuilder();
        this.gsonAgent = builder.create();
    }

    private boolean establishConnection() {
        try {
            socket = new Socket("localhost", 5000);
            sendBuffer = new DataOutputStream(
                    socket.getOutputStream()
            );
            receiveBuffer = new DataInputStream(
                    socket.getInputStream()
            );
            return true;
        } catch (Exception e) {
            System.err.println("Unable to initialize socket!");
            e.printStackTrace();
            return false;
        }
    }

    private boolean endConnection() {
        if (socket == null) return true;
        try {
            socket.close();
            receiveBuffer.close();
            sendBuffer.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean sendMessage(String message) {
        try {
            sendBuffer.writeUTF(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private String receiveResponse() {
        try {
            return receiveBuffer.readUTF();
        } catch (IOException e) {
            return null;
        }
    }

    public void start() {
        Platform.runLater(() -> {
            try {
                new LoginMenuView().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }


    public static void main(String[] args) {
        Application.launch(LoginMenuView.class, args);
        TCPClient client = new TCPClient();
        client.start();
    }
}
