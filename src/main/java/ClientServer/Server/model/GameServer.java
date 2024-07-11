package ClientServer.Server.model;

import ClientServer.Server.TCPServerWorker;
import model.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;

// Server side
public class GameServer {
    private ServerSocket serverSocket;
    private Map<Integer, Game> games; // Map of game ID to game instance
    private Map<Integer, List<TCPServerWorker>> gameClients; // Map of game ID to list of clients

    public GameServer() throws IOException {
        serverSocket = new ServerSocket(5000);
        games = new HashMap<>();
        gameClients = new HashMap<>();
    }

    public void startGame(TCPServerWorker client1, TCPServerWorker client2) {
        int gameId = generateGameId();
        //games.put(gameId, new Game()); TODO: EDIT GAME
        gameClients.put(gameId, new ArrayList<>());
        gameClients.get(gameId).add(client1);
        gameClients.get(gameId).add(client2);
        new Thread(client1).start();
        new Thread(client2).start();
        games.get(gameId).start();
    }

    private int generateGameId() {
        Random random = new Random();
        int id = 0;
        int randomNum = 0;
        for (int i = 0; i < 8; i++) {
            randomNum = random.nextInt(10);
            id = id * 10 + randomNum;
        }
        return id;
    }
}