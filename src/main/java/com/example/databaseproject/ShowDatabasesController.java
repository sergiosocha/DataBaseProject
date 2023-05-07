package com.example.databaseproject;

import com.example.databaseproject.modelo.Database;
import com.example.databaseproject.modelo.Table;
import com.example.databaseproject.modelo.UserModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class ShowDatabasesController {

    com.example.databaseproject.modelo.Database dataBaseM;
    HelloController logginController;
    UserModel userM;
    Table tableM;


    @javafx.fxml.FXML
    private Button cerrarsesion_button;

    private ObservableList<Database> databases;
    @javafx.fxml.FXML
    private Button update_button;
    @javafx.fxml.FXML
    private TableView<com.example.databaseproject.modelo.Database> dataBases_tableView;
    @javafx.fxml.FXML
    private TableColumn<Database, String> Database;
    @javafx.fxml.FXML
    private TableView<Table> showTables_TableView;
    @javafx.fxml.FXML
    private TableColumn<Table, String> showTables;
    private ObservableList<Table> Tables;

    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "12345";

    public void initialize(){

        this.logginController = new HelloController();
        modelaTabla();
    }

    @javafx.fxml.FXML
    public void cerrarsesion_button(ActionEvent actionEvent) {
    }

    public void modelaTabla(){
        this.databases = FXCollections.observableArrayList();
        this.Tables = FXCollections.observableArrayList();

    }

    public void cargarDataBase(){

    }

    @javafx.fxml.FXML
    public void update_buttonAction(ActionEvent actionEvent) {

        modelaTabla();



        ObservableList<Database> databases = FXCollections.observableArrayList();
        this.Database.setCellValueFactory(new PropertyValueFactory("Database"));


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

    @javafx.fxml.FXML
    public void selectDataBase(Event event) throws SQLException {

        Database doSelected = this.dataBases_tableView.getSelectionModel().getSelectedItem();
        String searchDatabase = doSelected.getDatabase().getValue();

        String urlToSearch = "jdbc:mysql://localhost:3306/"+searchDatabase;
        System.out.println(searchDatabase);
       // if(doSelected == null){
         //   System.out.println("No ha Seleccionado nada");
        //}else {


        ObservableList<Table> tables = FXCollections.observableArrayList();
        this.showTables.setCellValueFactory(new PropertyValueFactory("Table"));




        try {
            Connection connection = DriverManager.getConnection(urlToSearch,username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SHOW TABLES");
            while (resultSet.next()){
                System.out.println(resultSet.getString("Tables_in_"+searchDatabase));

                Table st = new Table();
                st.setTable(resultSet.getString("Tables_in_"+searchDatabase));
                tables.add(st);
            }

            showTables_TableView.setItems(tables);
            showTables.setCellValueFactory(f->f.getValue().getTable());



        }catch (SQLException e){
            e.printStackTrace();
        }




    }
}
