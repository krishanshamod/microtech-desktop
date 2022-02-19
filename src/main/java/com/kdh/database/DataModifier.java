/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kdh.database;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.xml.bind.DatatypeConverter;

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
    
    //Remove user from database
    public void deleteUser(String email) {
        System.out.println("Accessing Database");

        try {

            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("DELETE FROM users WHERE email = '" +email+"'");
            updateStatement.executeUpdate("DELETE FROM address WHERE usermail = '" +email+"'");
            
        } catch (Exception e) {
            System.out.println("Error connecting with database: " + e.getMessage());
        }
    }
    
    //Add item to database
    public void addAdmin(String fname, String lname, String email, String pass) {
        System.out.println("Accessing Database");

        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pass.getBytes());
            byte[] digest = md.digest();
            String Hashedpwd = DatatypeConverter.printHexBinary(digest).toUpperCase();
            
            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("INSERT INTO admins(email, passwd, f_name, l_name) VALUES ('"+email+"', '"+Hashedpwd+"','"+fname+"','"+lname+"')");
            
        } catch (Exception e) {
            System.out.println("Error Connecting with database: " + e.getMessage());
        }
    }

    //Remove admin from database
    public void deleteAdmin(String email) {
        System.out.println("Accessing Database");

        try {

            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("DELETE FROM admins WHERE email = '" +email+"'");
            
        } catch (Exception e) {
            System.out.println("Error connecting with database: " + e.getMessage());
        }
    }
    
    //Update order status
    public void updateOrderStatus(String order_id, String status) {
        System.out.println("Accessing Database");

        try {

            Statement updateStatement = connection.createStatement();
            updateStatement.executeUpdate("UPDATE orders\n" +
                                          "SET orders.status = '" + status + "'\n" +
                                          "WHERE orders.order_id = '" + order_id + "'");
            
        } catch (Exception e) {
            System.out.println("Error connecting with database: " + e.getMessage());
        }
    }
}
