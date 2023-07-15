module com.example.loginandsignupsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.loginandsignupsystem to javafx.fxml;
    exports com.example.loginandsignupsystem;
}