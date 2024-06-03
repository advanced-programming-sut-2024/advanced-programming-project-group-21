package enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum SecurityQuestions {
    HighSchool("Name of your high school name?");
    public final String question;

    SecurityQuestions(String question) {
        this.question = question;
    }
}
