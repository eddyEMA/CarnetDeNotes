/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eddy
 */
public class DAOmatiere extends DAO<Matiere>{
    public Matiere chercher(int id) {
        Matiere maMatiere = new Matiere();
        try {
            resultat = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Matiere WHERE idMatiere =" + id);
            if (resultat.first()){
                maMatiere = new Matiere(resultat.getString("libelleMatiere")); 
                maMatiere.setIdMatiere(resultat.getInt("idMatiere"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return maMatiere; 
    }
    public boolean creer(Matiere monObjet) {
        try {
            Statement statement = this.connection.createStatement();
           requeteSQL = "INSERT INTO cdn.Matiere (libelleMatiere) " + "VALUES('" + monObjet.getLibelleMatiere() + "')";
           statement.executeUpdate(requeteSQL, statement.RETURN_GENERATED_KEYS);
           resultat = statement.getGeneratedKeys();
           if (resultat.next()){
               monObjet.setIdMatiere(resultat.getInt(1));
           }
         } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean mettreAjour(Matiere monObjet){
        try {
            requeteSQL = "UPDATE cdn.Matiere SET libelleMatiere='" + monObjet.getLibelleMatiere() + "' WHERE idMatiere=" + monObjet.getIdMatiere();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean supprimer(Matiere monObjet){
        try {
           requeteSQL = "DELETE FROM `cdn`.`Matiere` WHERE `Matiere`.`idMatiere` = " + monObjet.getIdMatiere();
           this.connection.createStatement().execute(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        monObjet = null;
        return true; 
    }
}