package com.kdh.database;

import java.sql.Connection;
import java.sql.DriverManager;


public class SQLDatabase {

    Connection connection;
    String url;
    String username;
    String password;


    public SQLDatabase(String url, String username, String password) {
        this.username = username;
//        this.url = url;
//        this.password = password;
        this.url = "jdbc:mysql://localhost/microtech";
        this.password = "";
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return connection;
    }

}
