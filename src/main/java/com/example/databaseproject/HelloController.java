package com.example.databaseproject;

import com.example.databaseproject.modelo.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloController {
    User userM;
    @FXML
    private TextField password_id;
    @FXML
    private TextField user_id;
    @FXML
    private Button loggin_password;
    public String user = "";
    public String password = "";
    public String port = "";
    public String address = "";
    @FXML
    private TextField equipo_id;
    @FXML
    private TextField puerto_id;

    @FXML
    public void loggin(ActionEvent actionEvent) {

        this.userM = new User();
        user = user_id.getText();
        password = password_id.getText();
        port =puerto_id.getText();
        address=equipo_id.getText();

        System.out.println("jdbc:mysql://"+address+":"+port+"/");
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

            while ( resultSet.next()){
                System.out.println(resultSet.getString("DataBase"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

