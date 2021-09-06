package controller;

import GUI.login.LoginView;
import GUI.user.UserView;
import business.model.User;
import javafx.stage.Stage;

/**
 *
 * @author AdnaK
 */
public class Controller
{
    //MODEL 
    private User loggedUser;
    //VIEW
    private Stage primaryStage;
    private LoginView loginView;
    private UserView userView;
    private final EventBus eventBus = new EventBus();

    private Controller() {

    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }
    
    private static Controller INSTANCE;

    public static Controller getInstance() 
    {
        if (INSTANCE == null) 
        {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }

}
