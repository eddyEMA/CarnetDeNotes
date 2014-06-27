/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.util;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.ema.cdn.gui.*;
import org.ema.cdn.metier.*;
/**
 *
 * @author eddy
 */
public class GestionLogin {
    FenetreLogin interfaceLogin;
    private Connection connection = AccesBDD.connectionBDD();
    private ResultSet resultat;
    private String requeteSQL;  

    public GestionLogin(){
     interfaceLogin = new FenetreLogin();
     
     //---------------Pour tester---------------------------//
     interfaceLogin.getMonPanneau().getMonTexte().setText("joel.vlasak");
     interfaceLogin.getMonPanneau().getMonTexteBis().setText("cisco");
      
     interfaceLogin.setVisible(true);
     interfaceLogin.getMonPanneau().getMonBouton().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          String identifiantRentre = (String) interfaceLogin.getMonPanneau().getMonTexte().getText();
          String motDePasseRentre = (String) interfaceLogin.getMonPanneau().getMonTexteBis().getText();
          Personne maPersonne = new Personne();
          try {
            resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.personne WHERE identifiantPersonne='" + identifiantRentre + '\'');
            if (resultat.first()){
                maPersonne.setIdTypePersonne(resultat.getInt("idTypePersonne"));
                if (resultat.getInt("idTypePersonne") == 1) {
                         maPersonne = new Professeur(resultat.getString("nomPersonne"), resultat.getString("prenomPersonne"), resultat.getDate("dateDeNaissancePersonne"), resultat.getString("identifiantPersonne"), resultat.getString("motDePassePersonne"), resultat.getInt("idMatiereProfesseur"));   
                }else if (resultat.getInt("idTypePersonne") == 2){
                        maPersonne = new Eleve(resultat.getString("nomPersonne"), resultat.getString("prenomPersonne"), resultat.getDate("dateDeNaissancePersonne"), resultat.getString("identifiantPersonne"), resultat.getString("motDePassePersonne"), resultat.getInt("idClasseEleve"), resultat.getInt("idTypePersonne"));
                }
                else if (resultat.getInt("idTypePersonne") == 3){
                        maPersonne = new Administrateur(resultat.getString("nomPersonne"), resultat.getString("prenomPersonne"), resultat.getDate("dateDeNaissancePersonne"), resultat.getString("identifiantPersonne"), resultat.getString("motDePassePersonne"));
                }
                maPersonne.setIdPersonne(resultat.getInt("idPersonne"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
          String mdp = maPersonne.getMotDePasse();
         if( !mdp.equals(motDePasseRentre)){
             interfaceLogin.getMonPanneau().getMonTexteBis().setText("mot de passe invalide");
         }
         else{
            if(maPersonne.getIdTypePersonne() == 1){
                GestionProfesseur gestionProfesseur = new GestionProfesseur((Professeur)maPersonne);
                interfaceLogin.setVisible(false);
            }
            if(maPersonne.getIdTypePersonne()  == 2){
                GestionEleve gestionEleve = new GestionEleve((Eleve)maPersonne);
                interfaceLogin.setVisible(false);
            }
            if(maPersonne.getIdTypePersonne()  == 3){
                GestionAdministrateur gestionAdmin = new GestionAdministrateur((Administrateur)maPersonne);
                interfaceLogin.setVisible(false);
            }
         }
        }
    });
    }
}
