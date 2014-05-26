/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author eddy
 */
public class DAOpersonne extends DAO<Personne>{
    public Personne chercher(int id) {
        Personne maPersonne = new Personne();
        try {
            resultat = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.personne WHERE idPersonne =" + id);
            if (resultat.first()){
                if (resultat.getInt("idTypePersonne") == 1) {
                         maPersonne = new Professeur(resultat.getString("nomPersonne"), resultat.getString("prenomPersonne"), resultat.getDate("dateDeNaissancePersonne"), resultat.getString("identifiantPersonne"), resultat.getString("motDePassePersonne"), resultat.getInt("idMatiereProfesseur"));   
                        }
                else if (resultat.getInt("idTypePersonne") == 2) {
                        maPersonne = new Eleve(resultat.getString("nomPersonne"), resultat.getString("prenomPersonne"), resultat.getDate("dateDeNaissancePersonne"), resultat.getString("identifiantPersonne"), resultat.getString("motDePassePersonne"), resultat.getInt("idClasseEleve"));
                }
                maPersonne.setIdPersonne(resultat.getInt("idPersonne"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maPersonne; 
    }
    public boolean creer(Personne monObjet) {
        String patternDate = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(patternDate);
        try {
            Statement statement = this.connection.createStatement();
           requeteSQL = "INSERT INTO cdn.Personne ( nomPersonne, prenomPersonne, dateDeNaissancePersonne, identifiantPersonne, motDePassePersonne, idMatiereProfesseur, idClasseEleve, idTypePersonne) " + "VALUES(" + "'" + monObjet.getNom() + "', '" + monObjet.getPrenom() + "', '" + formatter.format(monObjet.getDateDeNaissancePersonne()) + "', '" + monObjet.getIdentifiantPersonne() + "', " + monObjet.getMotDePasse() + ", " + monObjet.getIdMatiereProfesseur() + ", " + monObjet.getIdClasseEleve() + ", " + monObjet.getIdTypePersonne() + ')';
           statement.executeUpdate(requeteSQL, statement.RETURN_GENERATED_KEYS);
           resultat = statement.getGeneratedKeys();
           if (resultat.next()){
               monObjet.setIdPersonne(resultat.getInt(1));
           }
         } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean mettreAjour(Personne monObjet){
        String patternDate = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(patternDate);
        try {
            requeteSQL = "UPDATE cdn.Personne SET nomPersonne='" + monObjet.getNom() + "', prenomPersonne='" + monObjet.getPrenom() + "', dateDeNaissancePersonne='" + formatter.format(monObjet.getDateDeNaissancePersonne()) + "', identifiantPersonne='" + monObjet.getIdentifiantPersonne() + "', motDePassePersonne='" + monObjet.getMotDePasse() + "', idMatiereProfesseur='" +monObjet.getIdMatiereProfesseur()+ "', idClasseEleve='" + monObjet.getIdClasseEleve() + "', idTypePersonne='" + monObjet.getIdTypePersonne() + "' WHERE idPersonne=" + monObjet.getIdPersonne();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    public boolean supprimer(Personne monObjet){
        try {
           requeteSQL = "DELETE FROM `cdn`.`personne` WHERE `personne`.`idPersonne` = " + monObjet.getIdPersonne() ;
           this.connection.createStatement().execute(requeteSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        monObjet = null;
        return true; 
    }  
}
