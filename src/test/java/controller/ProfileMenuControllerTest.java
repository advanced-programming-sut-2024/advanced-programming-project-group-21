package controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import model.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ProfileMenuControllerTest {

    private ProfileMenuController controller;

    @BeforeEach
    public void setUp() {
        controller = new ProfileMenuController();
    }

    @Test
    public void testSetLoggedInUser() {
        User mockUser = mock(User.class);

        try (MockedStatic<DataBaseController> mockedDBController = mockStatic(DataBaseController.class)) {
            controller.setLoggedInUser(mockUser);

            mockedDBController.verify(() -> DataBaseController.saveLoggedInUser(mockUser));
        }
    }

    @Test
    public void testClearLoggedInUser() {
        try (MockedStatic<DataBaseController> mockedDBController = mockStatic(DataBaseController.class)) {
            controller.clearLoggedInUser();

            mockedDBController.verify(DataBaseController::clearLoggedInUser);
        }
    }
}
