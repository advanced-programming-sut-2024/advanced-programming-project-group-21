package controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import model.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class QuestionMenuControllerTest {

    private QuestionMenuController controller;

    @BeforeEach
    public void setUp() {
        controller = new QuestionMenuController();
    }

    @Test
    public void testSubmitAnswer_EmptyUsername() {
        int result = controller.submitAnswer("", "question", "answer", "pass", "confirm");
        assertEquals(1, result);
    }

    @Test
    public void testSubmitAnswer_NullQuestion() {
        int result = controller.submitAnswer("username", null, "answer", "pass", "confirm");
        assertEquals(2, result);
    }

    @Test
    public void testSubmitAnswer_EmptyAnswer() {
        int result = controller.submitAnswer("username", "question", "", "pass", "confirm");
        assertEquals(3, result);
    }

    @Test
    public void testSubmitAnswer_UserNotFound() {
        try (MockedStatic<User> mockedUser = mockStatic(User.class)) {
            mockedUser.when(() -> User.getUserByUsername("username")).thenReturn(null);

            int result = controller.submitAnswer("username", "question", "answer", "pass", "confirm");
            assertEquals(4, result);
        }
    }

    @Test
    public void testSubmitAnswer_QuestionNotFound() {
        try (MockedStatic<User> mockedUser = mockStatic(User.class)) {
            User mockUser = mock(User.class);
            mockedUser.when(() -> User.getUserByUsername("username")).thenReturn(mockUser);
            when(mockUser.containsQuestion("question")).thenReturn(false);

            int result = controller.submitAnswer("username", "question", "answer", "pass", "confirm");
            assertEquals(5, result);
        }
    }

    @Test
    public void testSubmitAnswer_WrongAnswer() {
        try (MockedStatic<User> mockedUser = mockStatic(User.class)) {
            User mockUser = mock(User.class);
            mockedUser.when(() -> User.getUserByUsername("username")).thenReturn(mockUser);
            when(mockUser.containsQuestion("question")).thenReturn(true);
            when(mockUser.getAnswer("question")).thenReturn("wrongAnswer");

            int result = controller.submitAnswer("username", "question", "answer", "pass", "confirm");
            assertEquals(6, result);
        }
    }

    @Test
    public void testSubmitAnswer_EmptyPassword() {
        try (MockedStatic<User> mockedUser = mockStatic(User.class)) {
            User mockUser = mock(User.class);
            mockedUser.when(() -> User.getUserByUsername("username")).thenReturn(mockUser);
            when(mockUser.containsQuestion("question")).thenReturn(true);
            when(mockUser.getAnswer("question")).thenReturn("answer");

            int result = controller.submitAnswer("username", "question", "answer", "", "confirm");
            assertEquals(7, result);
        }
    }

    @Test
    public void testSubmitAnswer_PasswordMismatch() {
        try (MockedStatic<User> mockedUser = mockStatic(User.class)) {
            User mockUser = mock(User.class);
            mockedUser.when(() -> User.getUserByUsername("username")).thenReturn(mockUser);
            when(mockUser.containsQuestion("question")).thenReturn(true);
            when(mockUser.getAnswer("question")).thenReturn("answer");

            int result = controller.submitAnswer("username", "question", "answer", "pass", "mismatch");
            assertEquals(8, result);
        }
    }

    @Test
    public void testSubmitAnswer_AllCorrect() {
        try (MockedStatic<User> mockedUser = mockStatic(User.class)) {
            User mockUser = mock(User.class);
            mockedUser.when(() -> User.getUserByUsername("username")).thenReturn(mockUser);
            when(mockUser.containsQuestion("question")).thenReturn(true);
            when(mockUser.getAnswer("question")).thenReturn("answer");

            int result = controller.submitAnswer("username", "question", "answer", "pass", "pass");
            assertEquals(0, result);
        }
    }

    @Test
    public void testSubmitAnswer_Single_NullQuestion() {
        int result = controller.submitAnswer("answer", null);
        assertEquals(1, result);
    }

    @Test
    public void testSubmitAnswer_Single_EmptyAnswer() {
        int result = controller.submitAnswer("", "question");
        assertEquals(2, result);
    }

    @Test
    public void testSubmitAnswer_Single_AllCorrect() {
        int result = controller.submitAnswer("answer", "question");
        assertEquals(0, result);
    }

    @Test
    public void testChangePassword_UserNotFound() {
        try (MockedStatic<User> mockedUser = mockStatic(User.class)) {
            mockedUser.when(() -> User.getUserByUsername("username")).thenReturn(null);

            assertThrows(AssertionError.class, () -> {
                controller.changePassword("username", "newPassword");
            });
        }
    }

    @Test
    public void testChangePassword_UserFound() {
        try (MockedStatic<User> mockedUser = mockStatic(User.class);
             MockedStatic<ApplicationController> mockedAppController = mockStatic(ApplicationController.class)) {
            User mockUser = mock(User.class);
            mockedUser.when(() -> User.getUserByUsername("username")).thenReturn(mockUser);

            controller.changePassword("username", "newPassword");

            verify(mockUser).setPassword("newPassword");
            mockedUser.verify(() -> ApplicationController.setLoggedInUser(mockUser));
            mockedAppController.verify(() -> ApplicationController.setLoggedInUser(mockUser));
        }
    }
}
