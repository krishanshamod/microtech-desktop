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
public class DataModifier {
    
    Connection connection;

    public DataModifier(Connection connection) {
        this.connection = connection;
    }
    
    //Add item to database
    public void addItem(String name, String cat, String brand, String price) {
        System.out.println("Accessing Database");

        try {
            
            Statement statement1 = connection.createStatement();
            ResultSet results = statement1.executeQuery("SELECT MAX(item_id) from items");
            
            int price_int = Integer.parseInt(price);
            int last_item_id = 0;
            int new_item_id;
            while (results.next()) {
                last_item_id = results.getInt("MAX(item_id)");
            }
            new_item_id = last_item_id + 1;
            
            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("INSERT INTO items(item_id, item_name, category, brand, item_price) VALUES ("+new_item_id+", '"+name+"','"+cat+"','"+brand+"',"+price_int+")");
            
        } catch (Exception e) {
            System.out.println("Error Connecting with database: " + e.getMessage());
        }
    }
    
    
    //Remove item from database
    public void deleteItem(String name) {
        System.out.println("Accessing Database");

        try {
            

            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("DELETE FROM items WHERE item_name = '" +name+"'");
            
        } catch (Exception e) {
            System.out.println("Error connecting with database: " + e.getMessage());
        }
    }
    
    
    //Update item in database
    public void updateItem(String name, String cat, String brand, String price) {
        System.out.println("Accessing Database");

        try {
            
            int price_int = Integer.parseInt(price);
            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("UPDATE items SET category = '"+cat+"', brand ='"+brand+"', item_price = '"+price+"' WHERE item_name = '"+name+"' ;");
            
        } catch (Exception e) {
            System.out.println("Error connecting with database: " + e.getMessage());
        }
    }


    
}
