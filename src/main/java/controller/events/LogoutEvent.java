package controller.events;

import GUI.login.LoginView;
import controller.Controller;
import controller.constants.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

/**
 *
 * @author AdnaK
 */
public class LogoutEvent implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent event) {
        Controller controller = Controller.getInstance();
        controller.setLoggedUser(null);
        LoginView loginView = new LoginView();
        controller.setLoginView(loginView);
        Scene scene = new Scene(loginView, 650, 180);
        controller.getPrimaryStage().setTitle(Constants.LOGIN_TITLE);
        controller.getPrimaryStage().setScene(scene);
    } 
}
