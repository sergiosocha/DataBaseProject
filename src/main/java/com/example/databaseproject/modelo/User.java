package com.example.databaseproject.modelo;

public class User {
    /*public StringProperty user;
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
*/

    private String user;
    private String password;
    private String address;
    private String port;

    public User(){
    this.user = "";
    this.password="";
    this.address="";
    this.port="";
    }

    public User(String address, String port ,String user, String password){
    this.user = user;
    this.password = password;
    this.address = address;
    this.port = port;
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
