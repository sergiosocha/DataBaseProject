package com.example.databaseproject;

import com.example.databaseproject.modelo.Database_model;
import com.example.databaseproject.modelo.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class ShowDatabasesController {

    Database_model database_model;
    HelloController logginController;
    UserModel userM;


    @javafx.fxml.FXML
    private Button cerrarsesion_button;
    @javafx.fxml.FXML
    private TableColumn databases_table;
    @javafx.fxml.FXML
    private TableView dataBases;

    private ObservableList<Database_model> databases;
    @javafx.fxml.FXML
    private Button update_button;

    public void initialize(){
        this.database_model = new Database_model();
        this.logginController = new HelloController();
        modelaTabla();
    }

    @javafx.fxml.FXML
    public void cerrarsesion_button(ActionEvent actionEvent) {
    }

    public void modelaTabla(){
        this.databases = FXCollections.observableArrayList();
        this.databases_table.setCellValueFactory(new PropertyValueFactory("Bases De Datos"));
    }

    public void cargarDataBase(){

    }

    @javafx.fxml.FXML
    public void update_buttonAction(ActionEvent actionEvent) {

        String url = "jdbc:mysql://localhost:3306/";


        HelloController loggin = new HelloController();
        String username = loggin.user;
        String password = loggin.password;

        System.out.println(username + "usuario");
        System.out.println(password + "password");


        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");


            while (resultSet.next()) {

                System.out.println(resultSet.getString("DataBase"));


            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
