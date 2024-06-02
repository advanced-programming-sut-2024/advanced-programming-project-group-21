package view.Profile;

import controller.ProfileMenuController;
import view.AppMenu;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenu extends AppMenu {
    private final ProfileMenuController controller = new ProfileMenuController();

    @Override
    public void check(Scanner scanner){
        String input = scanner.nextLine().trim();
        Matcher matcher;
    }
}
