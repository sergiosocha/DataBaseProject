package com.example.databaseproject;

import com.example.databaseproject.modelo.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    UserModel userM;
    @FXML
    private TextField password_id;
    @FXML
    private TextField user_id;
    @FXML
    private Button loggin_password;

    public String user = "";
    public String password = "";




    @FXML
    public void loggin(ActionEvent actionEvent) {

        user = user_id.getText();
        password = password_id.getText();



        try {
            conexion(user,password);


            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("show_databases.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("show data bases!");
            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.loggin_password.getScene().getWindow();
            myStage.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }


    public void conexion (String username, String password){
        String url = "jdbc:mysql://localhost:3306/";


        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");




        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

