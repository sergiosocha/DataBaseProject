package com.example.databaseproject.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Database {
    public StringProperty Database;

    public Database(){
        Database = new SimpleStringProperty(this, "name");
    }

    public StringProperty getDatabase() {
        return Database;
    }

    public void setDatabase(String database) {
        this.Database.set(database);
    }
}
