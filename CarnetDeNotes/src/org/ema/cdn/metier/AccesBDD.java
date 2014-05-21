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
//        try {
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/cdn?" + "user=application&password=application");
//            this.statement = this.connection.createStatement();
//            System.out.println("Ca marche");
//        }
//        catch(Exception e){
//            System.out.println("Connection Impossible");
//        }
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
        finally {
            return connection;
        }
    }
//------------------------------------------------------------------------------
//    public Vector requeteNom() throws SQLException{
//        this.result = this.statement.executeQuery("SELECT * FROM cdn.personne WHERE idTypePersonne = 2");
//        Vector nomPrenomEleve = new Vector ();
//       while(this.result.next()){
//        nomPrenomEleve.add(this.result.getString("nomPersonne"));
//       }
//        return nomPrenomEleve;
//    }
//    public Vector requetePrenom() throws SQLException{
//        this.result = this.statement.executeQuery("SELECT * FROM cdn.personne WHERE idTypePersonne = 2");
//        Vector nomPrenomEleve = new Vector ();
//       while(this.result.next()){
//        nomPrenomEleve.add(this.result.getString("prenomPersonne"));
//       }
//        return nomPrenomEleve;
//    }
//    public Vector requeteNoteEleve() throws SQLException{
//        this.result = this.statement.executeQuery("SELECT * FROM cdn.epreuve");
//        Vector nomPrenomEleve = new Vector ();
//       while(this.result.next()){
//        nomPrenomEleve.add(this.result.getInt("noteEpreuve"));
//       }
//        return nomPrenomEleve;
//    }
//    
////------------------------------------------------------------------------------
//    void AfficheRequete() throws SQLException
//    {
//        this.requeteNom();
//        while(this.result.next()){
//            System.out.println("Nom : " + this.result.getString("nomEleve") + "  Prenom : " + this.result.getString("prenomEleve") + "  Date de naissance : " + this.result.getDate("dateDeNaissanceEleve"));
//        }
//    }
//    
////------------------------------------------------------------------------------
//    int NombreLignes () throws SQLException{
//        this.requeteNom();
//        int nombreLigne = 0;  
//        while (this.result.next()){  
//            nombreLigne++;  
//        }  
//        return nombreLigne;
//       
//    }
}
