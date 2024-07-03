module witcher {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires javafx.graphics;
    requires com.google.gson;


    exports view;
    exports model.User;
    opens view.ScoreBoard;
    opens view to javafx.fxml;
    opens model.User to com.google.gson;
    exports view.Login;
    exports view.ScoreBoard;
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
    exports view.Pregame;
    opens view.Pregame to javafx.fxml;
    exports view.Faction;
    opens view.Faction to javafx.fxml;
    exports view.Commander;
    opens view.Commander to javafx.fxml;
    exports view.GameHistory;
    opens view.GameHistory to javafx.fxml;
    exports view.UserInfo;
    opens view.UserInfo to javafx.fxml;
    exports view.Game;
    opens view.Game to javafx.fxml;
}