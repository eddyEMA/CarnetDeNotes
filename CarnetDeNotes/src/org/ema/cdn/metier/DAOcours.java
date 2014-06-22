/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eddy
 */
public class DAOcours extends DAO<Cours>{
     @Override
     public Cours chercher(int id) {
        Cours monCours = new Cours();
        try {
            this.setResultat(this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Cours WHERE idCours =" + id));
            if (this.getResultat().first()){
                monCours = new Cours(this.getResultat().getString("jourCours"), this.getResultat().getInt("heureDebutCours"), this.getResultat().getInt("heureFinCours"), this.getResultat().getInt("idMatiereCours"), this.getResultat().getInt("idClasseCours"), this.getResultat().getInt("idProfesseurCours")); 
                monCours.setIdCours(this.getResultat().getInt("idCours"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return monCours; 
    }
//------------------------------------------------------------------------------
     @Override
    public boolean creer(Cours monObjet) {
        Statement statement = null;
        String virgule = "', '";
        try {
           statement = this.getConnection().createStatement();
           this.setRequeteSQL("INSERT INTO cdn.Cours (jourCours, heureDebutCours, heureFinCours, idMatiereCours, idClasseCours, idProfesseurCours) " + "VALUES('" + monObjet.getJourCours()+ virgule + monObjet.getHeureDebutCours() + virgule + monObjet.getHeureFinCours() + virgule + monObjet.getIdMatiereCours() + virgule + monObjet.getIdClasseCours() + virgule + monObjet.getIdProfesseurCours() + "')");
           statement.executeUpdate(this.getRequeteSQL(), statement.RETURN_GENERATED_KEYS);
           this.setResultat(statement.getGeneratedKeys());
           if (this.getResultat().next()){
               monObjet.setIdCours(this.getResultat().getInt(1));
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
    public boolean mettreAjour(Cours monObjet){
        try {
            this.setRequeteSQL("UPDATE cdn.Cours SET jourCours='" + monObjet.getJourCours()+ "', heureDebutCours='" + monObjet.getHeureDebutCours() + "', heureFinCours='" + monObjet.getHeureFinCours() + "', idMatiereCours='" + monObjet.getIdMatiereCours() + "', idClasseCours='" + monObjet.getIdClasseCours() + "', idProfesseurCours='" + monObjet.getIdProfesseurCours() +  "' WHERE idCours=" + monObjet.getIdCours());
            this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
//------------------------------------------------------------------------------
     @Override
    public boolean supprimer(Cours monObjet){
        try {
           this.setRequeteSQL("DELETE FROM `cdn`.`Cours` WHERE `Cours`.`idCours` = " + monObjet.getIdCours());
           this.getConnection().createStatement().execute(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true; 
    }
}
