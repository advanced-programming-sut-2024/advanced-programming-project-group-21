package ClientServer.Server.model;

import ClientServer.Server.TCPServerWorker;
import model.Card;
import model.Game;
import model.User.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.*;

// Server side
public class GameServer {
    private static Map<Integer, GameServer> games; // Map of game ID to game instance
    private User user1;
    private User user2;
    private ArrayList<Card> deckCards1;
    private ArrayList<Card> deckCards2;
    private int id;

    public GameServer() {
        id = generateGameId();
        if(games == null){
            games = new HashMap<>();
        }
        games.put(id, this);
    }

    private int generateGameId() {
        Random random = new Random();
        int id = 0;
        int randomNum = 0;
        for (int i = 0; i < 6; i++) {
            randomNum = random.nextInt(10);
            id = id * 10 + randomNum;
        }
        return id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public static void removeFromGames(int gameId) {
        games.remove(gameId);
    }

    public static GameServer getGame(int gameId) {
        if(games == null)
            return null;
        return games.get(gameId);
    }


    public static Map<Integer, GameServer> getGames() {
        return games;
    }


    public int getId() {
        return id;
    }

    public void setDeckCards1(ArrayList<Card> deckCards1) {
        this.deckCards1 = deckCards1;
    }

    public void setDeckCards2(ArrayList<Card> deckCards2) {
        this.deckCards2 = deckCards2;
    }

    public ArrayList<Card> getDeckCards1() {
        return deckCards1;
    }

    public ArrayList<Card> getDeckCards2() {
        return deckCards2;
    }
}