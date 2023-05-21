package com.example.databaseproject.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class newTable {

    private String name;
    private String type;
    private String isNullable;
    private String extra;
    private String Default;

    public newTable(){
        this.name="";
        this.type="";
        this.isNullable = "";
        this.extra = "";
        this.Default = "";
    }

    public newTable(String name, String type, String isNullable, String extra, String Default) {
        this.name = name;
        this.type = type;
        this.isNullable = isNullable;
        this.extra = extra;
        this.Default = Default;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String isNullable() {
        return isNullable;
    }

    public String getExtra() {
        return extra;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNullable(String nullable) {
        isNullable = nullable;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getDefault() {
        return Default;
    }

    public void setDefault(String aDefault) {
        Default = aDefault;
    }

    @Override
    public String toString() {
        return this.name + " " +this.type + " " + this.isNullable + " " + this.Default +  " " + this.extra;
    }
}
