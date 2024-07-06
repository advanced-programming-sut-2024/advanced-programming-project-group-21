package controller.Server.Messages;

public class ServerMessages {
    private boolean success;
    private String info;

    public ServerMessages(boolean success, String info) {
        this.success = success;
        this.info = info;
    }

    public boolean isSuccessful() {
        return success;
    }

    public String getInfo() {
        return info;
    }
}
