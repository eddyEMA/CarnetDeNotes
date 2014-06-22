/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author eddy
 */
public class DAOpersonne extends DAO<Personne>{
    @Override
    public Personne chercher(int id) {
        Personne maPersonne = new Personne();
        try {
            this.setResultat(this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.personne WHERE idPersonne =" + id));
            if (this.getResultat().first()){
                if (this.getResultat().getInt("idTypePersonne") == 1) {
                         maPersonne = new Professeur(this.getResultat().getString("nomPersonne"), this.getResultat().getString("prenomPersonne"), this.getResultat().getDate("dateDeNaissancePersonne"), this.getResultat().getString("identifiantPersonne"), this.getResultat().getString("motDePassePersonne"), this.getResultat().getInt("idMatiereProfesseur"));   
                }else if (this.getResultat().getInt("idTypePersonne") == 2){
                        maPersonne = new Eleve(this.getResultat().getString("nomPersonne"), this.getResultat().getString("prenomPersonne"), this.getResultat().getDate("dateDeNaissancePersonne"), this.getResultat().getString("identifiantPersonne"), this.getResultat().getString("motDePassePersonne"), this.getResultat().getInt("idClasseEleve"));
                }
                maPersonne.setIdPersonne(this.getResultat().getInt("idPersonne"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maPersonne; 
    }
//------------------------------------------------------------------------------
    @Override
    public boolean creer(Personne monObjet) {
        String patternDate = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(patternDate);
        Statement statement = null;
        try {
           statement = this.getConnection().createStatement();
           this.setRequeteSQL("INSERT INTO cdn.Personne ( nomPersonne, prenomPersonne, dateDeNaissancePersonne, identifiantPersonne, motDePassePersonne, idMatiereProfesseur, idClasseEleve, idTypePersonne) " + "VALUES(" + "'" + monObjet.getNom() + "', '" + monObjet.getPrenom() + "', '" + formatter.format(monObjet.getDateDeNaissancePersonne()) + "', '" + monObjet.getIdentifiantPersonne() + "', " + monObjet.getMotDePasse() + ", " + monObjet.getIdMatiereProfesseur() + ", " + monObjet.getIdClasseEleve() + ", " + monObjet.getIdTypePersonne() + ')');
           statement.executeUpdate(this.getRequeteSQL(), statement.RETURN_GENERATED_KEYS);
           this.setResultat(statement.getGeneratedKeys());
           if (this.getResultat().next()){
               monObjet.setIdPersonne(this.getResultat().getInt(1));
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
    public boolean mettreAjour(Personne monObjet){
        String patternDate = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(patternDate);
        try {
            this.setRequeteSQL("UPDATE cdn.Personne SET nomPersonne='" + monObjet.getNom() + "', prenomPersonne='" + monObjet.getPrenom() + "', dateDeNaissancePersonne='" + formatter.format(monObjet.getDateDeNaissancePersonne()) + "', identifiantPersonne='" + monObjet.getIdentifiantPersonne() + "', motDePassePersonne='" + monObjet.getMotDePasse() + "', idMatiereProfesseur='" +monObjet.getIdMatiereProfesseur()+ "', idClasseEleve='" + monObjet.getIdClasseEleve() + "', idTypePersonne='" + monObjet.getIdTypePersonne() + "' WHERE idPersonne=" + monObjet.getIdPersonne());
            this.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
//------------------------------------------------------------------------------
    @Override
    public boolean supprimer(Personne monObjet){
        try {
           this.setRequeteSQL("DELETE FROM `cdn`.`personne` WHERE `personne`.`idPersonne` = " + monObjet.getIdPersonne());
           this.getConnection().createStatement().execute(this.getRequeteSQL());
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true; 
    }  
}
