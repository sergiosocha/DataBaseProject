package com.example.databaseproject;
import java.sql.*;


public class DataBaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String username= "root";
        String password= "12345";

        try {
            Connection connection = DriverManager.getConnection(url,username, password);
            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");

            while ( resultSet.next()){
                System.out.println(resultSet.getString("DataBase"));

            }

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

}
