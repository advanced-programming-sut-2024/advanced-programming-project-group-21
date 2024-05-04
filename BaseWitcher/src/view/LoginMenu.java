package view;

import controller.LoginMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class LoginMenu extends AppMenu{
    private final LoginMenuController controller = new LoginMenuController();

    @Override
    public void check(Scanner scanner){
        String input = scanner.nextLine().trim();
        Matcher matcher;
    }
}
