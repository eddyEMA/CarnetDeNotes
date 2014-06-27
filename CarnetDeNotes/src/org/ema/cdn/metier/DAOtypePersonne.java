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
        @Override
        public TypePersonne chercher(Object id) {
        TypePersonne monTypePersonne = new TypePersonne();
        try {
            this.setResultat(this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.TypePersonne WHERE idType =" + id));
            if (this.getResultat().first()){
                monTypePersonne = new TypePersonne(this.getResultat().getString("libelleType")); 
                monTypePersonne.setIdTypePersonne(this.getResultat().getInt("idType"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return monTypePersonne; 
    }
//------------------------------------------------------------------------------
        @Override
    public boolean creer(TypePersonne monObjet) {
        Statement statement = null;
        try {
           statement = this.getConnection().createStatement();
           this.setRequeteSQL("INSERT INTO cdn.TypePersonne (libelleType) " + "VALUES('" + monObjet.getLibelleTypePersonne() + "')");
           statement.executeUpdate(this.getRequeteSQL(), statement.RETURN_GENERATED_KEYS);
           this.setResultat(statement.getGeneratedKeys());
           if (this.getResultat().next()){
               monObjet.setIdTypePersonne(this.getResultat().getInt(1));
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
    public boolean mettreAjour(TypePersonne monObjet){
        try {
            this.setRequeteSQL("UPDATE cdn.TypePersonne SET libelleType='" + monObjet.getLibelleTypePersonne() + "' WHERE idType=" + monObjet.getIdTypePersonne());
            this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
//------------------------------------------------------------------------------
        @Override
    public boolean supprimer(TypePersonne monObjet){
        try {
           this.setRequeteSQL("DELETE FROM `cdn`.`TypePersonne` WHERE `TypePersonne`.`idType` = " + monObjet.getIdTypePersonne());
           this.getConnection().createStatement().execute(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true; 
    }
}
