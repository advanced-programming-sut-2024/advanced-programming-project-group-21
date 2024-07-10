package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.User.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataBaseController {
    public static final String USERS_DATABASE_PATH = "src/main/java/model/User/users.json";

    public static void loadUsersFromJson() {
        try {
            Gson gson = new Gson();
            String text = new String(Files.readAllBytes(Paths.get(USERS_DATABASE_PATH)));
            ArrayList<User> users = gson.fromJson(text, new TypeToken<List<User>>() {
            }.getType());
            if (users != null) {
                User.setUsers(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveUsersToJson() {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(USERS_DATABASE_PATH);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(User.getUsers());
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static User loadLoggedInUser() {
        try {
            Gson gson = new Gson();
            String text = new String(Files.readAllBytes(Paths.get("src/main/java/model/User/loggedIn.json")));
            User loggedInUser = gson.fromJson(text, User.class);
            return loggedInUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveLoggedInUser(User loggedInUser) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(loggedInUser);
            FileWriter fileWriter = new FileWriter("src/main/java/model/User/loggedIn.json");
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearLoggedInUser() {
        try {
            FileWriter fileWriter = new FileWriter("src/main/java/model/User/loggedIn.json");
            fileWriter.write("");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
