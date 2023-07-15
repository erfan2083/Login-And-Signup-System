package com.example.loginandsignupsystem;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    @FXML
    private Button createBtn;

    @FXML
    private Button gotoLoginBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private AnchorPane si_Form;

    @FXML
    private TextField si_Name;

    @FXML
    private PasswordField si_Password;

    @FXML
    private AnchorPane sideForm;

    @FXML
    private Button signupBtn;

    @FXML
    private AnchorPane su_Form;

    @FXML
    private TextField su_Name;

    @FXML
    private PasswordField su_Password;
    @FXML
    private ImageView iconImage;

    private Alert alert;
    public static String nameOfUser;

    ArrayList<User> users = new ArrayList<User>();


    public void switchForm(ActionEvent event){

        TranslateTransition slider = new TranslateTransition();

        if(event.getSource() == createBtn){
            slider.setNode(sideForm);
            slider.setToX(340);
            slider.setDuration(Duration.seconds(.5));
            si_Form.setVisible(false);

            slider.setOnFinished((ActionEvent e) -> {
                gotoLoginBtn.setVisible(true);
                createBtn.setVisible(false);
            });

            slider.play();
        } else if (event.getSource() == gotoLoginBtn) {
            slider.setNode(sideForm);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));
            si_Form.setVisible(true);

            slider.setOnFinished((ActionEvent e) -> {
                gotoLoginBtn.setVisible(false);
                createBtn.setVisible(true);
            });

            slider.play();
            
        }
    }

    public void createAccount(ActionEvent event){

        if (event.getSource() == signupBtn){
            if ((su_Name.getText().isEmpty()) || (su_Password.getText().isEmpty())){

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            }else {

                users.add(new User(su_Name.getText(), su_Password.getText()));

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Massage");
                alert.setHeaderText(null);
                alert.setContentText("Your account has been created successfully!");
                alert.showAndWait();

                su_Name.clear();
                su_Password.clear();

            }
        }

    }

    public void login(ActionEvent event) {

        if (event.getSource() == loginBtn){
            if ((si_Name.getText().isEmpty()) || (si_Password.getText().isEmpty())){

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                int flag = 0;
                for(int i=0; i< users.size(); i++){
                    if(si_Name.getText().equals(users.get(i).getName()) && si_Password.getText().equals(users.get(i).getPassword())){

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Massage");
                        alert.setHeaderText(null);
                        alert.setContentText("Login Successfully! Welcome " + users.get(i).getName());
                        alert.showAndWait();

                        si_Name.clear();
                        si_Password.clear();

                        // this is for closing the login page if you want to use it
                        //loginBtn.getScene().getWindow().hide();

                        nameOfUser = users.get(i).getName();

                        flag = 1;
                        break;
                    }
                }

                if(flag != 1){
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Your Name or Password is incorrect\nTry again!");
                    alert.showAndWait();
                }
            }
        }
    }

}