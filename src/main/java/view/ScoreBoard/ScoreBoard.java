package view.ScoreBoard;

import controller.ScoreBoardController;
import view.AppMenu;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ScoreBoard extends AppMenu {
    private final ScoreBoardController controller = new ScoreBoardController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine().trim();
        Matcher matcher;
    }
}
