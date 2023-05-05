package com.example.databaseproject.modelo;

public class UserModel {
    String user;
    String password;

    public UserModel() {
        this.user = "";
        this.password = "";

    }

    public UserModel(String user, String password){
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
