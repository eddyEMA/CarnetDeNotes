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
public class DAOepreuve extends DAO<Epreuve>{
    public Epreuve chercher(int id) {
        Epreuve monEpreuve = new Epreuve();
        try {
            resultat = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Epreuve WHERE idEpreuve =" + id);
            if (resultat.first()){
                monEpreuve = new Epreuve(resultat.getInt("idEleveEpreuve"),resultat.getInt("idMatiereEpreuve"), resultat.getInt("noteEpreuve"), resultat.getDate("dateEpreuve"),resultat.getInt("coefficientEpreuve")); 
                monEpreuve.setIdEpreuve(resultat.getInt("idEpreuve"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return monEpreuve; 
    }
    public boolean creer(Epreuve monObjet) {
        String patternDate = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(patternDate);
        try {
           Statement statement = this.connection.createStatement();
           requeteSQL = "INSERT INTO cdn.Epreuve (idEleveEpreuve, idMatiereEpreuve, noteEpreuve, dateEpreuve, coefficientEpreuve) " + "VALUES('" + monObjet.getIdEleveEpreuve() + "', '"+ monObjet.getIdMatiereEpreuve() + "', '" + monObjet.getNoteEpreuve() + "', '" + formatter.format(monObjet.getDateEpreuve()) +  "', '"+ monObjet.getCoefficientEpreuve() + "')";
           statement.executeUpdate(requeteSQL, statement.RETURN_GENERATED_KEYS);
           resultat = statement.getGeneratedKeys();
           if (resultat.next()){
               monObjet.setIdEpreuve(resultat.getInt(1));
           }
         } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean mettreAjour(Epreuve monObjet){
        String patternDate = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(patternDate);
        try {
            requeteSQL = "UPDATE cdn.Epreuve SET idEleveEpreuve='" + monObjet.getIdEleveEpreuve() + "', idMatiereEpreuve='" + monObjet.getIdMatiereEpreuve() + "', noteEpreuve='" + monObjet.getNoteEpreuve() + "', dateEpreuve='" + formatter.format(monObjet.getDateEpreuve()) + "', coefficientEpreuve='" + monObjet.getCoefficientEpreuve() + "' WHERE idEpreuve=" + monObjet.getIdEpreuve();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean supprimer(Epreuve monObjet){
        try {
           requeteSQL = "DELETE FROM `cdn`.`Epreuve` WHERE `Epreuve`.`idEpreuve` = " + monObjet.getIdEpreuve();
           this.connection.createStatement().execute(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        monObjet = null;
        return true; 
    }  
}
