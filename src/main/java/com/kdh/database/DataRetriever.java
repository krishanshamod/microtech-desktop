package com.kdh.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataRetriever {
    Connection connection;

    public DataRetriever(Connection connection) {
        this.connection = connection;
    }

    public boolean validateLoginData(String uname, String pwd) {
        System.out.println("Retrieving data from the database...");
        boolean hasFoundAMatch = false;
        try {
            
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM users WHERE f_name = '" + uname +"' AND password ='" + pwd + "'");
            
            while (results.next()) {
                hasFoundAMatch = true;           
            }
            
        } catch (Exception e) {
            System.out.println("Error retrieving data from the database: " + e.getMessage());
        }
        return hasFoundAMatch;
    }


}
