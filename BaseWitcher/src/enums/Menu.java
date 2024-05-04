package enums;

import view.*;

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
