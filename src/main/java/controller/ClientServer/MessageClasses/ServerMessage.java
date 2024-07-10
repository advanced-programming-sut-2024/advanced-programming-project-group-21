package controller.ClientServer.MessageClasses;

public class ServerMessage {
    private boolean success;
    private String additionalInfo;

    public ServerMessage (boolean success, String info) {
        this.success = success;
        this.additionalInfo = info;
    }

    public boolean isSuccessful () {
        return this.success;
    }

    public String getAdditionalInfo () {
        return this.additionalInfo;
    }
}
