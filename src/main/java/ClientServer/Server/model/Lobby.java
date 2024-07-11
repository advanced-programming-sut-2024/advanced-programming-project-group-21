package ClientServer.Server.model;

import java.util.HashMap;

public class Lobby {
    private HashMap<String,String> requesterRequestee;
    private static Lobby instance;

    private Lobby() {
        requesterRequestee = new HashMap<>();
    }

    public static Lobby getInstance() {
        if (instance == null) {
            instance = new Lobby();
        }
        return instance;
    }

    public void addRequest(String requester, String requestee) {
        requesterRequestee.put(requester, requestee);
    }

    public String getRequestee(String requester) {
        return requesterRequestee.get(requester);
    }

    public void removeRequest(String requester) {
        requesterRequestee.remove(requester);
    }

    public String getRequester(String requestee) {
        for (String requester : requesterRequestee.keySet()) {
            if (requesterRequestee.get(requester).equals(requestee)) {
                return requester;
            }
        }
        return null;
    }
}
