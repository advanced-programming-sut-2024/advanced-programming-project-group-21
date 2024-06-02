package view.Register;

import controller.LoginMenuController;
import controller.RegisterMenuController;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RegisterMenuViewController {
    public TextField usernameField;
    public TextField nicknameField;
    public TextField emailField;
    public PasswordField passwordField;
    public TextField confirmPasswordField;

    RegisterMenuController controller = new RegisterMenuController();

    public void generateStrongPassword(MouseEvent mouseEvent) {
        String strongPassword = controller.createRandomPassword();
        passwordField.setText(strongPassword);
        confirmPasswordField.setText(strongPassword);
    }

    public void register(MouseEvent mouseEvent) {

    }
}
