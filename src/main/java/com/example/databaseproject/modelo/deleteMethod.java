package com.example.databaseproject.modelo;

public class deleteMethod {
    private String Id;
    private String name;

    public deleteMethod(){
        this.Id = "";
        this.name = "";
    }

    public deleteMethod(String Id, String name){
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
