package view;

import controller.GameMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu extends AppMenu{
    private final GameMenuController controller = new GameMenuController();

    @Override
    public void check(Scanner scanner){
        String input = scanner.nextLine().trim();
        Matcher matcher;
    }
}
