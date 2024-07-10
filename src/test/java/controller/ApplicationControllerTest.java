package controller;

import javafx.stage.Stage;
import model.Game;
import model.PreGame;
import model.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationControllerTest {

    @BeforeEach
    public void setUp() {
        // Reset the static variables before each test
        ApplicationController.setStage(null);
        ApplicationController.setLoggedInUser(null);
        ApplicationController.setUserAGuest(false);
    }

    @Test
    public void testGetAndSetStage() {
        Stage mockStage = Mockito.mock(Stage.class);
        ApplicationController.setStage(mockStage);
        assertEquals(mockStage, ApplicationController.getStage());
    }

    @Test
    public void testGetAndSetLoggedInUser() {
        User mockUser = Mockito.mock(User.class);
        ApplicationController.setLoggedInUser(mockUser);
        assertEquals(mockUser, ApplicationController.getLoggedInUser());
    }

    @Test
    public void testIsAndSetUserAGuest() {
        ApplicationController.setUserAGuest(true);
        assertTrue(ApplicationController.isUserAGuest());

        ApplicationController.setUserAGuest(false);
        assertFalse(ApplicationController.isUserAGuest());
    }

    @Test
    public void testRandomIsNotNull() {
        assertNotNull(ApplicationController.random);
    }

    @Test
    public void testGameAndPreGameAreInitiallyNull() {
        assertNull(ApplicationController.game);
        assertNull(ApplicationController.preGame);
    }

    @Test
    public void testSetGame() {
        Game mockGame = Mockito.mock(Game.class);
        ApplicationController.game = mockGame;
        assertEquals(mockGame, ApplicationController.game);
    }

    @Test
    public void testSetPreGame() {
        PreGame mockPreGame = Mockito.mock(PreGame.class);
        ApplicationController.preGame = mockPreGame;
        assertEquals(mockPreGame, ApplicationController.preGame);
    }
}
