/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author eddy
 */
public class AccesBDD {
    private static Connection connection;
//    Statement statement;
//    ResultSet result;
    
    public AccesBDD(){
    }
    
//------------------------------------------------------------------------------
    public static Connection connectionBDD(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cdn?" + "user=application&password=application");
        }
        catch(Exception e){
            System.out.println("Connection Impossible");
        }
        return connection;
    }
}
