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
public class DAOmatiere extends DAO<Matiere>{
    @Override
    public Matiere chercher(Object id) {
        Matiere maMatiere = new Matiere();
        try {
            this.setResultat(this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Matiere WHERE idMatiere =" + id));
            if (this.getResultat().first()){
                maMatiere = new Matiere(this.getResultat().getString("libelleMatiere")); 
                maMatiere.setIdMatiere(this.getResultat().getInt("idMatiere"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return maMatiere; 
    }
//------------------------------------------------------------------------------
    @Override
    public boolean creer(Matiere monObjet) {
        Statement statement = null;
        try {
           statement = this.getConnection().createStatement();
           this.setRequeteSQL("INSERT INTO cdn.Matiere (libelleMatiere) " + "VALUES('" + monObjet.getLibelleMatiere() + "')");
           statement.executeUpdate(this.getRequeteSQL(), statement.RETURN_GENERATED_KEYS);
           this.setResultat(statement.getGeneratedKeys());
           if (this.getResultat().next()){
               monObjet.setIdMatiere(this.getResultat().getInt(1));
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
    public boolean mettreAjour(Matiere monObjet){
        try {
            this.setRequeteSQL("UPDATE cdn.Matiere SET libelleMatiere='" + monObjet.getLibelleMatiere() + "' WHERE idMatiere=" + monObjet.getIdMatiere());
            this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
//------------------------------------------------------------------------------
    @Override
    public boolean supprimer(Matiere monObjet){
        try {
           this.setRequeteSQL("DELETE FROM `cdn`.`Matiere` WHERE `Matiere`.`idMatiere` = " + monObjet.getIdMatiere());
           this.getConnection().createStatement().execute(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true; 
    }
}
