/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kdh.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author pasandevin
 */
public class SQLDatabase {

    Connection connection;
    String url;
    String username;
    String password;


    public SQLDatabase(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
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
