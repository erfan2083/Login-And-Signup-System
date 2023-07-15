package com.example.loginandsignupsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodDeliveryApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FoodDeliveryApp.class.getResource("LoginAndSignupPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Food delivery App");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}