package controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import model.User.User;
import controller.RegisterMenuController;

public class RegisterMenuControllerTest {

    private RegisterMenuController controller;

    @BeforeEach
    public void setUp() {
        controller = new RegisterMenuController();
    }

    @Test
    public void testIsUsernameMade() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("existingUser")).thenReturn(mockUser);
        Mockito.when(User.getUserByUsername("newUser")).thenReturn(null);

        assertTrue(controller.isUsernameMade("existingUser"));
        assertFalse(controller.isUsernameMade("newUser"));
    }

    @Test
    public void testRegister_ValidRegistration() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("newUser")).thenReturn(null);

        int result = controller.register("nickname", "newUser", "email@example.com", "password", "password");
        assertEquals(0, result);
    }

    @Test
    public void testRegister_InvalidNickname() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("newUser")).thenReturn(null);

        int result = controller.register("", "newUser", "email@example.com", "password", "password");
        assertEquals(1, result);
    }

    @Test
    public void testRegister_InvalidUsername() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("")).thenReturn(null);

        int result = controller.register("nickname", "", "email@example.com", "password", "password");
        assertEquals(2, result);
    }

    @Test
    public void testRegister_InvalidEmail() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("newUser")).thenReturn(null);

        int result = controller.register("nickname", "newUser", "", "password", "password");
        assertEquals(3, result);
    }

    @Test
    public void testRegister_InvalidPassword() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("newUser")).thenReturn(null);

        int result = controller.register("nickname", "newUser", "email@example.com", "", "password");
        assertEquals(4, result);
    }

    @Test
    public void testRegister_InvalidConfirmPassword() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("newUser")).thenReturn(null);

        int result = controller.register("nickname", "newUser", "email@example.com", "password", "");
        assertEquals(5, result);
    }

    @Test
    public void testRegister_UsernameAlreadyExists() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("existingUser")).thenReturn(mockUser);

        int result = controller.register("nickname", "existingUser", "email@example.com", "password", "password");
        assertEquals(6, result);
    }

    @Test
    public void testRegister_PasswordMismatch() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("newUser")).thenReturn(null);

        int result = controller.register("nickname", "newUser", "email@example.com", "password", "differentPassword");
        assertEquals(7, result);
    }

    @Test
    public void testCreateRandomPassword() {
        String password = controller.createRandomPassword();
        assertNotNull(password);
        assertEquals(93, password.length());  // Assuming the length of characters string is 93
    }

    @Test
    public void testCreateNewUsername_UsernameExists() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("user")).thenReturn(mockUser);
        Mockito.when(User.getUserByUsername("user1")).thenReturn(null);

        String newUsername = controller.createNewUsername("user");
        assertEquals("user1", newUsername);
    }

    @Test
    public void testCreateNewUsername_UsernameNotExists() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("newUser")).thenReturn(null);

        String newUsername = controller.createNewUsername("newUser");
        assertNull(newUsername);
    }

    @Test
    public void testIsConfirmPasswordOk_Matching() {
        assertTrue(controller.isConfirmPasswordOk("password", "password"));
    }

    @Test
    public void testIsConfirmPasswordOk_NotMatching() {
        assertFalse(controller.isConfirmPasswordOk("password", "differentPassword"));
    }

    @Test
    public void testIsRegisterValid_AllValid() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("existingUser")).thenReturn(null);

        assertEquals(0, controller.isRegisterValid("newUser", "password", "password", "nickname", "email@example.com"));
    }

    @Test
    public void testIsRegisterValid_NicknameEmpty() {
        assertEquals(1, controller.isRegisterValid("newUser", "password", "password", "", "email@example.com"));
    }

    @Test
    public void testIsRegisterValid_UsernameEmpty() {
        assertEquals(2, controller.isRegisterValid("", "password", "password", "nickname", "email@example.com"));
    }

    @Test
    public void testIsRegisterValid_EmailEmpty() {
        assertEquals(3, controller.isRegisterValid("newUser", "password", "password", "nickname", ""));
    }

    @Test
    public void testIsRegisterValid_PasswordEmpty() {
        assertEquals(4, controller.isRegisterValid("newUser", "", "password", "nickname", "email@example.com"));
    }

    @Test
    public void testIsRegisterValid_ConfirmPasswordEmpty() {
        assertEquals(5, controller.isRegisterValid("newUser", "password", "", "nickname", "email@example.com"));
    }

    @Test
    public void testIsRegisterValid_UsernameExists() {
        User mockUser = Mockito.mock(User.class);
        Mockito.when(User.getUserByUsername("existingUser")).thenReturn(mockUser);

        assertEquals(6, controller.isRegisterValid("existingUser", "password", "password", "nickname", "email@example.com"));
    }

    @Test
    public void testIsRegisterValid_PasswordMismatch() {
        assertEquals(7, controller.isRegisterValid("newUser", "password", "differentPassword", "nickname", "email@example.com"));
    }
}
