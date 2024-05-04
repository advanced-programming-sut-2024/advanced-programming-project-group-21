package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuCommands {
    EnterRegister("menu enter register menu"),
    Login(""), // TODO
    ForgetPassword(""), // TODO
    AnswerQuestion(""), // TODO
    SetPassword(""); // TODO
    public final String pattern;

    LoginMenuCommands(String pattern) {
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
