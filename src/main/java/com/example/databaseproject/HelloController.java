package com.example.databaseproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.w3c.dom.events.Event;

import java.sql.*;

public class HelloController {

    @FXML
    private TextField password_id;
    @FXML
    private TextField user_id;
    @FXML
    private Button loggin_password;

    @FXML
    public void loggin(ActionEvent actionEvent) {
        String url = "jdbc:mysql://localhost:3306/";
        String username= user_id.getText();
        String password= password_id.getText();
        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");

            while ( resultSet.next()){
                System.out.println(resultSet.getString("DataBase"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}

