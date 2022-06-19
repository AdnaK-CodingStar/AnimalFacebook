package controller.events;

import GUI.login.LoginView;
import business.facade.FacadeFactory;
import business.model.User;
import controller.Controller;
import controller.constants.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author AdnaK
 */
public class LoginEvent implements EventHandler<ActionEvent>
{
    @Override
    public void handle(ActionEvent event) {
        Controller controller = Controller.getInstance();
        LoginView loginView = controller.getLoginView();
        String username = loginView.getUsernameTextField().getText();
        String password = loginView.getPasswordField().getText();
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            loginView.getMessageLabel().setText(Constants.EMPTY_USERNAME_PASSWORD);
            return;
        }
        
        User user = FacadeFactory.getFacade().login(username, password);
        
        controller.setLoggedUser(user);
        String fullNameOfUser = user.getName() + " " + user.getSurname();
        BorderPane userView = null;
        
        Scene scene = new Scene(userView, 650, 300);
        controller.getPrimaryStage().setScene(scene);
    
        loginView.getMessageLabel().setText(Constants.BAD_USERNAME_PASSWORD_COMBINATION);
    }
}
