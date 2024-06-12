package com.example.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CommonDao { 

    public static ResultSet get(String qry){

        ResultSet rslt = null;

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/euc", "root", "90896262");
            Statement stm = conn.createStatement();
            rslt = stm.executeQuery(qry);

        } catch (Exception e) {
            System.out.println("Can't Connect as" + e.getMessage());
           
        }
     return rslt;
    }

}
