/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kdh.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pasandevin
 */
public class DataRetriever {
    
        Connection connection;

    public DataRetriever(Connection connection) {
        this.connection = connection;
    }
    
    public ResultSet retrieveDataFromItemsTable() {
        try {
            
            Statement statement1 = connection.createStatement();
            ResultSet results = statement1.executeQuery("SELECT * from items");
            return results;   
          
        } catch (Exception e) {
            System.out.println("Error Connecting with database: " + e.getMessage());
        }
        return null;
    } 
    
    public ResultSet retrieveDataFromUsersTable() {
        try {
            
            Statement statement1 = connection.createStatement();
            ResultSet results = statement1.executeQuery("SELECT * from users INNER JOIN address ON users.email = address.usermail");
            return results;   
          
        } catch (Exception e) {
            System.out.println("Error Connecting with database: " + e.getMessage());
        }
        return null;
    } 
    
    public ResultSet retrieveDataFromAdminsTable() {
        try {
            
            Statement statement1 = connection.createStatement();
            ResultSet results = statement1.executeQuery("SELECT * from admins");
            return results;   
          
        } catch (Exception e) {
            System.out.println("Error Connecting with database: " + e.getMessage());
        }
        return null;
    }
}
