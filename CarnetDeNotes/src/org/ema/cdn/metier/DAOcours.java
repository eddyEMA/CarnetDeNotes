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
     public Cours chercher(int id) {
        Cours monCours = new Cours();
        try {
            resultat = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Cours WHERE idCours =" + id);
            if (resultat.first()){
                monCours = new Cours(resultat.getString("jourCours"), resultat.getInt("heureDebutCours"), resultat.getInt("heureFinCours"), resultat.getInt("idMatiereCours"), resultat.getInt("idClasseCours"), resultat.getInt("idProfesseurCours")); 
                monCours.setIdCours(resultat.getInt("idCours"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return monCours; 
    }
    public boolean creer(Cours monObjet) {
        try {
            Statement statement = this.connection.createStatement();
           requeteSQL = "INSERT INTO cdn.Cours (jourCours, heureDebutCours, heureFinCours, idMatiereCours, idClasseCours, idProfesseurCours) " + "VALUES('" + monObjet.getJourCours()+ "', '" + monObjet.getHeureDebutCours() + "', '" + monObjet.getHeureFinCours() + "', '" + monObjet.getIdMatiereCours() + "', '" + monObjet.getIdClasseCours() + "', '" + monObjet.getIdProfesseurCours() + "')";
           statement.executeUpdate(requeteSQL, statement.RETURN_GENERATED_KEYS);
           resultat = statement.getGeneratedKeys();
           if (resultat.next()){
               monObjet.setIdCours(resultat.getInt(1));
           }
         } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean mettreAjour(Cours monObjet){
        try {
            requeteSQL = "UPDATE cdn.Cours SET jourCours='" + monObjet.getJourCours()+ "', heureDebutCours='" + monObjet.getHeureDebutCours() + "', heureFinCours='" + monObjet.getHeureFinCours() + "', idMatiereCours='" + monObjet.getIdMatiereCours() + "', idClasseCours='" + monObjet.getIdClasseCours() + "', idProfesseurCours='" + monObjet.getIdProfesseurCours() +  "' WHERE idCours=" + monObjet.getIdCours();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean supprimer(Cours monObjet){
        try {
           requeteSQL = "DELETE FROM `cdn`.`Cours` WHERE `Cours`.`idCours` = " + monObjet.getIdCours();
           this.connection.createStatement().execute(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        monObjet = null;
        return true; 
    }
}
