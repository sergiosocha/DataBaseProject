package com.example.databaseproject.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class newTable {
    public StringProperty name;
    public StringProperty type;
    public StringProperty Null;
    public StringProperty extra;

    /*
    public String name,type,Null,extra;


    public newTable(){
        this.name = "";
        this.type = "";
        this.Null = "";
        this.extra = "";
    }

    public newTable(String name,String type,String Null, String extra){
        this.name = name;
        this.type = type;
        this.Null = Null;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNull() {
        return Null;
    }

    public void setNull(String aNull) {
        Null = aNull;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    */


    public newTable(){
        name = new SimpleStringProperty(this, "name");
        type = new SimpleStringProperty(this, "type");
        Null = new SimpleStringProperty(this, "Null");
        extra = new SimpleStringProperty(this, "extra");
    }

    public StringProperty getName() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty getType() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public StringProperty getNull() {
        return Null;
    }

    public void setNull(String Null) {
        this.Null.set(Null);
    }

    public StringProperty getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra.set(extra);
    }





}
