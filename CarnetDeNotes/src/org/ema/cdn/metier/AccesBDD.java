/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eddy
 */ 
public class AccesBDD {
    private static Connection connection;

//------------------------------------------------------------------------------
    public static final Connection connectionBDD(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost/cdn?" + "user=application&password=application");
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            //nothing to do
        }
        return connection;
    }
}
