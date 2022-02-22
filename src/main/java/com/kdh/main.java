package com.kdh;

import com.kdh.UI.LoginUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new LoginUI().setVisible(true);
            }
        });
    }

}
