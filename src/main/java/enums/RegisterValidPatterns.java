package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegisterValidPatterns {
    STRONG_PASSWORD("^(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*[0-9].*)(?=.*[!@#$%^&*].*)([a-zA-Z0-9!@#$%^&*]{8,})$"),
    USERNAME("^[a-zA-Z0-9_]{5,}$"),
    ;

    public final String pattern;

    RegisterValidPatterns(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMather(String input) {
        return Pattern.compile(this.pattern).matcher(input);
    }
}
