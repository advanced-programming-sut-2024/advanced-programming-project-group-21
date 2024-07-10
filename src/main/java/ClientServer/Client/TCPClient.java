package ClientServer.Client;

import ClientServer.MessageClasses.GetUserMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ClientServer.MessageClasses.*;
import ClientServer.MessageClasses.AcceptGameMessage;
import ClientServer.MessageClasses.LoginMessage;
import ClientServer.MessageClasses.ServerMessage;
import controller.ApplicationController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.App;
import model.User.User;
import view.Login.LoginMenuView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class TCPClient {

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

    public String signup(String username, String password, String confirmPassword, String email, String nickname) {
        SignupMessage signupMessage = new SignupMessage(username, password, confirmPassword, nickname, email);
        establishConnection();
        sendMessage(gsonAgent.toJson(signupMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String logout() {
        LogoutMessage logoutMessage = new LogoutMessage();
        establishConnection();
        sendMessage(gsonAgent.toJson(logoutMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String changeEmail(String email) {
        ChangeEmailMessage changeEmailMessage = new ChangeEmailMessage(email);
        establishConnection();
        sendMessage(gsonAgent.toJson(changeEmailMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String changeNickname(String nickname) {
        ChangeNicknameMessage changeNicknameMessage = new ChangeNicknameMessage(nickname);
        establishConnection();
        sendMessage(gsonAgent.toJson(changeNicknameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String changePassword(String password, String confirmPassword) {
        ChangePasswordMessage changePasswordMessage = new ChangePasswordMessage(password, confirmPassword);
        establishConnection();
        sendMessage(gsonAgent.toJson(changePasswordMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String changeUsername(String username) {
        ChangeUsernameMessage changeUsernameMessage = new ChangeUsernameMessage(username);
        establishConnection();
        sendMessage(gsonAgent.toJson(changeUsernameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String forgetPassword(String username, String question, String answer, String newPassword) {
        ForgetPasswordMessage forgetPasswordMessage = new ForgetPasswordMessage(username, question, answer, newPassword);
        establishConnection();
        sendMessage(gsonAgent.toJson(forgetPasswordMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String moveCard(int cardIndex, int fromRowNum, int toRowNum) {
        MoveCardMessage moveCardMessage = new MoveCardMessage(cardIndex, fromRowNum, toRowNum);
        establishConnection();
        sendMessage(gsonAgent.toJson(moveCardMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String endGame() {
        EndGameMessage endGameMessage = new EndGameMessage();
        establishConnection();
        sendMessage(gsonAgent.toJson(endGameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String prepGame(ArrayList<Integer> cardIds, int commanderId, int factionId) {
        PreGameMessage preGameMessage = new PreGameMessage(cardIds, commanderId, factionId);
        establishConnection();
        sendMessage(gsonAgent.toJson(preGameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String RequestFriend(String username, String friendUsername) {
        RequestFriendMessage requestFriendMessage = new RequestFriendMessage(username, friendUsername);
        establishConnection();
        sendMessage(gsonAgent.toJson(requestFriendMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String RequestGame(String username, String friendName) {
        RequestGameMessage requestGameMessage = new RequestGameMessage(username, friendName);
        establishConnection();
        sendMessage(gsonAgent.toJson(requestGameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String AcceptFriend(String username, String friendName, boolean accept) {
        AcceptFriendMessage acceptFriendMessage = new AcceptFriendMessage("username", "friendName", true);
        establishConnection();
        sendMessage(gsonAgent.toJson(acceptFriendMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String RejectFriend(String username, String friendName) {
        AcceptFriendMessage rejectFriendMessage = new AcceptFriendMessage("username", "friendName", false);
        establishConnection();
        sendMessage(gsonAgent.toJson(rejectFriendMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String SkipTurnMessage() {
        SkipTurnMessage skipTurnMessage = new SkipTurnMessage();
        establishConnection();
        sendMessage(gsonAgent.toJson(skipTurnMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String VetoTurn(ArrayList<Integer> cardIdsToVeto, ArrayList<Integer> newCardIds) {
        VetoMessage vetoMessage = new VetoMessage(cardIdsToVeto, newCardIds);
        establishConnection();
        sendMessage(gsonAgent.toJson(vetoMessage));
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
        AcceptGameMessage acceptGameMessage = new AcceptGameMessage("username", "friendName", true);
        establishConnection();
        sendMessage(gsonAgent.toJson(acceptGameMessage));
        lastServerMessage = gsonAgent.fromJson(
                receiveResponse(), ServerMessage.class);
        endConnection();
        return lastServerMessage.getAdditionalInfo();
    }

    public String rejectGameRequest() {
        AcceptGameMessage acceptGameMessage = new AcceptGameMessage("username", "friendName", false);
        establishConnection();
        sendMessage(gsonAgent.toJson(acceptGameMessage));
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
        return gsonAgent.fromJson(lastServerMessage.getAdditionalInfo(), User.class);
    }
}
