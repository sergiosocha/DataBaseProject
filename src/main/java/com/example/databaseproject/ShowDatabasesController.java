package com.example.databaseproject;

import com.example.databaseproject.modelo.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javax.swing.*;

import static java.util.Arrays.stream;

public class ShowDatabasesController implements Initializable {
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
    private TableColumn<newTable, String> typeColumb;
    @javafx.fxml.FXML
    private TableColumn<newTable, String> extraColumb;
    @javafx.fxml.FXML
    private TableColumn<newTable, String> nullColumb;
    @javafx.fxml.FXML
    private TableColumn<newTable, String> defaultColumb;
    @javafx.fxml.FXML
    private Button createTableButton;
    @javafx.fxml.FXML
    private Button deleteFieldButton;
    @javafx.fxml.FXML
    private Button modifyFieldButton;
    @javafx.fxml.FXML
    private Button newFieldButton;

    private ObservableList<newTable> newTables;
    private ObservableList<deleteMethod> dinamicTables;



    @javafx.fxml.FXML
    private Button create_button;
    @javafx.fxml.FXML
    private Button delete_button;
    Connection con;
    PreparedStatement pst;
    @javafx.fxml.FXML
    private TableView<ObservableList<String>> showTablesData;
    @javafx.fxml.FXML
    private Label dataBaseSelected;
    @javafx.fxml.FXML
    private TextField defaultValueTextField;
    @javafx.fxml.FXML
    private ComboBox<String> extraValueComboBox;
    @javafx.fxml.FXML
    private TextField nameTableTextField;
    private boolean nullable;
    User userLogged;
    @javafx.fxml.FXML
    private Button deleteTableButton;
    @javafx.fxml.FXML
    private Pane querysPane;
    @javafx.fxml.FXML
    private TextField user_id;
    @javafx.fxml.FXML
    private TextField equipo_id;
    @javafx.fxml.FXML
    private TextField puerto_id;
    @javafx.fxml.FXML
    private PasswordField password_id;
    @javafx.fxml.FXML
    private Button loggin_password;
    @javafx.fxml.FXML
    private Pane mainMenuPane;

    String address;
    String port;
    @javafx.fxml.FXML
    private Button querysButton;
    @javafx.fxml.FXML
    private Label tableSelectedLabel;
    @javafx.fxml.FXML
    private ComboBox<String> tableSelectedComboBox;
    @javafx.fxml.FXML
    private Label baseDatosLabel;
    @javafx.fxml.FXML
    private TableView<ObservableList<String>> tableViewQuerys;
    @javafx.fxml.FXML
    private Button createView;
    @javafx.fxml.FXML
    private Button executeQueryButton;
    @javafx.fxml.FXML
    private TextField textFieldQuery;
    @javafx.fxml.FXML
    private ComboBox<String> columnasComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> operadoresComboBox;
    @javafx.fxml.FXML
    private TextField valorTextField;
    @javafx.fxml.FXML
    private CheckBox andCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> columnasAndCB;
    @javafx.fxml.FXML
    private ComboBox<String> operadoresAndCB;
    @javafx.fxml.FXML
    private TextField valorFieldAnd;
    @javafx.fxml.FXML
    private Button backMainbutton;
    @javafx.fxml.FXML
    private Button updateQuery;
    @javafx.fxml.FXML
    private TextField nameOfView;
    @javafx.fxml.FXML
    private ComboBox<String> seleccionColumnas;
    @javafx.fxml.FXML
    private TextField limitTextField;
    @javafx.fxml.FXML
    private ComboBox<String> tableSelectedComboBox1;
    @javafx.fxml.FXML
    private ComboBox<String> columnasAndCB2;
    @javafx.fxml.FXML
    private Pane paneConsultasAdicional;
    @javafx.fxml.FXML
    private Label labelTitleCBA;
    @javafx.fxml.FXML
    private Pane filtroAdicionalCheckBox;
    @javafx.fxml.FXML
    private CheckBox andCheckBox1;
    @javafx.fxml.FXML
    private TextField limitTextFieldAux;
    @javafx.fxml.FXML
    private ComboBox<String> dbFilterCB;
    @javafx.fxml.FXML
    private Button modifyButton;
    @javafx.fxml.FXML
    private ComboBox<String> modifyCellDataCB;
    @javafx.fxml.FXML
    private Button deletePrueba;
    @javafx.fxml.FXML
    private TextField modifyField;
    @javafx.fxml.FXML
    private Label oldCamp;
    @javafx.fxml.FXML
    private Button querysButton1;
    @javafx.fxml.FXML
    private Button deletePrueba1;
    @javafx.fxml.FXML
    private Pane logginPane;


    String url ;

