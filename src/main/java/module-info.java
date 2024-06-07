module witcher {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires jackson.annotations;

    exports view;
    opens view to javafx.fxml;
    opens model to com.fasterxml.jackson.databind;
    exports view.Login;
    opens view.Login to javafx.fxml;
    exports view.Main;
    opens view.Main to javafx.fxml;
    exports view.Register;
    opens view.Register to javafx.fxml;
    exports view.Profile;
    opens view.Profile to javafx.fxml;
    exports view.Question;
    opens view.Question to javafx.fxml;
    exports view.ForgetPassword;
    opens view.ForgetPassword to javafx.fxml;
    opens model.User to com.fasterxml.jackson.databind;
    exports view.Pregame;
    opens view.Pregame to javafx.fxml;
}