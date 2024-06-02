package view.Register;

import controller.RegisterMenuController;
import view.AppMenu;

import java.util.Scanner;
import java.util.regex.Matcher;

public class RegisterMenu extends AppMenu {
    private final RegisterMenuController controller = new RegisterMenuController();

    @Override
    public void check(Scanner scanner){
        String input = scanner.nextLine().trim();
        Matcher matcher;
    }
}
