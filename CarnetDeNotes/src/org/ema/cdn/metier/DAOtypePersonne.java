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
public class DAOtypePersonne extends DAO<TypePersonne>{
        public TypePersonne chercher(int id) {
        TypePersonne monTypePersonne = new TypePersonne();
        try {
            resultat = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.TypePersonne WHERE idType =" + id);
            if (resultat.first()){
                monTypePersonne = new TypePersonne(resultat.getString("libelleType")); 
                monTypePersonne.setIdTypePersonne(resultat.getInt("idType"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return monTypePersonne; 
    }
    public boolean creer(TypePersonne monObjet) {
        try {
            Statement statement = this.connection.createStatement();
           requeteSQL = "INSERT INTO cdn.TypePersonne (libelleType) " + "VALUES('" + monObjet.getLibelleTypePersonne() + "')";
           statement.executeUpdate(requeteSQL, statement.RETURN_GENERATED_KEYS);
           resultat = statement.getGeneratedKeys();
           if (resultat.next()){
               monObjet.setIdTypePersonne(resultat.getInt(1));
           }
         } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean mettreAjour(TypePersonne monObjet){
        try {
            requeteSQL = "UPDATE cdn.TypePersonne SET libelleType='" + monObjet.getLibelleTypePersonne() + "' WHERE idType=" + monObjet.getIdTypePersonne();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean supprimer(TypePersonne monObjet){
        try {
           requeteSQL = "DELETE FROM `cdn`.`TypePersonne` WHERE `TypePersonne`.`idType` = " + monObjet.getIdTypePersonne();
           this.connection.createStatement().execute(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        monObjet = null;
        return true; 
    }
}
