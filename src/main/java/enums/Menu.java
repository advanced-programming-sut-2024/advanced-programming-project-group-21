package enums;

import view.AppMenu;
import view.ExitMenu;
import view.GameMenu;
import view.Login.LoginMenu;
import view.Main.MainMenu;
import view.Profile.ProfileMenu;

import java.util.Scanner;

public enum Menu {
    GameMenu(new GameMenu()),
    LoginMenu(new LoginMenu()),
    MainMenu(new MainMenu()),
    ProfileMenu(new ProfileMenu()),
    ExitMenu(new ExitMenu());


    private final AppMenu menu;

    Menu(AppMenu menu) {
        this.menu = menu;
    }

    public void checkCommand(Scanner scanner) {
        this.menu.check(scanner);
    }

}
