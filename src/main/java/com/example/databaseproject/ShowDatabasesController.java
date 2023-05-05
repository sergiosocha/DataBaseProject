package com.example.databaseproject;

import com.example.databaseproject.modelo.Database_model;
import javafx.beans.Observable;
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


    @javafx.fxml.FXML
    private Button cerrarsesion_button;
    @javafx.fxml.FXML
    private TableColumn databases_table;
    @javafx.fxml.FXML
    private TableView dataBases;

    private ObservableList<Database_model> databases;

    public void initialize(){
        this.database_model = new Database_model();
        this.logginController = new HelloController();
        modelaTabla();

        String url = "jdbc:mysql://localhost:3306/";
        logginController.conexion(logginController.user, logginController.pasword);
        String username = logginController.conexion;
        String password = logginController.pasword;


        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");


            while (resultSet.next()) {
                Database_model data = new Database_model(resultSet.getString("DataBase"));
                System.out.println(resultSet.getString("DataBase"));
                this.databases.add(data);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }



    }

    @javafx.fxml.FXML
    public void cerrarsesion_button(ActionEvent actionEvent) {
    }

    public void modelaTabla(){

        this.databases = FXCollections.observableArrayList();

        this.databases_table.setCellValueFactory(new PropertyValueFactory("Bases De Datos"));



    }
}
