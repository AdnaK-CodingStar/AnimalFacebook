package GUI.login;

import controller.Controller;
import controller.events.LoginEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author AdnaK
 */
public class LoginView extends GridPane
{
    private final Label usernameLabel = new Label("Username:");
    private final Label passwordLabel = new Label("Password:");
    private final TextField usernameTextField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final Button loginButton = new Button("Sign in");
    private final Button cancelButton = new Button("Cancel");
    private Label messageLabel = new Label();

    public LoginView() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        setAlignment(Pos.CENTER);

        add(usernameLabel, 0, 0);
        add(usernameTextField, 1, 0);

        add(passwordLabel, 0, 1);
        add(passwordField, 1, 1);
        
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.getChildren().addAll(loginButton, cancelButton);
        add(flowPane, 1, 3);

        add(messageLabel, 1, 4);
        LoginEvent loginEvent = Controller.getInstance().getEventBus().getLoginEvent();
        
        loginButton.setOnAction(loginEvent);
        cancelButton.setOnAction(Controller.getInstance().getEventBus().getCancelEvent());
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getMessageLabel() {
        return messageLabel;
    }
}
