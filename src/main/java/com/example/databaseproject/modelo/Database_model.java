package com.example.databaseproject.modelo;

public class Database_model {
    String name;

    public Database_model(){
        this.name = "";
    }

    public Database_model(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
