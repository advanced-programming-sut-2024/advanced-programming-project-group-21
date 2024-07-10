package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DataBaseControllerTest {

    @BeforeEach
    public void setUp() {
        // No specific setup needed before each test
    }

    @Test
    public void testLoadUsersFromJson() throws IOException {
        try (MockedStatic<Files> mockedFiles = mockStatic(Files.class);
             MockedStatic<User> mockedUser = mockStatic(User.class)) {
            String json = "[{\"username\":\"user1\"},{\"username\":\"user2\"}]";
            mockedFiles.when(() -> Files.readAllBytes(Paths.get(DataBaseController.USERS_DATABASE_PATH)))
                    .thenReturn(json.getBytes());

            DataBaseController.loadUsersFromJson();

            ArrayList<User> users = new ArrayList<>();
            users.add(new User("user1","","",""));
            users.add(new User("user2","","",""));

            mockedUser.verify(() -> User.setUsers(users));
        }
    }

    @Test
    public void testLoadUsersFromJson_Exception() {
        try (MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.readAllBytes(Paths.get(DataBaseController.USERS_DATABASE_PATH)))
                    .thenThrow(IOException.class);

            assertDoesNotThrow(() -> DataBaseController.loadUsersFromJson());
        }
    }

    @Test
    public void testSaveUsersToJson() throws IOException {
        try (MockedStatic<User> mockedUser = mockStatic(User.class);
             MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
            List<User> users = new ArrayList<>();
            users.add(new User("user1","","",""));
            users.add(new User("user2","","",""));
            mockedUser.when(User::getUsers).thenReturn(users);

            FileWriter fileWriterMock = mock(FileWriter.class);
            try (MockedStatic<FileWriter> mockedFileWriter = mockStatic(FileWriter.class)) {
                mockedFileWriter.when(() -> new FileWriter(DataBaseController.USERS_DATABASE_PATH))
                        .thenReturn(fileWriterMock);

                DataBaseController.saveUsersToJson();

                verify(fileWriterMock, times(1)).write(anyString());
                verify(fileWriterMock, times(1)).close();
            }
        }
    }

    @Test
    public void testSaveUsersToJson_Exception() throws IOException {
        try (MockedStatic<User> mockedUser = mockStatic(User.class)) {
            List<User> users = new ArrayList<>();
            users.add(new User("user1","","",""));
            users.add(new User("user2","","",""));
            mockedUser.when(User::getUsers).thenReturn(users);

            try (MockedStatic<FileWriter> mockedFileWriter = mockStatic(FileWriter.class)) {
                mockedFileWriter.when(() -> new FileWriter(DataBaseController.USERS_DATABASE_PATH))
                        .thenThrow(IOException.class);

                assertThrows(RuntimeException.class, DataBaseController::saveUsersToJson);
            }
        }
    }

    @Test
    public void testLoadLoggedInUser() throws IOException {
        try (MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
            String json = "{\"username\":\"loggedInUser\"}";
            mockedFiles.when(() -> Files.readAllBytes(Paths.get("src/main/java/model/User/loggedIn.json")))
                    .thenReturn(json.getBytes());

            User loggedInUser = DataBaseController.loadLoggedInUser();

            assertNotNull(loggedInUser);
            assertEquals("loggedInUser", loggedInUser.getUsername());
        }
    }

    @Test
    public void testLoadLoggedInUser_Exception() {
        try (MockedStatic<Files> mockedFiles = mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.readAllBytes(Paths.get("src/main/java/model/User/loggedIn.json")))
                    .thenThrow(IOException.class);

            User loggedInUser = DataBaseController.loadLoggedInUser();

            assertNull(loggedInUser);
        }
    }

    @Test
    public void testSaveLoggedInUser() throws IOException {
        User mockUser = new User("loggedInUser","","","");

        FileWriter fileWriterMock = mock(FileWriter.class);
        try (MockedStatic<FileWriter> mockedFileWriter = mockStatic(FileWriter.class)) {
            mockedFileWriter.when(() -> new FileWriter("src/main/java/model/User/loggedIn.json"))
                    .thenReturn(fileWriterMock);

            DataBaseController.saveLoggedInUser(mockUser);

            verify(fileWriterMock, times(1)).write(anyString());
            verify(fileWriterMock, times(1)).close();
        }
    }

    @Test
    public void testSaveLoggedInUser_Exception() throws IOException {
        User mockUser = new User("loggedInUser","","","");

        try (MockedStatic<FileWriter> mockedFileWriter = mockStatic(FileWriter.class)) {
            mockedFileWriter.when(() -> new FileWriter("src/main/java/model/User/loggedIn.json"))
                    .thenThrow(IOException.class);

            assertDoesNotThrow(() -> DataBaseController.saveLoggedInUser(mockUser));
        }
    }

    @Test
    public void testClearLoggedInUser() throws IOException {
        FileWriter fileWriterMock = mock(FileWriter.class);
        try (MockedStatic<FileWriter> mockedFileWriter = mockStatic(FileWriter.class)) {
            mockedFileWriter.when(() -> new FileWriter("src/main/java/model/User/loggedIn.json"))
                    .thenReturn(fileWriterMock);

            DataBaseController.clearLoggedInUser();

            verify(fileWriterMock, times(1)).write("");
            verify(fileWriterMock, times(1)).close();
        }
    }

    @Test
    public void testClearLoggedInUser_Exception() throws IOException {
        try (MockedStatic<FileWriter> mockedFileWriter = mockStatic(FileWriter.class)) {
            mockedFileWriter.when(() -> new FileWriter("src/main/java/model/User/loggedIn.json"))
                    .thenThrow(IOException.class);

            assertDoesNotThrow(DataBaseController::clearLoggedInUser);
        }
    }
}
