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

    }

    public void cargarDataBase(){

    }

    @javafx.fxml.FXML
    public void update_buttonAction(ActionEvent actionEvent) {
        this.userM = new UserModel();
        modelaTabla();

        String url = "jdbc:mysql://localhost:3306/";
        String username = "root";
        String password = "12345";




        System.out.println(userM.getUser() + "user");
        System.out.println(userM.getPassword() + "password");
        ObservableList<Database_model> databases = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");

            while ( resultSet.next()){
                Database_model st = new Database_model();
                st.setName(resultSet.getString("DataBase"));
                databases.add(st);

            }

            dataBases.setItems(databases);
            this.databases_table.setCellValueFactory(new PropertyValueFactory("databases_table"));


        }catch (SQLException e){
            e.printStackTrace();
        }



    }
}
