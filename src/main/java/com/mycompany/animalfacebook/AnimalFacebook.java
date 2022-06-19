package com.mycompany.animalfacebook;

import GUI.login.LoginView;
import controller.Controller;
import controller.constants.Constants;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class AnimalFacebook extends Application {

    @Override
    public void start(Stage primaryStage) {
        Controller.getInstance().setPrimaryStage(primaryStage);
        LoginView loginView = new LoginView();
        Controller.getInstance().setLoginView(loginView);
        
        Scene scene = new Scene(loginView, 650, 180);
        
        primaryStage.setTitle(Constants.LOGIN_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}