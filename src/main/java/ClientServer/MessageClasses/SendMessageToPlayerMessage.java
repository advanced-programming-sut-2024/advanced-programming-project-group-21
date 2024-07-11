package ClientServer.MessageClasses;

public class SendMessageToPlayerMessage extends ClientMessage{
    private String token;
    private String enemyUsername;
    private String message;
    public SendMessageToPlayerMessage(String token, String enemyUsername, String message) {
        this.type = ClientMessageType.sendMessageToPlayer;
        this.token = token;
        this.enemyUsername = enemyUsername;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public String getEnemyUsername() {
        return enemyUsername;
    }

    public String getMessage() {
        return message;
    }

}
