package view;

import controller.MainMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu extends AppMenu{
    private final MainMenuController controller = new MainMenuController();

    @Override
    public void check(Scanner scanner){
        String input = scanner.nextLine().trim();
        Matcher matcher;
    }
}
