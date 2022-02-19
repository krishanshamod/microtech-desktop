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
    
        public ResultSet retrieveOrderData() {
        try {
            
            Statement statement1 = connection.createStatement();
            ResultSet results = statement1.executeQuery("SELECT orders.order_id, items.item_name, orderdetails.no_of_items, users.f_name, users.l_name, address.addr_line1, address.addr_line2, address.city, address.country, users.phone_no, orders.status\n" +
                                                        "FROM orders\n" +
                                                        "INNER JOIN users ON orders.user_email = users.email\n" +
                                                        "INNER JOIN address ON orders.user_email = address.usermail\n" +
                                                        "INNER JOIN orderdetails ON orders.order_id = orderdetails.order_id\n" +
                                                        "INNER JOIN items ON orderdetails.item_id = items.item_id;");
            return results;   
          
        } catch (Exception e) {
            System.out.println("Error Connecting with database: " + e.getMessage());
        }
        return null;
    }
    
}


//        SQLDatabase sqldatabase = new SQLDatabase("jdbc:mysql://localhost:8889/microtech", "root", "root");
//        Connection connection = sqldatabase.getConnection();
//        DataRetriever dataRetriever = new DataRetriever(connection);
//        ResultSet results = dataRetriever.retrieveOrderData();
//        
//        while(results.next()) {
//            String name = results.getString("orders.order_id");
//            System.out.println(name);
//        }