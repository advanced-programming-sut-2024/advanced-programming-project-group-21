package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthenticationMenuControllerTest {

    @BeforeEach
    public void setUp() {
        // Reset authCode before each test to avoid interference between tests
        AuthenticationMenuController.generateRandomCode();
    }

    @Test
    public void testGenerateRandomCode() {
        int code = AuthenticationMenuController.generateRandomCode();
        assertTrue(code >= 100000 && code <= 999999, "Generated code should be a 6-digit number.");
    }

    @Test
    public void testCheckLogin_CorrectCode() {
        int code = AuthenticationMenuController.generateRandomCode();
        assertTrue(AuthenticationMenuController.checkLogin(String.valueOf(code)), "Correct code should return true.");
    }

    @Test
    public void testCheckLogin_IncorrectCode() {
        int code = AuthenticationMenuController.generateRandomCode();
        assertFalse(AuthenticationMenuController.checkLogin(String.valueOf(code + 1)), "Incorrect code should return false.");
    }

    @Test
    public void testCheckLogin_NonNumericCode() {
        assertThrows(NumberFormatException.class, () -> {
            AuthenticationMenuController.checkLogin("abc123");
        }, "Non-numeric code should throw NumberFormatException.");
    }

    @Test
    public void testCheckLogin_EmptyCode() {
        assertThrows(NumberFormatException.class, () -> {
            AuthenticationMenuController.checkLogin("");
        }, "Empty code should throw NumberFormatException.");
    }

    @Test
    public void testCheckLogin_NullCode() {
        assertThrows(NullPointerException.class, () -> {
            AuthenticationMenuController.checkLogin(null);
        }, "Null code should throw NullPointerException.");
    }

    @Test
    public void testGenerateRandomCode_MultipleCalls() {
        int firstCode = AuthenticationMenuController.generateRandomCode();
        int secondCode = AuthenticationMenuController.generateRandomCode();
        assertNotEquals(firstCode, secondCode, "Multiple calls to generateRandomCode should produce different codes.");
    }
}
