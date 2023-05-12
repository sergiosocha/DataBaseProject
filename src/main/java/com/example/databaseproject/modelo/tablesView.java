package com.example.databaseproject.modelo;

public class tablesView {
    private String Id;
    private String name;

    public tablesView(){
        this.Id = "";
        this.name = "";
    }

    public tablesView(String Id, String name){
        this.Id = Id;
        this.name = name;

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
