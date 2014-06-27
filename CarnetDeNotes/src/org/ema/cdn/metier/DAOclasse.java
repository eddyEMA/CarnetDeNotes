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
        @Override
        public Classe chercher(Object id) {
        Classe maClasse = new Classe();
        try {
            this.setResultat(this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Classe WHERE idClasse =" + id));
            if (this.getResultat().first()){
                maClasse = new Classe(this.getResultat().getString("libelleClasse"), this.getResultat().getInt("idProfesseurClasse")); 
                maClasse.setIdClasse(this.getResultat().getInt("idClasse"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return maClasse; 
    }
//------------------------------------------------------------------------------
        @Override
    public boolean creer(Classe monObjet) {
        Statement statement = null;
        try {
           statement = this.getConnection().createStatement();
           this.setRequeteSQL("INSERT INTO cdn.Classe (libelleClasse, idProfesseurClasse) " + "VALUES('" + monObjet.getLibelleClasse() + "', '" + monObjet.getIdProfesseurClasse() + "')");
           statement.executeUpdate(this.getRequeteSQL(), statement.RETURN_GENERATED_KEYS);
           this.setResultat(statement.getGeneratedKeys());
           if (this.getResultat().next()){
               monObjet.setIdClasse(this.getResultat().getInt(1));
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
    public boolean mettreAjour(Classe monObjet){
        try {
            this.setRequeteSQL("UPDATE cdn.Classe SET libelleClasse='" + monObjet.getLibelleClasse() + "', idProfesseurClasse='" + monObjet.getIdProfesseurClasse() + "' WHERE idClasse=" + monObjet.getIdClasse());
            this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
//------------------------------------------------------------------------------
        @Override
    public boolean supprimer(Classe monObjet){
        try {
           this.setRequeteSQL("DELETE FROM `cdn`.`Classe` WHERE `Classe`.`idClasse` = " + monObjet.getIdClasse());
           this.getConnection().createStatement().execute(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true; 
    }
}
