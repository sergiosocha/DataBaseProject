package com.example.databaseproject.modelo;

public class UserModel {
    private String user;
    private String password;

    public UserModel(String user) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
