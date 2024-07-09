package controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import com.beust.ah.A;
import model.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ScoreBoard.ScoreBoardViewController;

public class ScoreBoardControllerTest {

    private ScoreBoardViewController mockController;

    @BeforeEach
    public void setUp() {
        mockController = mock(ScoreBoardViewController.class);
    }

    @Test
    public void testSetData_NoUsers() {
        ArrayList<User> users = new ArrayList<>();
        mockStatic(User.class);
        when(User.getUsers()).thenReturn(users);

        ScoreBoardController.setData(mockController);

        verifyNoInteractions(mockController);
    }

    @Test
    public void testSetData_OneUser() {
        ArrayList<User> users = new ArrayList<>();
        User user = createUser("user1", 100, 5);
        users.add(user);

        mockStatic(User.class);
        when(User.getUsers()).thenReturn(users);

        ScoreBoardController.setData(mockController);

        verify(mockController).username1.setText("user1");
        verify(mockController).score1.setText("100");
        verify(mockController).wins1.setText("5");
    }

    @Test
    public void testSetData_TwoUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(createUser("user1", 100, 5));
        users.add(createUser("user2", 200, 10));

        mockStatic(User.class);
        when(User.getUsers()).thenReturn(users);

        ScoreBoardController.setData(mockController);

        verify(mockController).username1.setText("user2");
        verify(mockController).score1.setText("200");
        verify(mockController).wins1.setText("10");

        verify(mockController).username2.setText("user1");
        verify(mockController).score2.setText("100");
        verify(mockController).wins2.setText("5");
    }

    @Test
    public void testSetData_ThreeUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(createUser("user1", 100, 5));
        users.add(createUser("user2", 200, 10));
        users.add(createUser("user3", 150, 7));

        mockStatic(User.class);
        when(User.getUsers()).thenReturn(users);

        ScoreBoardController.setData(mockController);

        verify(mockController).username1.setText("user2");
        verify(mockController).score1.setText("200");
        verify(mockController).wins1.setText("10");

        verify(mockController).username2.setText("user3");
        verify(mockController).score2.setText("150");
        verify(mockController).wins2.setText("7");

        verify(mockController).username3.setText("user1");
        verify(mockController).score3.setText("100");
        verify(mockController).wins3.setText("5");
    }

    private User createUser(String username, int highestScore, int wins) {
        User mockUser = mock(User.class);
        when(mockUser.getUsername()).thenReturn(username);
        when(mockUser.getHighestScore()).thenReturn((double) highestScore);
        when(mockUser.getWins()).thenReturn(wins);
        return mockUser;
    }
}
