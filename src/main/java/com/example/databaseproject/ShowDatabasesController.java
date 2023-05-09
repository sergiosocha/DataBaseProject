package com.example.databaseproject;

import com.example.databaseproject.modelo.Database;
import com.example.databaseproject.modelo.Table;
import com.example.databaseproject.modelo.User;
import com.example.databaseproject.modelo.newTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.*;
import javax.swing.*;

public class ShowDatabasesController {
    com.example.databaseproject.modelo.Database dataBaseM;
    HelloController logginController;
    User userM;
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

    @javafx.fxml.FXML
    private Button createNewTable_button;
    @javafx.fxml.FXML
    private Pane createTables_interface;
    @javafx.fxml.FXML
    private Button volverShowTables_Button;
    @javafx.fxml.FXML
    private Pane ShowDatabasesPane;
    @javafx.fxml.FXML
    private TextField nameCampoNewTable;
    @javafx.fxml.FXML
    private ComboBox<String> typesComboBox;
    @javafx.fxml.FXML
    private CheckBox nullCheckBox;
    @javafx.fxml.FXML
    private TableView<newTable> fieldTables;
    @javafx.fxml.FXML
    private TableColumn<newTable, String> nameColumb;
    @javafx.fxml.FXML
    private TableColumn<newTable, String>  typeColumb;
    @javafx.fxml.FXML
    private TableColumn<newTable, String>  extraColumb;
    @javafx.fxml.FXML
    private TableColumn<newTable, String>  nullColumb;
    @javafx.fxml.FXML
    private TextField varCharacters;
    @javafx.fxml.FXML
    private Button createTableButton;
    @javafx.fxml.FXML
    private Button deleteFieldButton;
    @javafx.fxml.FXML
    private Button modifyFieldButton;
    @javafx.fxml.FXML
    private Button newFieldButton;

    private ObservableList<newTable> newTables;

    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "12345";
    @javafx.fxml.FXML
    private Button create_button;
    @javafx.fxml.FXML
    private Button delete_button;

    Connection con;
    PreparedStatement pst;


    public void Connection(){
        try{
            con = DriverManager.getConnection(url,username, password);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void cerrarsesion_button(ActionEvent actionEvent) {
    }

    public void modelaTabla(){
        this.databases = FXCollections.observableArrayList();
        this.Tables = FXCollections.observableArrayList();


    }

    @javafx.fxml.FXML
    public void update_buttonAction(ActionEvent actionEvent) {

        modelaTabla();
        tableDataBases();

    }

    public void tableDataBases(){
        Connection(); //Trae la funcion Connection para poder usarla en el CreateStatement para luego prepara la consulta
        ObservableList<Database> databases = FXCollections.observableArrayList();
        this.Database.setCellValueFactory(new PropertyValueFactory("Database"));

        try {

            Statement statement = con.createStatement(); //Usa con previamente declarado en las variables para preparar el Statement
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");//Con el statement anterior en un nuevo objeto resulset preparamos el query

            while ( resultSet.next()){
                Database st = new Database(); //Creamos un nuevo objeto de tipo DataBase en este caso st
                st.setDatabase(resultSet.getString("Database"));//Usamos St para dar formato a los datos que obtenemos
                String var = resultSet.getString("DataBase");
                databases.add(st); //agregamos al oversableList los elementos st
            }

            dataBases_tableView.setItems(databases);//Traemos los items a la table view
            Database.setCellValueFactory(f->f.getValue().getDatabase());//damos formatos ala la columna o celdas dentro de la tabla
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void selectDataBase(Event event) throws SQLException {

        Database doSelected = this.dataBases_tableView.getSelectionModel().getSelectedItem();
        String searchDatabase = doSelected.getDatabase().getValue();
        String urlToSearch = url+searchDatabase;

        ObservableList<Table> tables = FXCollections.observableArrayList();
        this.showTables.setCellValueFactory(new PropertyValueFactory("Table"));

        try {
            Connection connection = DriverManager.getConnection(urlToSearch,username, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SHOW TABLES");
            while (resultSet.next()){
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

    @Deprecated
    public void doModify(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void doCreate(ActionEvent actionEvent) {

        String newDataBase = JOptionPane.showInputDialog("Ingrese el nombre de la base de datos: ");
        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            pst = connection.prepareStatement("CREATE DATABASE "+newDataBase);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CREATE");
            alert.setContentText("DATA BASE "+ newDataBase +" WAS CREATED");
            alert.showAndWait();
            tableDataBases();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @javafx.fxml.FXML
    public void doDelete(ActionEvent actionEvent) {
        Database doSelected = this.dataBases_tableView.getSelectionModel().getSelectedItem();
        String searchDatabase = doSelected.getDatabase().getValue();

        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            pst = connection.prepareStatement("DROP DATABASE "+searchDatabase);
            pst.executeUpdate();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DELETE");
            alert.setContentText("DATA BASE "+ searchDatabase +" WAS DELETED");
            alert.showAndWait();
            tableDataBases();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void doCreateNewTable(ActionEvent actionEvent) {
        fillComboBoxes();
        this.createTables_interface.setVisible(true);
        this.ShowDatabasesPane.setVisible(false);

        newTables = FXCollections.observableArrayList();
        setTablaFields();
        fieldTables.setItems(newTables);
    }

    @javafx.fxml.FXML
    public void doVolver(ActionEvent actionEvent) {
        this.createTables_interface.setVisible(false);
        this.ShowDatabasesPane.setVisible(true);
    }

    @javafx.fxml.FXML
    public void selectField(Event event) {
    }

    public void setTablaFields(){
        //DAMOS FORMATO ALAS CELDAS DE LA TABLA INTERFAZ CREACION NEW TABLE
        nameColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getName()));
        typeColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getType()));
        nullColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().isNullable() ? "NULL" : "NOT NULL"));
        extraColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getExtra()));
    }

    @javafx.fxml.FXML
    public void doCreateField(ActionEvent actionEvent) {


        try{


            String name = nameCampoNewTable.getText();
            boolean isNullable = nullCheckBox.isSelected();
            String type = typesComboBox.getValue();
            String extra = "ESTO FALTA KBRON";

            newTable tableData = new newTable(name, type, isNullable, extra);
            newTables.add(tableData);
            fieldTables.setItems(newTables);
            fieldTables.refresh();


        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @javafx.fxml.FXML
    public void doCreateTables(ActionEvent actionEvent) {



    }

    @javafx.fxml.FXML
    public void doDeleteField(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void doModifyField(ActionEvent actionEvent) {
    }


    public void fillComboBoxes(){
        typesComboBox.getItems().addAll(
                "Int",
                "Float",
                "Char",
                "Boolean",
                "Time",
                "Date",
                "DateTime"
        );
    }

    public void setTableFields(){
        this.nameColumb.setCellValueFactory(new PropertyValueFactory<> ("name"));
        this.typeColumb.setCellValueFactory(new PropertyValueFactory<>("type"));
        this.nullColumb.setCellValueFactory(new PropertyValueFactory<> ("Null"));
        this.extraColumb.setCellValueFactory(new PropertyValueFactory<> ("extra"));


    }
}
