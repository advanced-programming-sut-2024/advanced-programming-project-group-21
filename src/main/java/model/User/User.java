package model.User;

import ClientServer.Client.TCPClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controller.ApplicationController;
import model.Game;
import model.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String username;
    private String nickname;
    private String password;
    private String email;
    private HashMap<String, String> questions = new HashMap<>();
    private int rank;
    private double highestScore = 0;
    private int gamesPlayed = 0;
    private int wins = 0;
    private int lose = 0;
    private int draw = 0;
    private ArrayList<HashMap<String, String>> gameHistories = null;
    private boolean isStayingLoggedIn;
    private ArrayList<User> friends = new ArrayList<>();

    private String currentToken = null;
    private static HashMap<String, User> allUsersByToken = new HashMap<String, User>();
    private ArrayList<User> pendingFriendRequests = new ArrayList<>();
    private String enemyUsername = null;
    private boolean inGame = false;
    private boolean searchingForGame = false;
    private int gameId = 0;

    public User(String username, String nickname, String password, String email) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.gameHistories = new ArrayList<>();
    }

    public static HashMap<String,User> getUsers() {
        return allUsersByToken;
    }

    public static void addUserToUsers(String token, User user) {
        allUsersByToken.put(token, user);
    }

    public static void setUsers(HashMap<String,User> users) {
        User.allUsersByToken = users;
    }

    public static User findUserByToken(String token) {
        return allUsersByToken.get(token);
    }

    public static User getUserFromToken(String token) {
        return allUsersByToken.get(token);
    }


    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public double getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(double highestScore) {
        this.highestScore = highestScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static User getUserByUsername(String username) {
        User intendedUser = null;
        if (allUsersByToken == null) {
            return null;
        }
        for (User item : allUsersByToken.values()) {
            if (item.getUsername().equals(username)) {
                intendedUser = item;
            }
        }
        return intendedUser;
    }

    public ArrayList<HashMap<String, String>> getGameHistories() {
        return gameHistories;
    }

    public void setGameHistories(ArrayList<HashMap<String, String>> gameHistories) {
        this.gameHistories = gameHistories;
    }

    public void addToGameHistories(HashMap<String, String> gameHistory) {
        if (gameHistories == null) {
            gameHistories = new ArrayList<HashMap<String, String>>();
        }
        gameHistories.add(gameHistory);
    }

    public void addToQuestionAnswers(String question, String answer) {
        questions.put(question, answer);
    }

    public String getAnswer(String question) {
        return questions.get(question);
    }

    public boolean containsQuestion(String question) {
        return questions.containsKey(question);
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public boolean isStayingLoggedIn() {
        return isStayingLoggedIn;
    }

    public void setStayingLoggedIn(boolean stayingLoggedIn) {
        isStayingLoggedIn = stayingLoggedIn;
    }

    public void setCurrentToken(String currentToken) {
        if (this.currentToken != null)
            allUsersByToken.remove(this.currentToken);
        this.currentToken = currentToken;
        if (currentToken != null)
            allUsersByToken.put(currentToken, this);
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public User getEnemyUser() {
        return TCPClient.getInstance().getUserFromUsername(enemyUsername);
    }

    public void setEnemyUser(User enemyUser) {
        this.enemyUsername = enemyUser.getUsername();
    }

    public void removeUserFromTokenMap(String token) {
        allUsersByToken.remove(token);
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public static void addUserToTokenMap(String token, User user) {
        allUsersByToken.put(token, user);
    }

    public boolean isSearchingForGame() {
        return searchingForGame;
    }

    public void setSearchingForGame(boolean searchingForGame) {
        this.searchingForGame = searchingForGame;
    }

    public ArrayList<User> getFriendRequests() {
        return pendingFriendRequests;
    }

    public void setPendingFriendRequests(ArrayList<User> friendRequests) {
        this.pendingFriendRequests = friendRequests;
    }
    public void addToPendingFriendRequests(User user) {
        pendingFriendRequests.add(user);
    }
    public void removeFromFriendRequests(User user) {
        pendingFriendRequests.remove(user);
    }
    public void addToFriends(User user) {
        friends.add(user);
    }
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }
}
