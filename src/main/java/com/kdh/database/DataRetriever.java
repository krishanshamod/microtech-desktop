package com.kdh.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataRetriever {
    Connection connection;

    public DataRetriever(Connection connection) {
        this.connection = connection;
    }

    public void getData() {
        System.out.println("Retrieving data from the database...");
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM address");

            while (results.next()) {


                // Get the data from the current row using the column index - column data are in the VARCHAR format

                String data = results.getString(1);

                System.out.println("Fetching data by column index for row " + results.getRow() + " : " + data);


                // Get the data from the current row using the column name - column data are in the VARCHAR format

                data = results.getString("addr_line1");

                System.out.println("Fetching data by column name for row " + results.getRow() + " : " + data);


            }
        } catch (Exception e) {
            System.out.println("Error retrieving data from the database: " + e.getMessage());
        }
    }


}
