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
import org.ema.cdn.gui.*;
import org.ema.cdn.metier.*;
/**
 *
 * @author eddy
 */
public class GestionLogin {
    private final FenetreLogin interfaceLogin;
    private final Connection connection = AccesBDD.connectionBDD();
    private ResultSet resultat;
    private static final int IDTYPE = 3;

    public GestionLogin(){
     interfaceLogin = new FenetreLogin();
     interfaceLogin.setVisible(true);
     interfaceLogin.getMonPanneau().getMonBouton().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          String identifiantRentre = (String) interfaceLogin.getMonPanneau().getMonTexte().getText();
          String motDePasseRentre = (String) interfaceLogin.getMonPanneau().getMonTexteBis().getText();
          Personne maPersonne = new Personne();
          if(connection != null){
          try {
            resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.personne WHERE identifiantPersonne='" + identifiantRentre + '\'');
            if (resultat.first()){
                maPersonne.setIdTypePersonne(resultat.getInt("idTypePersonne"));
                if (resultat.getInt("idTypePersonne") == 1) {
                         maPersonne = new Professeur(resultat.getString("nomPersonne"), resultat.getString("prenomPersonne"), resultat.getDate("dateDeNaissancePersonne"), resultat.getString("identifiantPersonne"), resultat.getString("motDePassePersonne"), resultat.getInt("idMatiereProfesseur"));   
                }else if (resultat.getInt("idTypePersonne") == 2){
                        maPersonne = new Eleve(resultat.getString("nomPersonne"), resultat.getString("prenomPersonne"), resultat.getDate("dateDeNaissancePersonne"), resultat.getString("identifiantPersonne"), resultat.getString("motDePassePersonne"), resultat.getInt("idClasseEleve"), resultat.getInt("idTypePersonne"));
                }
                else if (resultat.getInt("idTypePersonne") == IDTYPE){
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
                gestionProfesseur.ecouteBouton();
                interfaceLogin.setVisible(false);
            }
            if(maPersonne.getIdTypePersonne()  == 2){
                GestionEleve gestionEleve = new GestionEleve((Eleve)maPersonne);
                gestionEleve.ecouteBouton();
                interfaceLogin.setVisible(false);
            }
            if(maPersonne.getIdTypePersonne()  == IDTYPE){
                GestionAdministrateur gestionAdmin = new GestionAdministrateur((Administrateur)maPersonne);
                gestionAdmin.ecouteBoutton();
                interfaceLogin.setVisible(false);
            }
         }
        }
        }
    });
    }
    
}
