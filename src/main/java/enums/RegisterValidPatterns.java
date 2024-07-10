package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegisterValidPatterns {
    STRONG_PASSWORD(""),
    USERNAME(""),
    ;


    public final String pattern;

    RegisterValidPatterns(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMather(String input) {
        return Pattern.compile(this.pattern).matcher(input);
    }
}
