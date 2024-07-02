package view.ScoreBoard;

import controller.ScoreboardMenuController;
import view.AppMenu;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ScoreBoard extends AppMenu {
    private final ScoreboardMenuController controller = new ScoreboardMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        Matcher matcher;
    }
}
