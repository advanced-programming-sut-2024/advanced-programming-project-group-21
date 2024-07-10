package controller;

import enums.RegisterValidPatterns;
import model.User.User;

import static controller.ApplicationController.random;

public class RegisterMenuController {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+=";
    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;
    private static final int PASSWORD_LENGTH = 8;

    boolean isUsernameMade(String username) {
        return User.getUserByUsername(username) != null;
    }

    public int register(String nickname, String username, String email, String password, String confirmPassword) {
        int result = isRegisterValid(username, password, confirmPassword, nickname, email);
        if (result != 0)
            return result;
        User user = new User(username, nickname, password, email);
        User.addUserToUsers(user);
        DataBaseController.saveUsersToJson();
        return 0;
    }

    public String createRandomPassword() {
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < PASSWORD_LENGTH; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        return new String(passwordArray);
    }

    public String createNewUsername(String username) {
        if (isUsernameMade(username)) {
            int i = 1;
            while (isUsernameMade(username + i)) {
                i++;
            }
            return username + i;
        }
        return null;
    }

    boolean isConfirmPasswordOk(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

    int isRegisterValid(String username, String password, String passwordConfirm, String nickname,
                        String email) {
        if (nickname.equals("")) return 1;
        if (username.equals("")) return 2;
        if (email.equals("")) return 3;
        if (password.equals("")) return 4;
        if (passwordConfirm.equals("")) return 5;
        if (isUsernameMade(username)) return 6;
        if (!isConfirmPasswordOk(password, passwordConfirm)) return 7;
        if (!RegisterValidPatterns.USERNAME.getMather(username).matches()) return 8;
        if (!RegisterValidPatterns.STRONG_PASSWORD.getMather(password).matches()) return 9;
        if (!RegisterValidPatterns.EMAIL.getMather(email).matches()) return 10;
        return 0;
    }
}
