package com.example.databaseproject.modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    public StringProperty user;
    public StringProperty password;



    public User(){
        user = new SimpleStringProperty(this, "name");
        password = new SimpleStringProperty(this, "pasword");

    }

    public StringProperty getUser() {
        return user;
    }

    public void setUser(String user) {
       this.user.set(user);
    }

    public StringProperty getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
