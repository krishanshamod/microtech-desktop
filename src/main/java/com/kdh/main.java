package com.kdh;
import com.kdh.UI.Dashboard;
import com.kdh.UI.LoginUI;

import com.kdh.database.DataValidator;
import com.kdh.database.SQLDatabase;
import java.sql.Connection; 

public class main {
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
}