    @Deprecated
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.userLogged = new User();
        this.url = "jdbc:mysql://" + equipo_id.getText() + ":" + puerto_id.getText()+ "/";
    }

    //_CLASE LOGGIN__//
    @javafx.fxml.FXML
    public void loggin(ActionEvent actionEvent) { //SE ENCARGA DE VERIRIFCAR LA EXISTENCIA DE LA CONEXION
        String user = user_id.getText();
        String password = password_id.getText();
        port = puerto_id.getText();
        address = equipo_id.getText();

        userLogged.setUser(user);
        userLogged.setPassword(password);
        userLogged.setAddress(address);
        userLogged.setPort(port);

        System.out.println();
        System.out.println("jdbc:mysql://" + userLogged.getAddress() + ":" + userLogged.getPort() + "/");

        try {
            Connection connection = getConnection(userLogged);
            if (connection != null) {

                mainMenuPane.setVisible(true);
                tableDataBases();//LLENA CON LAS BASES DE DATOS ENCONTRADAS
                fillComboBoxes();//LLENA COMBOBOX ESTATICOS
                modelaTabla();//MODELA TABLA PARA CARGAR DATOS


            } else {
                showConnectionErrorAlert();
                user_id.setText("");
                password_id.setText("");
                puerto_id.setText("");
                equipo_id.setText("");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public Connection getConnection(User userData) {//RETORNA LA CONEXION COMO OBJETO
        String url = "jdbc:mysql://" + userData.getAddress() + ":" + userData.getPort() + "/";
        try {
            return DriverManager.getConnection(url, userData.getUser(), userData.getPassword());

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void showConnectionErrorAlert() { //ALERTA DE CONEXION FALLIDA
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error de conexión");
        alert.setHeaderText("No se pudo establecer la conexión a MySQL");
        alert.setContentText("Por favor, verifica los datos de conexión e intenta nuevamente.");
        alert.showAndWait();
    }

    public void Connection() {

        String newUrl = "jdbc:mysql://" + userLogged.getAddress() + ":" + userLogged.getPort() + "/";
        System.out.println("NEW URL   : " + newUrl);

        try {
            con = DriverManager.getConnection(newUrl, userLogged.getUser(), userLogged.getPassword());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void cerrarsesion_button(ActionEvent actionEvent) {//CIERRA SESION Y VUELVE AL LOGIN
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cerrar sesión");
        alert.setHeaderText("¿Estás seguro de que deseas cerrar sesión?");
        alert.setContentText("Se cerrará la conexión con la base de datos.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {

                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setTitle("Cierre de sesión");
                successAlert.setHeaderText(null);
                successAlert.setContentText("La sesión ha sido cerrada exitosamente.");
                successAlert.showAndWait();
            }
        });
        logginPane.setVisible(true);
        mainMenuPane.setVisible(false);
        createTables_interface.setVisible(false);
        querysPane.setVisible(false);
    }



    public void modelaTabla() {
        this.databases = FXCollections.observableArrayList();
        this.Tables = FXCollections.observableArrayList();
    }

    @javafx.fxml.FXML
    public void update_buttonAction(ActionEvent actionEvent) { //REFRESAR LA TABLA DE BASES DE DATOS
        modelaTabla();
        tableDataBases();

        String usuario = userLogged.getUser();
        String password = userLogged.getPassword();
        String port = userLogged.getPort();
        String addres = userLogged.getAddress();

        System.out.println("user  " + usuario);
        System.out.println("password  " + password);
        System.out.println("ADDRES  " + addres);
        System.out.println("port  " + port);


    }

    public void tableDataBases() {//TRAE LAS BASES DE DATOS Y LLENA LA TABLA

        Connection(); //Trae la función Connection para poder usarla en el CreateStatement para luego prepara la consulta
        ObservableList<Database> databases = FXCollections.observableArrayList();
        this.Database.setCellValueFactory(new PropertyValueFactory("Database"));//DAMOS FORMATO ALA COLUMNA DE LA TABLA
        try {
            Statement statement = con.createStatement(); //Usa con previamente declarado en las variables para preparar el Statement
            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");//Con el statement anterior en un nuevo objeto resulset preparamos el query

            while (resultSet.next()) {//OBTIENE DATOS HASTA QUE EXISTA UN NULL
                Database st = new Database(); //Creamos un nuevo objeto de tipo DataBase en este caso st
                st.setDatabase(resultSet.getString("Database"));//Usamos St para dar formato a los datos que obtenemos
                //String var = resultSet.getString("DataBase");
                databases.add(st); //agregamos al oversableList(Array Dinamico ) los elementos st
            }

            dataBases_tableView.setItems(databases);//Traemos los items a la table view
            ObservableList<String> dataBaseNames = FXCollections.observableArrayList();

            for (Database db : dataBases_tableView.getItems()) {//RECORRE LA TABLA PARA ALMACENAR LOS NOMBRES DE LA BASE DE DATOS
                dataBaseNames.add(String.valueOf(db.getDatabase().getValue()));//AGREGAMOS LOS NOMBRES AL ARRAY DataBaseNames
            }

            dbFilterCB.setItems(dataBaseNames);//COMBOBOX DINAMICOS CON EL ARRAY dataBaseNames

            Database.setCellValueFactory(f -> f.getValue().getDatabase());//damos formatos ala la columna o celdas dentro de la tabla

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void selectDataBase(Event event) throws SQLException {//CARGA LAS TABLAS AL SELECCIONAR UN ITEM EN LA TABLA BASE DE DATOS
        Database doSelected = this.dataBases_tableView.getSelectionModel().getSelectedItem();//VALOR SELECCIONADO
        String searchDatabase = doSelected.getDatabase().getValue();//SACAMOS EL VALOR PARA BASE DE DATOS

        String urlToSearch = url + searchDatabase;
        //ARREGLAR URL

        dataBaseSelected.setText(searchDatabase);//define tu base de datos en caso de que quieras cargar una tabla

        ObservableList<Table> tables = FXCollections.observableArrayList();
        this.showTables.setCellValueFactory(new PropertyValueFactory<>("Table"));

        try {
            Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SHOW TABLES");

            while (resultSet.next()) {
                Table st = new Table();
                st.setTable(resultSet.getString("Tables_in_" + searchDatabase));
                tables.add(st);
            }
            showTables_TableView.setItems(tables);

            ObservableList<String> tableNames = FXCollections.observableArrayList();
            for (Table table : showTables_TableView.getItems()) {
                tableNames.add(String.valueOf(table.getTable().getValue()));
            }

            tableSelectedComboBox.setItems(tableNames);//combobox dinamico consultas
            tableSelectedComboBox1.setItems(tableNames);

            showTables.setCellValueFactory(f -> f.getValue().getTable());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //url = address.getText + "::" + port.getText + "/"

    @javafx.fxml.FXML
    public void doCreate(ActionEvent actionEvent) {//CREA BASES DE DATOS
        String newDataBase = JOptionPane.showInputDialog("Ingrese el nombre de la base de datos: ");
        try {
            Connection connection = DriverManager.getConnection(url, userLogged.getUser(), userLogged.getPassword());
            pst = connection.prepareStatement("CREATE DATABASE " + newDataBase);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CREATE");
            alert.setContentText("DATA BASE " + newDataBase + " WAS CREATED");
            alert.showAndWait();//SIEMPRE TIENE QUE ESTAR PARA GENERAR LAS ALERTAS
            tableDataBases();//RECARGAMOS LA TABLA BASE DE DATOS

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void doDelete(ActionEvent actionEvent) { //ELIMINA LA BASE DE DATOS SELECCIONADA
        Database doSelected = this.dataBases_tableView.getSelectionModel().getSelectedItem();
        String searchDatabase = doSelected.getDatabase().getValue();

        try {
            Connection connection = DriverManager.getConnection(url, userLogged.getUser(), userLogged.getPassword());
            pst = connection.prepareStatement("DROP DATABASE " + searchDatabase);
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("DELETE");
            alert.setContentText("DATA BASE " + searchDatabase + " WAS DELETED");
            alert.showAndWait();

            tableDataBases();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void doCreateNewTable(ActionEvent actionEvent) {
        this.createTables_interface.setVisible(true);//CARGAMOS LA INTERFAZ O LA HACEMOS VISIBLE
        this.ShowDatabasesPane.setVisible(false);//VOLVEMOS INVISIBLE LA VENTANA PRINCIPAL
        newTables = FXCollections.observableArrayList(); //CREAMOS UN ARRAY DINAMICO PARA LOS CAMPOS DE LA NUEVA TABLA
        setTablaFields();//FORMATEA LA TABLA
        fieldTables.setItems(newTables);
    }

    @javafx.fxml.FXML
    public void doVolver(ActionEvent actionEvent) {//REGRESA AL MENU PRINCIPAL
        this.createTables_interface.setVisible(false);
        this.ShowDatabasesPane.setVisible(true);
    }

    @javafx.fxml.FXML
    public void selectField(Event event) {//PERMITE SELECCIONAR ITEMS DE LA TABLA Y DEVUELVE LOS VALORES
        newTable newTables = this.fieldTables.getSelectionModel().getSelectedItem();
        if (newTables != null) {//SI EL VALOR SELECCIONADO ES DIFERENTE DE NULL TE CARGA LOS DATOS
            this.nameCampoNewTable.setText(newTables.getName());
            this.typesComboBox.setValue(newTables.getType());
            this.nullCheckBox.setSelected("NULL".equals(newTables.isNullable()));
        }
    }

    public String isNullable() {//no eliminar pls
        return this.nullable ? "NULL" : "NOT NULL";
    }

    public void setTablaFields() {//DAR EL FORMATO ALA TABLA CREACION DE TABLAS
        //DAMOS FORMATO ALAS CELDAS DE LA TABLA INTERFAZ CREACION NEW TABLE
        nameColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getName()));
        typeColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getType()));
        nullColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().isNullable()));
        extraColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getExtra()));
        defaultColumb.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getDefault()));
    }

    @javafx.fxml.FXML
    public void doCreateField(ActionEvent actionEvent) {//CREA EL CAMPO EN LA TAMBLA
        try {
            String Default = "";
            String name = nameCampoNewTable.getText();
            String selected = nullCheckBox.isSelected() ? "NULL" : "NOT NULL";
            String type = typesComboBox.getValue();
            String extra = extraValueComboBox.getValue() != null ? extraValueComboBox.getValue() : "";
            String defaultValue = defaultValueTextField.getText();

            if (!defaultValue.isEmpty()) {
                Default = "DEFAULT " + defaultValue;
            }
            newTable tableData = new newTable(name, type, selected, extra, Default);
            newTables.add(tableData);
            fieldTables.setItems(newTables);
            fieldTables.refresh();

            nameCampoNewTable.setText("");
            nullCheckBox.setSelected(false);
            typesComboBox.setValue("");
            extraValueComboBox.setValue("");
            defaultValueTextField.setText("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void doDeleteField(ActionEvent actionEvent) {//  ELIMINA EL CAMPO TABLA CREAR TABLAS
        newTable newTables = this.fieldTables.getSelectionModel().getSelectedItem();
        this.newTables.remove(newTables);
        this.fieldTables.refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText("CAMPO ELIMINADO");
        alert.showAndWait();

        nameCampoNewTable.setText("");
        nullCheckBox.setSelected(false);
        typesComboBox.setValue(String.valueOf(0));
        extraValueComboBox.setValue(String.valueOf(0));
        defaultValueTextField.setText("");
    }

    @javafx.fxml.FXML
    public void doModifyField(ActionEvent actionEvent) {//MODIFICA EL CAMPO
        newTable newTables = this.fieldTables.getSelectionModel().getSelectedItem();
        try {
            String newName = this.nameCampoNewTable.getText();
            String type = this.typesComboBox.getValue();
            String selected = nullCheckBox.isSelected() ? "NULL" : "NOT NULL";
            String extra = this.extraValueComboBox.getValue();
            String defaultValue = this.defaultValueTextField.getText();

            newTable overwriteField = new newTable(newName, type, selected, extra, defaultValue);
            if (!this.newTables.contains(overwriteField)) {
                newTables.setName(overwriteField.getName());
                newTables.setType(overwriteField.getType());
                newTables.setNullable(overwriteField.isNullable());
                newTables.setExtra(overwriteField.getExtra());

                this.fieldTables.refresh();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Info");
                alert.setContentText("CAMPO MODIFICADO");
                alert.showAndWait();
            }

            nameCampoNewTable.setText("");
            nullCheckBox.setSelected(false);
            typesComboBox.setValue(String.valueOf(""));
            extraValueComboBox.setValue(String.valueOf(""));
            defaultValueTextField.setText("");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @javafx.fxml.FXML
    public void doCreateTables(ActionEvent actionEvent) {
        int size = newTables.size();
        String query = "";//STRING QUE SERA LOS ELEMENTOS PARA CONSULTA
        for (int i = 0; i < newTables.size(); i++) {//CICLO PARA RECORRER TODOS LOS ELEMENTOS DE LA TABLA CREAR TABLA
            newTable table = newTables.get(i);
            System.out.print(table);
            String selected = nullCheckBox.isSelected() ? "NULL" : "NOT NULL";

            query = query.concat(String.valueOf(newTables.get(i)));//CONCATENAR DATOS
            if (i < newTables.size() - 1) {
                query = query.concat(", ");
                System.out.print(", ");
            } else { //PONE ; EN EL ULTIMO ELEMENTO CUANDO EL I ES DEL MISMO VALOR QUE EL .SIZE
                query = query.concat("");
                System.out.print(";");
            }
        }
        System.out.println("");
        System.out.println(nameTableTextField.getText() + " " + query);
        String dataBase = dataBaseSelected.getText();

        try {
            String urlToCreate = url + dataBase;//USE ___BASE DE DATOS___
            System.out.println(urlToCreate);
            System.out.println();
            Connection connection = DriverManager.getConnection(urlToCreate, userLogged.getUser(), userLogged.getPassword());
            pst = connection.prepareStatement("CREATE TABLE " + nameTableTextField.getText() + "(  " + query + " )");
            System.out.println("CREATE TABLE " + nameTableTextField.getText() + "(  " + query + " )");
            pst.executeUpdate();//GENERA LA CONSULTA DE CREACION DE LA TABLA


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("SE HA CREADO LA TABLA " + nameTableTextField.getText() + " EN " + dataBase);
            alert.showAndWait();

            nameCampoNewTable.setText("");
            nullCheckBox.setSelected(false);
            typesComboBox.setValue(String.valueOf(""));
            extraValueComboBox.setValue(String.valueOf(""));
            defaultValueTextField.setText("");
            nameTableTextField.setText("");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillComboBoxes() { //LLENA COMBO BOX ESTATICO
        typesComboBox.getItems().addAll(
                "Int",
                "Float",
                "VarChar(100)",
                "Boolean",
                "Time",
                "Date",
                "DateTime"
        );

        extraValueComboBox.getItems().addAll(
                "AUTO_INCREMENT",
                "ON UPDATE",
                "CURRENT_TIMESTAMP",
                "UNSIGNED"
        );

        operadoresComboBox.getItems().addAll(
                ">",
                "<",
                ">=",
                "=",
                "<= ",
                "LIKE",
                "NOT LIKE",
                "IS NULL",
                "IS NOT NULL"
        );

        operadoresAndCB.getItems().addAll(
                ">",
                "<",
                ">=",
                "=",
                "<= ",
                "LIKE",
                "NOT LIKE",
                "IS NULL",
                "IS NOT NULL"
        );

        seleccionColumnas.getItems().addAll(
                "Elegir columna",
                "Todas las Columnas"
        );

    }

    @javafx.fxml.FXML
    public void selectTable(Event event) throws SQLException {
        showTablesData.getColumns().clear(); //ELIMINAMOS COLUMNAS E ITEMS
        showTablesData.getItems().clear();
        //BUSCA BASE DE DATOS
        Database doSelected = this.dataBases_tableView.getSelectionModel().getSelectedItem();
        String searchDatabase = doSelected.getDatabase().getValue();
        String urlToSearch = url + searchDatabase;

        //BUSCAMOS LA TABLA
        Table doTableSelected = this.showTables_TableView.getSelectionModel().getSelectedItem();
        String searchTableData = doTableSelected.getTable().getValue();

        //PREPARAMOS LA CONEXIÓN
        Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("Select * FROM " + searchTableData);

        ResultSetMetaData dataTable = rs.getMetaData();//OBTENER UN OBJETO CON LAS COLUMNAS QUE TIENE LA CONSULTA
        int numeroColumnasDinamicas = dataTable.getColumnCount();//CUENTA LAS COLUMNAS Y LAS AGREGUA AL ENTERO

        for (int i = 1; i <= numeroColumnasDinamicas; i++) {//CREAR LAS COLUMNAS

            final int j = i;//VARIABLE FINAL EXIGIDA PARA LAMBDA
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(dataTable.getColumnName(i));
            column.setCellValueFactory(cellData -> {
                ObservableList<String> valorCelda = cellData.getValue();//EL GETVALUE TRAE EL NOMBRE DE LA COLUMNA
                if (valorCelda != null && valorCelda.size() >= j) {
                    return new SimpleStringProperty(valorCelda.get(j - 1));
                } else {
                    return new SimpleStringProperty("");
                }
            });
            showTablesData.getColumns().add(column);
        }

        ObservableList<ObservableList<String>> datosTable = FXCollections.observableArrayList();
        while (rs.next()) {//TRAE ELEMENTOS HASTA SER NULL
            ObservableList<String> data = FXCollections.observableArrayList();
            for (int i = 1; i <= numeroColumnasDinamicas; i++) {//LLENA HASTA QUE I SEA IGUAL AL NUMERO DE COLUMNAS
                data.add(rs.getString(i));
            }
            datosTable.add(data);
            //System.out.println(" ");
            showTablesData.getItems().add(data);//OBTENEMOS DATOS
        }
        showTablesData.setItems(datosTable);//PONEMOS DATOS
    }

    @javafx.fxml.FXML
    public void doChooseType(ActionEvent actionEvent) {
        if (typesComboBox.getValue().equals("Int")) {
            int defaultValue = 0;
            defaultValueTextField.setText(String.valueOf(defaultValue));
        } else {
            String defaultValue = "";
            defaultValueTextField.setText(defaultValue);
        }

    }

    @javafx.fxml.FXML
    public void onDeleteTable(ActionEvent actionEvent) {//ELIMINA LAS TABLAS

        Database doSelected = this.dataBases_tableView.getSelectionModel().getSelectedItem();
        String searchDatabase = doSelected.getDatabase().getValue();
        String urlToSearch = url + searchDatabase;

        Table doTableSelected = this.showTables_TableView.getSelectionModel().getSelectedItem();
        String searchTableData = doTableSelected.getTable().getValue();

        try {
            Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
            pst = connection.prepareStatement("DROP TABLE " + searchTableData);//ELIMINAMOS LA TABLE
            pst.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ELIMINACION");
            alert.setContentText("TABLA " + searchDatabase + " FUE ELIMINADA");
            alert.showAndWait();
            showTables_TableView.refresh();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void onQueryButton(ActionEvent actionEvent) throws SQLException {//LLEVA ALA INTERFAZ DE CONSULTAS
        querysPane.setVisible(true);
    }

    @javafx.fxml.FXML
    public void showTableSelected(Event event) throws SQLException {
        try {
            tableViewQuerys.getColumns().clear();
            tableViewQuerys.getItems().clear();

            String doSelected = dbFilterCB.getValue();//TOMAMOS EL ELEMENTO SELECCIONADO EN EL COMBOBOX
            String urlToSearch = url + doSelected;
            baseDatosLabel.setText(doSelected);
            String tableCBselected = this.tableSelectedComboBox.getValue();//TOMAMOS EL ELEMENTO SELECCIONADO EN EL COMBOBOX

            System.out.println("Tabla Seleccionada  " + tableCBselected);

            tableSelectedLabel.setText(tableCBselected);

            Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM " + tableCBselected);

            ResultSetMetaData dataTable = rs.getMetaData();
            int numeroColumnasDinamicas = dataTable.getColumnCount();

            for (int i = 1; i <= numeroColumnasDinamicas; i++) {

                final int j = i;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(dataTable.getColumnName(i));
                column.setCellValueFactory(cellData -> {
                    ObservableList<String> valorCelda = cellData.getValue();
                    if (valorCelda != null && valorCelda.size() >= j) {
                        return new SimpleStringProperty(valorCelda.get(j - 1));
                    } else {
                        return new SimpleStringProperty("");
                    }
                });
                tableViewQuerys.getColumns().add(column);

            }

            ObservableList<String> columnNames = FXCollections.observableArrayList();

            for (int i = 1; i <= numeroColumnasDinamicas; i++) {//CICLO PARA OBTENER EL NOMBRE DE LAS COLUMNAS
                String columnName = dataTable.getColumnName(i);
                columnNames.add(columnName);
            }

            columnasComboBox.setItems(columnNames);//LLENA EL COMBOBOX DINAMICO DE COLUMNAS
            modifyCellDataCB.setItems(columnNames);//LLENA EL COMBOBOX DINAMICO DE COLUMNAS
            //_____________________________________________________

            ObservableList<ObservableList<String>> datosTable = FXCollections.observableArrayList();
            while (rs.next()) {
                ObservableList<String> data = FXCollections.observableArrayList();
                for (int i = 1; i <= numeroColumnasDinamicas; i++) {
                    data.add(rs.getString(i));
                    //System.out.print(rs.getString(i) + " | ");
                }
                datosTable.add(data);
                //System.out.println(" ");
                tableViewQuerys.getItems().add(data);
            }
            tableViewQuerys.setItems(datosTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void createViewQuery(ActionEvent actionEvent) throws  SQLException {//CREAMOS LA VISTA
        String viewQuery;
        try{
            tableViewQuerys.getColumns().clear();
            tableViewQuerys.getItems().clear();

            String doSelected = dbFilterCB.getValue();
            String urlToSearch = url + doSelected;

            String nameOfViews =nameOfView.getText();
            String queryForView = textFieldQuery.getText();//OBTENEMOS LA CONSULTA GENERADA

                viewQuery = "CREATE VIEW " + nameOfViews + " AS " + queryForView ;
                System.out.println(viewQuery);
                Connection connection = DriverManager.getConnection(urlToSearch,userLogged.getUser(), userLogged.getPassword());
                pst = connection.prepareStatement(viewQuery+" ;");
                System.out.println(updateQuery);
                pst.executeUpdate();//EJECUTAMOS LA CREACION DE LA VISTA

            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("VISTA CREADA");
            confirmationAlert.setHeaderText("La vista fue creada.");
            confirmationAlert.setContentText("Puede revisarla en la ventana principal.");
            confirmationAlert.showAndWait();

        }catch (SQLException e){
            Alert confirmationAlert = new Alert(Alert.AlertType.ERROR);
            confirmationAlert.setTitle("ERROR");
            confirmationAlert.setHeaderText("INGRESE UNA CONSULTA VALIDA.");
            confirmationAlert.setContentText("No se pudó crear la vista con la consulta.");
            confirmationAlert.showAndWait();
            e.printStackTrace();
        }



    }


    @javafx.fxml.FXML
    public void backMain(ActionEvent actionEvent) {//VOLVER ALA VENTANA PRINCIPAL
        textFieldQuery.setText("");
        mainMenuPane.setVisible(true);
        createTables_interface.setVisible(false);
        querysPane.setVisible(false);

    }

    @javafx.fxml.FXML
    public void selectedComboBoxColumn(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void updateQuery(ActionEvent actionEvent) throws SQLException {//CONSULTAS
        String allValues;
        String querys = "";

        if (!andCheckBox.isSelected()) {
            String table = tableSelectedComboBox.getValue();
            String column = columnasComboBox.getValue();
            String operadores = operadoresComboBox.getValue();
            String valor = valorTextField.getText();

            if (seleccionColumnas.getValue().equals("Todas las Columnas")) {
                allValues = "*";
            } else {
                allValues = column;
            }

            if (operadoresComboBox.getValue() == null) {
                operadores = "";
            } else if (!operadoresComboBox.getValue().equals("")) {
                operadores = operadoresComboBox.getValue();
            }
            if (limitTextField.getText().equals("")) {
                querys = "SELECT " + allValues + " FROM " + table + " WHERE " + column + " " + operadores + " " + "\"" + valor + "\"";
            } else if (!limitTextField.getText().equals("")) {
                querys = "SELECT " + allValues + " FROM " + table + " WHERE " + column + " " + operadores + " " + "\"" + valor + "\"" + " limit " + limitTextField.getText();
            }

            textFieldQuery.setText(querys);
        } else if (andCheckBox.isSelected()) {
            String table = tableSelectedComboBox.getValue();
            String column = columnasComboBox.getValue();
            String column2 = columnasAndCB.getValue();
            String tableToCompare = tableSelectedComboBox1.getValue();

            String operadores2;
            String operadores = operadoresComboBox.getValue();

            String filterColumn = "";
            String valor = valorFieldAnd.getText();


            if (seleccionColumnas.getValue().equals("Todas las Columnas")) {
                allValues = "*";
                String tableCompare = tableSelectedComboBox1.getValue();
                if (operadoresAndCB.getValue() != null) {
                    if (!limitTextFieldAux.getText().equals("")) {
                        operadores2 = operadoresAndCB.getValue();
                        filterColumn = columnasAndCB2.getValue();
                        querys = "SELECT " + table + "." + allValues + ", " + tableCompare + "." + column2 + " FROM " + table + "," + tableCompare + " WHERE " + table + "." + column + operadores + tableCompare + "." + column2 + " AND " + tableCompare + "." + filterColumn + operadores2 + " " + "\"" + valor + "\"" + " limit " + limitTextFieldAux.getText();

                    } else if (limitTextFieldAux.getText().equals("")) {
                        operadores2 = operadoresAndCB.getValue();
                        filterColumn = columnasAndCB2.getValue();
                        querys = "SELECT " + table + "." + allValues + ", " + tableCompare + "." + column2 + " FROM " + table + "," + tableCompare + " WHERE " + table + "." + column + operadores + tableCompare + "." + column2 + " AND " + tableCompare + "." + filterColumn + operadores2 + " " + "\"" + valor + "\"";

                    }
                } else if (operadoresAndCB.getValue() == null) {

                    if (!limitTextFieldAux.getText().equals("")) {
                        operadores2 = operadoresAndCB.getValue();
                        filterColumn = columnasAndCB2.getValue();
                        querys = "SELECT " + table + "." + allValues + ", " + tableCompare + "." + column2 + " FROM " + table + "," + tableCompare + " WHERE " + table + "." + column + operadores + tableCompare + "." + column2 + " AND " + tableCompare + "." + filterColumn + operadores2 + " " + "\"" + valor + "\"" + " limit " + limitTextFieldAux.getText();
                    } else if (limitTextFieldAux.getText().equals("")) {
                        operadores2 = operadoresAndCB.getValue();
                        filterColumn = columnasAndCB2.getValue();
                        operadores2 = "";
                        querys = "SELECT " + table + "." + allValues + ", " + tableCompare + "." + column2 + " FROM " + table + "," + tableCompare + " WHERE " + table + "." + column + operadores + tableCompare + "." + column2;

                    }

                }
                textFieldQuery.setText(querys);
            } else {
                allValues = column;
                String tableCompare = tableSelectedComboBox1.getValue();
                if (!operadoresAndCB.getValue().equals(null)) {
                    operadores2 = operadoresAndCB.getValue();
                    filterColumn = columnasAndCB2.getValue();
                    querys = "SELECT " + table + "." + allValues + ", " + tableCompare + "." + column2 + " FROM " + table + "," + tableCompare + " WHERE " + column + operadores + column2 + " AND " + tableCompare + "." + filterColumn + operadores2 + " " + "\"" + valor + "\"";

                } else if (operadoresAndCB.getValue().equals(null)) {
                    operadores2 = "";
                    querys = "SELECT " + table + "." + allValues + ", " + tableCompare + "." + column2 + " FROM " + table + "," + tableCompare + " WHERE " + column + operadores2 + column2;

                }
                textFieldQuery.setText(querys);
            }

        }
    }

    @javafx.fxml.FXML
    public void andCheckBox(ActionEvent actionEvent) {//CARGA COMPARACION ENTRE DOS TABLAS Y FILTROS ADICIONALES
        if (andCheckBox.isSelected()) {
            columnasAndCB.setVisible(true);
            tableSelectedComboBox1.setVisible(true);
            paneConsultasAdicional.setVisible(true);
            labelTitleCBA.setVisible(true);


            valorTextField.setText("");
            limitTextField.setText("");

        } else if (!andCheckBox.isSelected()) {
            columnasAndCB.setVisible(false);
            tableSelectedComboBox1.setVisible(false);
            paneConsultasAdicional.setVisible(false);
            labelTitleCBA.setVisible(false);
            valorTextField.setText("");
            limitTextField.setText("");

        }
    }

    @javafx.fxml.FXML
    public void executeQuery(ActionEvent actionEvent) throws SQLException {//TOMA EL VALOR DE LA CONSULTA Y LO EJECUTA
        String query = textFieldQuery.getText();//OBTENEMOS LA CONSULTA

        tableViewQuerys.getColumns().clear();
        tableViewQuerys.getItems().clear();

        String doSelected = dbFilterCB.getValue();

        String urlToSearch = url + doSelected;

        baseDatosLabel.setText(doSelected);
        String tableCBselected = this.tableSelectedComboBox.getValue();

        System.out.println("Tabla Seleccionada  " + tableCBselected);

        tableSelectedLabel.setText(tableCBselected);

        Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query + " ;");


        ResultSetMetaData dataTable = rs.getMetaData();
        int numeroColumnasDinamicas = dataTable.getColumnCount();

        for (int i = 1; i <= numeroColumnasDinamicas; i++) {

            final int j = i;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(dataTable.getColumnName(i));
            column.setCellValueFactory(cellData -> {
                ObservableList<String> valorCelda = cellData.getValue();
                if (valorCelda != null && valorCelda.size() >= j) {
                    return new SimpleStringProperty(valorCelda.get(j - 1));
                } else {
                    return new SimpleStringProperty("");
                }
            });
            tableViewQuerys.getColumns().add(column);
        }

        ObservableList<ObservableList<String>> datosTable = FXCollections.observableArrayList();
        while (rs.next()) {
            ObservableList<String> data = FXCollections.observableArrayList();
            for (int i = 1; i <= numeroColumnasDinamicas; i++) {
                data.add(rs.getString(i));
                System.out.print(rs.getString(i) + " | ");
            }
            datosTable.add(data);
            //System.out.println(" ");
            tableViewQuerys.getItems().add(data);
        }
        tableViewQuerys.setItems(datosTable);

    }

    @javafx.fxml.FXML
    public void seleccionColumnasCB(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void operadoresAndCB(ActionEvent actionEvent) {
    }

    @Deprecated
    public void operadoresAndCBPlus(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void showTableSelected2(ActionEvent actionEvent) {
        try {
            tableViewQuerys.getColumns().clear();
            tableViewQuerys.getItems().clear();

            String doSelected = dbFilterCB.getValue();

            String urlToSearch = url + doSelected;

            baseDatosLabel.setText(doSelected);
            String tableCBselected = this.tableSelectedComboBox1.getValue();

            System.out.println("Tabla Seleccionada  " + tableCBselected);

            tableSelectedLabel.setText(tableCBselected);

            Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("Select * FROM " + tableCBselected);

            ResultSetMetaData dataTable = rs.getMetaData();
            int numeroColumnasDinamicas = dataTable.getColumnCount();

            for (int i = 1; i <= numeroColumnasDinamicas; i++) {

                final int j = i;
                TableColumn<ObservableList<String>, String> column = new TableColumn<>(dataTable.getColumnName(i));
                column.setCellValueFactory(cellData -> {
                    ObservableList<String> valorCelda = cellData.getValue();
                    if (valorCelda != null && valorCelda.size() >= j) {
                        return new SimpleStringProperty(valorCelda.get(j - 1));
                    } else {
                        return new SimpleStringProperty("");
                    }
                });
                tableViewQuerys.getColumns().add(column);

            }

            ObservableList<String> columnNames = FXCollections.observableArrayList();

            for (int i = 1; i <= numeroColumnasDinamicas; i++) {
                String columnName = dataTable.getColumnName(i);
                columnNames.add(columnName);
            }

            columnasAndCB.setItems(columnNames);//COMBOBOX DINAMICOS AGAIN
            columnasAndCB2.setItems(columnNames);

            ObservableList<ObservableList<String>> datosTable = FXCollections.observableArrayList();
            while (rs.next()) {
                ObservableList<String> data = FXCollections.observableArrayList();
                for (int i = 1; i <= numeroColumnasDinamicas; i++) {
                    data.add(rs.getString(i));
                    //System.out.print(rs.getString(i) + " | ");
                }
                datosTable.add(data);
                //System.out.println(" ");
                tableViewQuerys.getItems().add(data);
            }
            tableViewQuerys.setItems(datosTable);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @javafx.fxml.FXML
    public void andCheckBoxAdicional(ActionEvent actionEvent) {//PONE LOS FILTROS ADICIONALES
        if (andCheckBox1.isSelected()) {
            columnasAndCB2.setVisible(true);
            operadoresAndCB.setVisible(true);
            valorFieldAnd.setVisible(true);
            limitTextFieldAux.setVisible(true);
        } else if (!andCheckBox1.isSelected()) {
            columnasAndCB2.setVisible(false);
            operadoresAndCB.setVisible(false);
            valorFieldAnd.setVisible(false);
            limitTextFieldAux.setVisible(false);
        }

    }

    @javafx.fxml.FXML
    public void dbFilterCB(ActionEvent actionEvent) {
        String doSelected = this.dbFilterCB.getValue();
        String urlToSearch = url + doSelected;

        dataBaseSelected.setText(doSelected);
        ObservableList<Table> tables = FXCollections.observableArrayList();
        this.showTables.setCellValueFactory(new PropertyValueFactory<>("Table"));

        try {
            Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SHOW TABLES");

            ObservableList<String> tableNames = FXCollections.observableArrayList();
            while (resultSet.next()) {
                Table st = new Table();
                st.setTable(resultSet.getString("Tables_in_" + doSelected));
                tables.add(st);
                tableNames.add(resultSet.getString("Tables_in_" + doSelected));
            }

            tableSelectedComboBox.setItems(tableNames);
            tableSelectedComboBox1.setItems(tableNames);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @javafx.fxml.FXML
    public void modifyQueryButton(ActionEvent actionEvent) {
        String updateQuery = "";

         try{
        String newCamp = modifyField.getText();
        String doSelected = this.dbFilterCB.getValue();
        String urlToSearch = url + doSelected;
        String table = tableSelectedComboBox.getValue();
        String column = modifyCellDataCB.getValue();
        String oldCamps = oldCamp.getText();
        String newOldCamp = oldCamps.replaceAll("\\[|\\]", "");
        String columnaUpdate = columnasComboBox.getValue();
        String FilterValue = valorTextField.getText();

        Connection connection = DriverManager.getConnection(urlToSearch,userLogged.getUser(), userLogged.getPassword());
        updateQuery = " UPDATE " + table + " SET " + column + " = " + "\"" + newCamp + "\"" + " WHERE " + columnaUpdate + "=" + FilterValue ;
        pst = connection.prepareStatement(updateQuery+";");
        System.out.println(updateQuery);//EJECUTA LA CONSULTA (ACTULIZACION)
        pst.executeUpdate();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("CREATE");
        alert.setContentText("REGISTRO MODIFICADO");
        alert.showAndWait();

        }catch (SQLException e){
            e.printStackTrace();
        }

         oldCamp.setText("");
         modifyField.setText("");
         modifyCellDataCB.setValue("");
         valorTextField.setText("");
    }

    @javafx.fxml.FXML
    public void selectedFilterQuery(Event event) {//QUITAR LOS
        String registerSelected = String.valueOf(tableViewQuerys.getSelectionModel().getSelectedItem());
        modifyField.setText(registerSelected.replaceAll("\\[|\\]", ""));
        oldCamp.setText(registerSelected.replaceAll("\\[|\\]", ""));
    }

    @javafx.fxml.FXML
    public void modifyCellDataCB(ActionEvent actionEvent) throws SQLException {
        String allValues;
        String querys;

        String table = tableSelectedComboBox.getValue();
        String column = modifyCellDataCB.getValue();
        String baseColumn = columnasComboBox.getValue();
        String operadores = operadoresComboBox.getValue();
        String valor = valorTextField.getText();

        if (operadoresComboBox.getValue() == null) {
            operadores = "";
        } else if (!operadoresComboBox.getValue().equals("")) {
            operadores = operadoresComboBox.getValue();
        }

        querys = "SELECT " + column + " FROM " + table + " WHERE " + baseColumn + " " + operadores + " " + "\"" + valor + "\"";

        String query = querys;

        tableViewQuerys.getColumns().clear();
        tableViewQuerys.getItems().clear();

        String doSelected = dbFilterCB.getValue();

        String urlToSearch = url + doSelected;

        baseDatosLabel.setText(doSelected);
        String tableCBselected = this.tableSelectedComboBox.getValue();

        System.out.println("Tabla Seleccionada  " + tableCBselected);

        tableSelectedLabel.setText(tableCBselected);

        Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query + " ;");


        ResultSetMetaData dataTable = rs.getMetaData();
        int numeroColumnasDinamicas = dataTable.getColumnCount();
        for (int i = 1; i <= numeroColumnasDinamicas; i++) {

            final int j = i;
            TableColumn<ObservableList<String>, String> newColumn = new TableColumn<>(dataTable.getColumnName(i));
            newColumn.setCellValueFactory(cellData -> {
                ObservableList<String> valorCelda = cellData.getValue();
                if (valorCelda != null && valorCelda.size() >= j) {
                    return new SimpleStringProperty(valorCelda.get(j - 1));
                } else {
                    return new SimpleStringProperty("");
                }
            });
            tableViewQuerys.getColumns().add(newColumn);

        }

        ObservableList<ObservableList<String>> datosTable = FXCollections.observableArrayList();
        while (rs.next()) {
            ObservableList<String> data = FXCollections.observableArrayList();
            for (int i = 1; i <= numeroColumnasDinamicas; i++) {
                data.add(rs.getString(i));
                System.out.print(rs.getString(i) + " | ");
            }
            datosTable.add(data);
            //System.out.println(" ");
            tableViewQuerys.getItems().add(data);
        }
        tableViewQuerys.setItems(datosTable);
    }

    @javafx.fxml.FXML
    public void deletePrueba(ActionEvent actionEvent) throws SQLException {
        String deleteQuery;

        try{
            tableViewQuerys.getColumns().clear();
            tableViewQuerys.getItems().clear();

            String doSelected = dbFilterCB.getValue();
            String urlToSearch = url + doSelected;

            String table =  tableSelectedComboBox.getValue();
            String columnToFind = columnasComboBox.getValue();
            String valueToFind = valorTextField.getText();

            deleteQuery = "DELETE FROM "+ table + " WHERE " + columnToFind+" = "+valueToFind ;
            System.out.println(deleteQuery);

            Connection connection = DriverManager.getConnection(urlToSearch,userLogged.getUser(), userLogged.getPassword());
            pst = connection.prepareStatement(deleteQuery+" ;");
            System.out.println(updateQuery);
            pst.executeUpdate();

            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirmar eliminación");
            confirmationAlert.setHeaderText("¿Estás seguro de que deseas eliminar este registro?");
            confirmationAlert.setContentText("Esta acción no se puede deshacer.");

            confirmationAlert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    Alert deletionAlert = new Alert(Alert.AlertType.INFORMATION);
                    deletionAlert.setTitle("Registro eliminado");
                    deletionAlert.setHeaderText(null);
                    deletionAlert.setContentText("El registro ha sido eliminado exitosamente.");
                    deletionAlert.showAndWait();
                }
            });


        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @javafx.fxml.FXML
    public void onDoDescribeTable(ActionEvent actionEvent) throws SQLException {

        showTablesData.getColumns().clear();
        showTablesData.getItems().clear();

        Database doSelected = this.dataBases_tableView.getSelectionModel().getSelectedItem();
        String searchDatabase = doSelected.getDatabase().getValue();
        String urlToSearch = url + searchDatabase;


        Table doTableSelected = this.showTables_TableView.getSelectionModel().getSelectedItem();
        String searchTableData = doTableSelected.getTable().getValue();

        Connection connection = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword());
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("DESCRIBE " + searchTableData);

        ResultSetMetaData dataTable = rs.getMetaData();
        int numeroColumnasDinamicas = dataTable.getColumnCount();

        for (int i = 1; i <= numeroColumnasDinamicas; i++) {

            final int j = i;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(dataTable.getColumnName(i));
            column.setCellValueFactory(cellData -> {
                ObservableList<String> valorCelda = cellData.getValue();
                if (valorCelda != null && valorCelda.size() >= j) {
                    return new SimpleStringProperty(valorCelda.get(j - 1));
                } else {
                    return new SimpleStringProperty("");
                }
            });
            showTablesData.getColumns().add(column);
        }

        ObservableList<ObservableList<String>> datosTable = FXCollections.observableArrayList();
        while (rs.next()) {
            ObservableList<String> data = FXCollections.observableArrayList();
            for (int i = 1; i <= numeroColumnasDinamicas; i++) {
                data.add(rs.getString(i));
                //System.out.print(rs.getString(i) + " | ");
            }
            datosTable.add(data);
            //System.out.println(" ");
            showTablesData.getItems().add(data);
        }
        showTablesData.setItems(datosTable);
    }


    public void addNewRegister(){
        String doSelected = dbFilterCB.getValue();
        String urlToSearch = url + doSelected;

        //Table doTableSelected = this.showTables_TableView.getSelectionModel().getSelectedItem();
        //String searchTableData = this.tableSelectedComboBox.getValue();
        //String tableCBselected = this.tableSelectedComboBox.getValue();
        String tableCBselected = this.tableSelectedLabel.getText();

        try (
            Connection conn = DriverManager.getConnection(urlToSearch, userLogged.getUser(), userLogged.getPassword())) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableCBselected);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();//NUMERO DE COLUMNAS
            String[] columnNames = new String[columnCount];//CREAMOS UN ARRAY ESTATICO DE LA CANTIDAD DE COLUMNAS QUE HAY PARA INGRESAR DATOS
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {//AGREGAMOS EL NOMBRE DE LA COLUMNA AL ESPACIO EN EL ARRAY
                columnNames[columnIndex - 1] = metaData.getColumnName(columnIndex);
            }

            String[] recordValues = new String[columnCount];
            for (int i = 0; i < columnCount; i++) {//PEDIMOS LLENAR LOS DATOS CON LAS COLUMNAS ALMACENADAS EN EL ARRAY
                String value = JOptionPane.showInputDialog(null, "Ingrese el valor para la columna '" + columnNames[i] + "':", "Ingresar registro", JOptionPane.PLAIN_MESSAGE);
                if (value == null) {
                    return;  // Si el usuario cancela la operación, no se agrega el registro
                }
                recordValues[i] = value;
            }

            StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");//CREAMOS UN STRING MUTABLE PARA IR AGREGANDO DATOS
            queryBuilder.append(tableCBselected);//DEFINE TABLA PARA AGREGAR METODOS
            queryBuilder.append(" (");//CONTANTENA PARENTESIS AL STRING ANTERIOR PARA AGREGAR LA INFORMACION
            for (int i = 0; i < columnCount; i++) { //NOMBRE DEL DATO
                queryBuilder.append(columnNames[i]);
                if (i < columnCount - 1) {
                    queryBuilder.append(", ");
                }
            }
            queryBuilder.append(") VALUES ("); // VALOR
            for (int i = 0; i < columnCount; i++) {
                queryBuilder.append("'");
                queryBuilder.append(recordValues[i]);
                queryBuilder.append("'");
                if (i < columnCount - 1) {
                    queryBuilder.append(", ");
                }
            }
            queryBuilder.append(")");

            stmt.executeUpdate(queryBuilder.toString());

            //showTablesData(); // Actualizar la vista del TableView después de agregar el registro

            JOptionPane.showMessageDialog(null, "Registro agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al agregar el registro.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @javafx.fxml.FXML
    public void doNewRegister(ActionEvent actionEvent) {
        addNewRegister();
    }
}