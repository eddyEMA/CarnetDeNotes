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
            this.setResultat(this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Epreuve WHERE idEpreuve =" + id));
            if (this.getResultat().first()){
                monEpreuve = new Epreuve(this.getResultat().getInt("idEleveEpreuve"), this.getResultat().getInt("idMatiereEpreuve"), this.getResultat().getInt("noteEpreuve"), this.getResultat().getDate("dateEpreuve"), this.getResultat().getInt("coefficientEpreuve")); 
                monEpreuve.setIdEpreuve(this.getResultat().getInt("idEpreuve"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return monEpreuve; 
    }
//------------------------------------------------------------------------------
    @Override
    public boolean creer(Epreuve monObjet) {
        String patternDate = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(patternDate);
        Statement statement = null;
        String virgule = "', '";
        try {
           statement = this.getConnection().createStatement();
           this.setRequeteSQL("INSERT INTO cdn.Epreuve (idEleveEpreuve, idMatiereEpreuve, noteEpreuve, dateEpreuve, coefficientEpreuve) " + "VALUES('" + monObjet.getIdEleveEpreuve() + virgule + monObjet.getIdMatiereEpreuve() + virgule + monObjet.getNoteEpreuve() + virgule + formatter.format(monObjet.getDateEpreuve()) +  virgule + monObjet.getCoefficientEpreuve() + "')");
           statement.executeUpdate(this.getRequeteSQL(), statement.RETURN_GENERATED_KEYS);
           this.setResultat(statement.getGeneratedKeys());
           if (this.getResultat().next()){
               monObjet.setIdEpreuve(this.getResultat().getInt(1));
           }
         } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                if(statement != null){
                    statement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
//------------------------------------------------------------------------------
    @Override
    public boolean mettreAjour(Epreuve monObjet){
        String patternDate = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(patternDate);
        try {
            this.setRequeteSQL("UPDATE cdn.Epreuve SET idEleveEpreuve='" + monObjet.getIdEleveEpreuve() + "', idMatiereEpreuve='" + monObjet.getIdMatiereEpreuve() + "', noteEpreuve='" + monObjet.getNoteEpreuve() + "', dateEpreuve='" + formatter.format(monObjet.getDateEpreuve()) + "', coefficientEpreuve='" + monObjet.getCoefficientEpreuve() + "' WHERE idEpreuve=" + monObjet.getIdEpreuve());
            this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
//------------------------------------------------------------------------------
    @Override
    public boolean supprimer(Epreuve monObjet){
        try {
           this.setRequeteSQL("DELETE FROM `cdn`.`Epreuve` WHERE `Epreuve`.`idEpreuve` = " + monObjet.getIdEpreuve());
           this.getConnection().createStatement().execute(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true; 
    }  
}
