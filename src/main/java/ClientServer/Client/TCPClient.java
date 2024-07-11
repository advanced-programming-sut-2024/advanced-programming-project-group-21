package ClientServer.Client;

import ClientServer.MessageClasses.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.ApplicationController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.User.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import view.Login.LoginMenuView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPClient {

    private static final Logger log = LoggerFactory.getLogger(TCPClient.class);
    private Socket socket;
    private DataInputStream receiveBuffer;
    private DataOutputStream sendBuffer;
    private Gson gsonAgent;
    private ServerMessage lastServerMessage;
    private static TCPClient instance = null;

    private TCPClient() {
        GsonBuilder builder = new GsonBuilder();
        this.gsonAgent = builder.create();
    }

    public static TCPClient getInstance() {
        if (instance == null) {
            instance = new TCPClient();
        }
        return instance;
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

    // Functions
    public String login(String username, String password) {
        LoginMessage loginMessage = new LoginMessage(username, password);
        establishConnection();
        sendMessage(gsonAgent.toJson(loginMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }
    public String logout(String username) {
        LogoutMessage logoutMessage = new LogoutMessage(username);
        establishConnection();
        String token = ApplicationController.getLoggedInUser().getCurrentToken();
        logoutMessage.setToken(token);
        sendMessage(gsonAgent.toJson(logoutMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public User getUserFromUsername(String username) {
        GetUserMessage getUserMessage = new GetUserMessage(username);
        establishConnection();
        sendMessage(gsonAgent.toJson(getUserMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        if (lastServerMessage.getAdditionalInfo().equals("no user exists with such username")) return null;
        // turn info to gson of user
        return gsonAgent.fromJson(lastServerMessage.getAdditionalInfo(), User.class);
    }

    public String signup(String username, String password, String email, String nickname, String confirmPassword) {
        SignupMessage signupMessage = new SignupMessage(username, password, email, nickname, confirmPassword);
        System.out.println(password);
        System.out.println(confirmPassword);
        establishConnection();
        sendMessage(gsonAgent.toJson(signupMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }


    public static void main(String[] args) {
        Application.launch(LoginMenuView.class, args);
        TCPClient client = TCPClient.getInstance();
        client.start();
    }

    public String acceptGameRequest(String username, String friendName) {
        AcceptGameMessage acceptGameMessage = new AcceptGameMessage(username, friendName, true);
        establishConnection();
        sendMessage(gsonAgent.toJson(acceptGameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String rejectGameRequest(String username, String friendName) {
        AcceptGameMessage acceptGameMessage = new AcceptGameMessage(username, friendName, false);
        establishConnection();
        sendMessage(gsonAgent.toJson(acceptGameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String getGameRequest(){
        String enemyName = null;
        GetRequestGameMessage getRequestGameMessage = new GetRequestGameMessage(ApplicationController.getLoggedInUser().getUsername());
        establishConnection();
        sendMessage(gsonAgent.toJson(getRequestGameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String requestGame(String username, String friendName) {
        RequestGameMessage requestGameMessage = new RequestGameMessage(username, friendName);
//        requestGameMessage.setToken(token);
        establishConnection();
        sendMessage(gsonAgent.toJson(requestGameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }
}
