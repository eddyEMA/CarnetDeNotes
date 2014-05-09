/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eddy
 */
public class AccesBDD {
    Connection connection;
    Statement statement;
    ResultSet result;
    
    public AccesBDD(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cdn?" + "user=eddy&password=eddy");
            this.statement = this.connection.createStatement();
            System.out.println("Ca marche");
        }
        catch(Exception e){
            System.out.println("Connection Impossible");
        }
    }
    void Requete() throws SQLException{
        this.result = this.statement.executeQuery("SELECT * FROM cdn.eleve");
    }
    void AfficheRequete() throws SQLException
    {
        this.Requete();
        while(this.result.next()){
            System.out.println("Nom : " + this.result.getString("nomEleve") + "  Prenom : " + this.result.getString("prenomEleve") + "  Date de naissance : " + this.result.getDate("dateDeNaissanceEleve"));
        }
    }
    int NombreLignes () throws SQLException{
        this.Requete();
        int nombreLigne = 0;  
        while (this.result.next()){  
            nombreLigne++;  
        }  
        return nombreLigne;
       
    }
}
