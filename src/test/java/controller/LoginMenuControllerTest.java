package controller;

import static org.junit.jupiter.api.Assertions.*;

import model.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginMenuControllerTest {

    private LoginMenuController controller;

    @BeforeEach
    public void setUp() {
        controller = new LoginMenuController();
    }

    @Test
    public void testShowCurrentMenu() {
        // Since this method has no implementation, just verify it's callable
        controller.showCurrentMenu();
    }

    @Test
    public void testExitMenu() {
        // Since this method has no implementation, just verify it's callable
        controller.exitMenu();
    }

    @Test
    public void testEnterMenu_RegisterMenu() {
        assertTrue(controller.enterMenu("register menu"), "Entering 'register menu' should return true.");
    }

    @Test
    public void testEnterMenu_OtherMenu() {
        assertFalse(controller.enterMenu("other menu"), "Entering any menu other than 'register menu' should return false.");
    }

    @Test
    public void testLoginUser_EmptyUsername() {
        assertEquals(3, controller.loginUser("", "password"), "Empty username should return 3.");
    }

    @Test
    public void testLoginUser_UserDoesNotExist() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("nonexistent")).thenReturn(null);

        assertEquals(2, controller.loginUser("nonexistent", "password"), "Nonexistent user should return 2.");
    }

    @Test
    public void testLoginUser_WrongPassword() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("existent")).thenReturn(mockUser);
        Mockito.when(mockUser.getPassword()).thenReturn("correct_password");

        assertEquals(1, controller.loginUser("existent", "wrong_password"), "Wrong password should return 1.");
    }

    @Test
    public void testLoginUser_CorrectCredentials() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("existent")).thenReturn(mockUser);
        Mockito.when(mockUser.getPassword()).thenReturn("correct_password");

        assertEquals(0, controller.loginUser("existent", "correct_password"), "Correct credentials should return 0.");
    }

    @Test
    public void testSendEmail() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("user")).thenReturn(mockUser);
        Mockito.when(mockUser.getEmail()).thenReturn("user@example.com");

        // Mock GmailSender and AuthenticationMenuController.generateRandomCode
        GmailSender mockGmailSender = Mockito.mock(GmailSender.class);
        Mockito.doNothing().when(mockGmailSender).run();
        AuthenticationMenuController mockAuthController = Mockito.mock(AuthenticationMenuController.class);
        Mockito.when(AuthenticationMenuController.generateRandomCode()).thenReturn(Integer.valueOf("randomCode"));

        controller.sendEmail("user");

        Mockito.verify(mockGmailSender, Mockito.times(1)).run();
    }

    @Test
    public void testForgetPassword() {
        // Since this method has no implementation, just verify it's callable
        controller.forgetPassword("username");
    }

    @Test
    public void testAnswerQuestion() {
        // Since this method has no implementation, just verify it's callable
        controller.answerQuestion(1, "answer");
    }

    @Test
    public void testSetNewPassword() {
        // Since this method has no implementation, just verify it's callable
        controller.setNewPassword("newPassword");
    }
}
