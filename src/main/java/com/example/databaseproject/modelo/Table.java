package com.example.databaseproject.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Table {
    public StringProperty Table;


    public Table(){
        Table = new SimpleStringProperty(this, "name");
    }

    public StringProperty getTable() {
        return Table;
    }

    public void setTable(String table) {
        this.Table.set(table);
    }
}
