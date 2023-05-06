package com.example.databaseproject;

import com.example.databaseproject.modelo.Database;
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

    com.example.databaseproject.modelo.Database database_;
    HelloController logginController;
    UserModel userM;


    @javafx.fxml.FXML
    private Button cerrarsesion_button;

    private ObservableList<Database> databases;
    @javafx.fxml.FXML
    private Button update_button;
    @javafx.fxml.FXML
    private TableView<com.example.databaseproject.modelo.Database> dataBases_tableView;
    @javafx.fxml.FXML
    private TableColumn<Database, String> Database;

    public void initialize(){
        this.database_ = new Database();
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
        ObservableList<Database> databases = FXCollections.observableArrayList();
        this.Database.setCellValueFactory(new PropertyValueFactory("Database"));




        System.out.println(userM.getUser() + "user");
        System.out.println(userM.getPassword() + "password");


        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");

            while ( resultSet.next()){
                com.example.databaseproject.modelo.Database st = new Database();
                st.setDatabase(resultSet.getString("Database"));
                String var = resultSet.getString("DataBase");
                databases.add(st);

            }

            dataBases_tableView.setItems(databases);
            Database.setCellValueFactory(f->f.getValue().getDatabase());




        }catch (SQLException e){
            e.printStackTrace();
        }



    }
}
