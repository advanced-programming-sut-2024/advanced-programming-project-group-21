package controller;

import java.util.Random;

public class AuthenticationMenuController {
    private static int authCode;
    static Random random = new Random();
    public static boolean checkLogin(String authText) {
        int code = Integer.parseInt(authText);
        return code == authCode;
    }
    public static int generateRandomCode() {
        int code = 100000 + random.nextInt(900000);
        authCode = code;
        return code;
    }
}
