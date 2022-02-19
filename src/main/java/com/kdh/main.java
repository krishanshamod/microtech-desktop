package com.kdh;
import com.kdh.UI.Dashboard;
import com.kdh.UI.LoginUI;
import com.kdh.database.DataModifier;
import com.kdh.database.DataRetriever;

import com.kdh.database.DataValidator;
import com.kdh.database.SQLDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
        
        SQLDatabase sqldatabase = new SQLDatabase("jdbc:mysql://localhost:8889/microtech", "root", "root");
        Connection connection = sqldatabase.getConnection();
        DataModifier dataModifier = new DataModifier(connection);
        dataModifier.updateOrderStatus("3", "Pending");
        


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Dashboard().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
