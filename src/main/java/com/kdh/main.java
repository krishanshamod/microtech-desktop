package com.kdh;
import com.kdh.UI.LoginUI;
import com.kdh.UI.Dashboard;
import com.kdh.UI.SignupUI;

import com.kdh.database.DataRetriever;
import com.kdh.database.SQLDatabase;
import java.sql.Connection; 

public class main {
    public static void main(String[] args) {
        SQLDatabase sqldatabase = new SQLDatabase("jdbc:mysql://localhost/microtech", "root", "");
        Connection connection = sqldatabase.getConnection();
        DataRetriever dataRetriever = new DataRetriever(connection);
        dataRetriever.getData();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
}
