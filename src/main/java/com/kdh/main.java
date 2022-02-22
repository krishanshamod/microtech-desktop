package com.kdh;
import com.kdh.UI.LoginUI;


public class main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    new LoginUI().setVisible(true);
            }
        });
    }

}
