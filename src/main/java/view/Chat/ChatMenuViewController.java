package view.Chat;

import ClientServer.Client.TCPClient;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.User.User;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChatMenuViewController {


    @FXML
    private VBox ChatBox;

    public void startSendingMessages(String token, String enemyUsername, String message) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            TCPClient.getInstance().sendMessageToPlayer(token, enemyUsername, message);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void updateChatBox(String message) {
        Platform.runLater(() -> {
            Label newMessageLabel = new Label(message);
            ChatBox.getChildren().add(newMessageLabel);
        });
    }

    public void sendMessage(User sender, User receiver, String message) {
        String from = sender.getUsername();
        String to = receiver.getUsername();
        String formattedMessage = String.format("%s to %s: %s", from, to, message);
        updateChatBox(formattedMessage);
    }

}
