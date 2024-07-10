package controller;

import model.User.User;

public class RegisterMenuController {

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
        StringBuilder password = new StringBuilder();
        String characters = "1234567890-=!@#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;'ASDFGHJKL:\"zxcvbnm,./ZXCVBNM<>?";
        for (int i = 0; i < characters.length(); i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            password.append(characters.charAt(randomIndex));
        }
        String result = password.toString();
        return result;
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
        if (password.equals(passwordConfirm))
            return true;
        return false;
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
        return 0;
    }
}
