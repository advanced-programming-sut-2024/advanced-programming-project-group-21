package model.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import controller.ApplicationController;

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
    private double highestScore;
    private int gamesPlayed = 0;
    private int wins = 0;
    private int lose = 0;
    private int draw = 0;
    public static User loggedInUser;
    private static ArrayList<User> users = new ArrayList<>();
    public static final String USERS_DATABASE_PATH = "src/main/java/model/User/users.json";

    public User(String username, String nickname, String password, String email) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void addUserToUsers(User user) {
        users.add(user);
    }

    public static void setUsers(ArrayList<User> users) {
        User.users = users;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
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

    public  String getUsername() {
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
        if (users == null) {
            return null;
        }
        for (User item : users) {
            if (item.getUsername().equals(username)) {
                intendedUser = item;
            }
        }
        return intendedUser;
    }

    public static void changeUsername(String newUsername) {
        loggedInUser.setUsername(newUsername);
    }

    public static void changeNickname(String newNickname) {
        loggedInUser.setNickname(newNickname);
    }

    public static void changeEmail(String newEmail) {
        loggedInUser.setEmail(newEmail);
    }

    public static void changePassword(String newPassword) {
        loggedInUser.setPassword(newPassword);
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
}
