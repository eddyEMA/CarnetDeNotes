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
public class DAOclasse extends DAO<Classe>{
        public Classe chercher(int id) {
        Classe maClasse = new Classe();
        try {
            resultat = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Classe WHERE idClasse =" + id);
            if (resultat.first()){
                maClasse = new Classe(resultat.getString("libelleClasse"), resultat.getInt("idProfesseurClasse")); 
                maClasse.setIdClasse(resultat.getInt("idClasse"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return maClasse; 
    }
    public boolean creer(Classe monObjet) {
        try {
           Statement statement = this.connection.createStatement();
           requeteSQL = "INSERT INTO cdn.Classe (libelleClasse, idProfesseurClasse) " + "VALUES('" + monObjet.getLibelleClasse() + "', '" + monObjet.getIdProfesseurClasse() + "')";
           statement.executeUpdate(requeteSQL, statement.RETURN_GENERATED_KEYS);
           resultat = statement.getGeneratedKeys();
           if (resultat.next()){
               monObjet.setIdClasse(resultat.getInt(1));
           }
         } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean mettreAjour(Classe monObjet){
        try {
            requeteSQL = "UPDATE cdn.Classe SET libelleClasse='" + monObjet.getLibelleClasse() + "', idProfesseurClasse='" + monObjet.getIdProfesseurClasse() + "' WHERE idClasse=" + monObjet.getIdClasse();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean supprimer(Classe monObjet){
        try {
           requeteSQL = "DELETE FROM `cdn`.`Classe` WHERE `Classe`.`idClasse` = " + monObjet.getIdClasse();
           this.connection.createStatement().execute(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        monObjet = null;
        return true; 
    }
}
