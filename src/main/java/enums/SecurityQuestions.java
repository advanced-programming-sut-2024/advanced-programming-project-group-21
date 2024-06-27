package enums;

public enum SecurityQuestions {
    HighSchool("Name of your high school name?"),
    City("In what city were you born?"),
    Pet("What is the name of your favorite pet?"),
    Birthday("What is your date of birth?"),
    Sign("What is your astrological sign?"),
    Food("What is your favorite food?"),
    Parents("In which city did your parents meet?");

    public final String question;

    SecurityQuestions(String question) {
        this.question = question;
    }
}
