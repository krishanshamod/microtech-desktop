package com.kdh.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class DataValidator {
    Connection connection;

    public DataValidator(Connection connection) {
        this.connection = connection;
    }

    public boolean validateLoginData(String uname, String pwd) {
        System.out.println("Retrieving data from the database...");
        boolean hasFoundAMatch = false;

        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(pwd.getBytes());
            byte[] digest = md.digest();
            String Hashedpwd = DatatypeConverter.printHexBinary(digest).toUpperCase();
            System.out.println(Hashedpwd);
            
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM admins WHERE f_name = '" + uname +"' AND passwd ='" + Hashedpwd + "'");
            
            while (results.next()) {
                hasFoundAMatch = true;           
            }
            
        } catch (Exception e) {
            System.out.println("Error retrieving data from the database: " + e.getMessage());
        }
        return hasFoundAMatch;
    }


}
