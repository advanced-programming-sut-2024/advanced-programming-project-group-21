package ClientServer.MessageClasses;

public class ChangeNicknameMessage extends ClientMessage{
    private String newNickname;

    public ChangeNicknameMessage(String newNickname) {
        this.type = ClientMessageType.changeNickname;
        this.newNickname = newNickname;
    }

    public String getNewNickname() {
        return newNickname;
    }
}
