/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author eddy
 */
public class DAOpersonne extends DAO{
    public Personne chercher(int id) {
        Personne maPersonne = null;
        try {
            ResultSet resultat = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM cdn.personne WHERE idPersonne =" + id);
            if (resultat.first()){
                resultat.getInt("identifiantPersonne");
                if (resultat.getInt("idTypePersonne") == 1) {
                         maPersonne = new Professeur(resultat.getString("nomPersonne"), resultat.getString("prenomPersonne"));   
                        }
                else if (resultat.getInt("idTypePersonne") == 2) {
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return maPersonne; 
    }
    public Object creer(String nom, String prenom, int typePersonne) {
        Object obj = new Object();
        return obj;
    }
    public Object mettreAjour(int id){
        Object obj = new Object();
        return obj;
    }
    public Object supprimer(int id){
        Object obj = new Object();
        return obj; 
    }

  
}
