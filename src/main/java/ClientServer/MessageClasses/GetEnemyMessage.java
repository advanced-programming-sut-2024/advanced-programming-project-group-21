package ClientServer.MessageClasses;

public class GetEnemyMessage extends ClientMessage{
    private String username;

    public GetEnemyMessage(String username) {
        this.username = username;
        this.type = ClientMessageType.getEnemy;
    }

    public String getUsername() {
        return username;
    }
}
