package com.example.databaseproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class HelloController_porsilacago {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}