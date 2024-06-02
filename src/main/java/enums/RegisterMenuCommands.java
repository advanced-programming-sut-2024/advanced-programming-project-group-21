package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegisterMenuCommands {
    EnterLogin("menu enter login menu"),
    Register("register -u (?<username>.+) -p (?<password>.+) (?<passwordConfirm>.+)" +
            " -n (?<nickname>.+) -e (?<email>.+)"),
    PickQuestion(""); // TODO
    public final String pattern;

    RegisterMenuCommands(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMather(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);

        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
