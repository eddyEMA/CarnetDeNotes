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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ema.cdn.gui.*;
import org.ema.cdn.metier.*;

/**
 *
 * @author eddy
 */
public class GestionAdministrateur {
    FenetreAdmin interfaceAdministrateur;
    private boolean etatAjouter = false;
    private boolean etatSupprimer = false;
    private boolean etatModifier = false;
    private boolean etatEleve = false;
    private boolean etatProfesseur = false;
    private Connection connection = AccesBDD.connectionBDD();
    private ResultSet resultat;
    
    public GestionAdministrateur(Administrateur monAdministrateur){
    interfaceAdministrateur = new FenetreAdmin();
    interfaceAdministrateur.setNomAdministrateur(monAdministrateur.getNom());
    interfaceAdministrateur.setPrenomAdministrateur(monAdministrateur.getPrenom());
    interfaceAdministrateur.actulisationText();
    
    interfaceAdministrateur.getEleve().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        if(etatEleve == false){   
            interfaceAdministrateur.getTexteNomUtilisateur().setVisible(true);
            interfaceAdministrateur.getChampsNomUtilisateur().setVisible(true);
            interfaceAdministrateur.getTextePrenomUtilisateur().setVisible(true);
            interfaceAdministrateur.getChampsPrenomUtilisateur().setVisible(true);
            interfaceAdministrateur.getTexteDateDeNaissanceUtilisateur().setVisible(true);
            interfaceAdministrateur.getChampsDateDeNaissance().setVisible(true);
            interfaceAdministrateur.getTexteMotDePasseUtilisateur().setVisible(true);
            interfaceAdministrateur.getChampsMotDePasseUtilisateur().setVisible(true);
            interfaceAdministrateur.getTexteClasseEleve().setVisible(true);
            interfaceAdministrateur.getChampsClasseEleve().setVisible(true);
            interfaceAdministrateur.getTexteMatiereProf().setVisible(true);
            interfaceAdministrateur.getChampsMatiereProfesseur().setVisible(true);
            interfaceAdministrateur.getTexteMatiereProf().setVisible(false);
            interfaceAdministrateur.getChampsMatiereProfesseur().setVisible(false);        
            interfaceAdministrateur.getValiderAjouter().setVisible(true);
            etatEleve = true;
        }
        else{
            {   
            interfaceAdministrateur.getTexteNomUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsNomUtilisateur().setVisible(false);
            interfaceAdministrateur.getTextePrenomUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsPrenomUtilisateur().setVisible(false);
            interfaceAdministrateur.getTexteDateDeNaissanceUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsDateDeNaissance().setVisible(false);
            interfaceAdministrateur.getTexteMotDePasseUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsMotDePasseUtilisateur().setVisible(false);
            interfaceAdministrateur.getTexteClasseEleve().setVisible(false);
            interfaceAdministrateur.getChampsClasseEleve().setVisible(false);
            interfaceAdministrateur.getTexteMatiereProf().setVisible(false);
            interfaceAdministrateur.getChampsMatiereProfesseur().setVisible(false);
            interfaceAdministrateur.getValiderAjouter().setVisible(false);
            etatEleve = false;
        }
        }
        }
    });
    interfaceAdministrateur.getProfesseur().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        if(etatProfesseur == false){   
            interfaceAdministrateur.getTexteNomUtilisateur().setVisible(true);
            interfaceAdministrateur.getChampsNomUtilisateur().setVisible(true);
            interfaceAdministrateur.getTextePrenomUtilisateur().setVisible(true);
            interfaceAdministrateur.getChampsPrenomUtilisateur().setVisible(true);
            interfaceAdministrateur.getTexteDateDeNaissanceUtilisateur().setVisible(true);
            interfaceAdministrateur.getChampsDateDeNaissance().setVisible(true);
            interfaceAdministrateur.getTexteMotDePasseUtilisateur().setVisible(true);
            interfaceAdministrateur.getChampsMotDePasseUtilisateur().setVisible(true);
            interfaceAdministrateur.getTexteMatiereProf().setVisible(true);
            interfaceAdministrateur.getChampsMatiereProfesseur().setVisible(true);
            interfaceAdministrateur.getTexteClasseEleve().setVisible(false);
            interfaceAdministrateur.getChampsClasseEleve().setVisible(false);
            interfaceAdministrateur.getValiderAjouter().setVisible(true);
            etatProfesseur = true;
        }
        else{
            {   
            interfaceAdministrateur.getTexteNomUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsNomUtilisateur().setVisible(false);
            interfaceAdministrateur.getTextePrenomUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsPrenomUtilisateur().setVisible(false);
            interfaceAdministrateur.getTexteDateDeNaissanceUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsDateDeNaissance().setVisible(false);
            interfaceAdministrateur.getTexteMotDePasseUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsMotDePasseUtilisateur().setVisible(false);
            interfaceAdministrateur.getTexteMatiereProf().setVisible(false);
            interfaceAdministrateur.getChampsMatiereProfesseur().setVisible(false);
            interfaceAdministrateur.getTexteClasseEleve().setVisible(false);
            interfaceAdministrateur.getChampsClasseEleve().setVisible(false);
            interfaceAdministrateur.getValiderAjouter().setVisible(false);
            etatProfesseur = false;
        }
        }
        }
    });
    interfaceAdministrateur.getValiderAjouter().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            DAOpersonne daoPersonne = new DAOpersonne();
                if(interfaceAdministrateur.getTexteClasseEleve().isVisible() == true){
                    int idClasse = -1;   
                    try {
                        resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idClasse FROM cdn.classe WHERE libelleClasse='" + interfaceAdministrateur.getChampsClasseEleve().getText() + '\'');
                        if (resultat.first()){
                            idClasse = resultat.getInt("idClasse");
                        }
                    } 
                    catch (SQLException ex) {
                    Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);        
                    }              
                    Personne monEleve = new Eleve(interfaceAdministrateur.getChampsNomUtilisateur().getText(),
                    interfaceAdministrateur.getChampsPrenomUtilisateur().getText(),
                    new Date(1900-1900, 6 -1, 15),
                    interfaceAdministrateur.getChampsPrenomUtilisateur().getText() + '.' + interfaceAdministrateur.getChampsNomUtilisateur().getText(),
                    interfaceAdministrateur.getChampsMotDePasseUtilisateur().getText(),
                    idClasse,2);
                    daoPersonne.creer(monEleve);
                }
                if(interfaceAdministrateur.getTexteMatiereProf().isVisible() == true){
                    Professeur monProfesseur; 
                    int idMatiere= -1;
                    try {
                        resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idMatiere FROM cdn.matiere WHERE libelleMatiere='" + interfaceAdministrateur.getChampsMatiereProfesseur().getText() + '\'');
                        if (resultat.first()){
                            idMatiere = resultat.getInt("idMatiere");
                        }
                    } 
                    catch (SQLException ex) {
                    Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);        
                    }   
                    Personne monProf = new Professeur(interfaceAdministrateur.getChampsNomUtilisateur().getText(),
                    interfaceAdministrateur.getChampsPrenomUtilisateur().getText(), 
                    new Date(1900-1900, 6 -1, 15),
                    interfaceAdministrateur.getChampsPrenomUtilisateur().getText() + '.' + interfaceAdministrateur.getChampsNomUtilisateur().getText(), 
                    interfaceAdministrateur.getChampsMotDePasseUtilisateur().getText(), 
                    idMatiere);
                    daoPersonne.creer(monProf);
                }
            interfaceAdministrateur.getEleve().setVisible(false);
            interfaceAdministrateur.getProfesseur().setVisible(false);
            interfaceAdministrateur.getTexteNomUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsNomUtilisateur().setVisible(false);
            interfaceAdministrateur.getTextePrenomUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsPrenomUtilisateur().setVisible(false);
            interfaceAdministrateur.getTexteDateDeNaissanceUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsDateDeNaissance().setVisible(false);
            interfaceAdministrateur.getTexteMotDePasseUtilisateur().setVisible(false);
            interfaceAdministrateur.getChampsMotDePasseUtilisateur().setVisible(false);
            interfaceAdministrateur.getTexteMatiereProf().setVisible(false);
            interfaceAdministrateur.getChampsMatiereProfesseur().setVisible(false);
            interfaceAdministrateur.getTexteClasseEleve().setVisible(false);
            interfaceAdministrateur.getChampsClasseEleve().setVisible(false);
            interfaceAdministrateur.getValiderAjouter().setVisible(false);
            etatAjouter = false;
            etatProfesseur = false;
            etatEleve = false;
        }
    });
    interfaceAdministrateur.getValiderModifier().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(etatModifier==true){
                interfaceAdministrateur.rendreVisibleModifier(false);
                etatModifier = false; 
                DAOpersonne daoPersonne = new DAOpersonne();
                Personne maPersonne = daoPersonne.chercher(interfaceAdministrateur.getChampsIdentifiantModification().getText());

                if(interfaceAdministrateur.getChoixModification().getSelectedItem().equals("Nom") == true){
                    maPersonne.setNom(interfaceAdministrateur.getChampsModification().getText());
                }
                if(interfaceAdministrateur.getChoixModification().getSelectedItem().equals("Prenom") == true){
                    maPersonne.setPrenom(interfaceAdministrateur.getChampsModification().getText());
                }
                if(interfaceAdministrateur.getChoixModification().getSelectedItem().equals("Date de naissance") == true){
                    
                }
                if(interfaceAdministrateur.getChoixModification().getSelectedItem().equals("Mot de passe") == true){
                   maPersonne.setMotDePasse(interfaceAdministrateur.getChampsModification().getText());
                }
                if(interfaceAdministrateur.getChoixModification().getSelectedItem().equals("Classe") == true){
                    
                }
                if(interfaceAdministrateur.getChoixModification().getSelectedItem().equals("Matiere") == true){
                    
                }
                daoPersonne.mettreAjour(maPersonne);
            }
        }
    });
    interfaceAdministrateur.getValiderSupprimer().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            DAOpersonne daoPersonne = new DAOpersonne();
            daoPersonne.supprimer(daoPersonne.chercher(interfaceAdministrateur.getChampsIdentifiant().getText()));
            interfaceAdministrateur.rendreVisibleSupprimer(false);
            etatSupprimer = false;
        }
    });
    interfaceAdministrateur.getDeconnexion().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            interfaceAdministrateur.dispose();
            GestionLogin interfaceLogin = new GestionLogin();
            
        }
    });
    interfaceAdministrateur.getAjouterUtilisateur().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(etatAjouter == false){
                //interfaceAdministrateur.rendreVisibleAjouter(true);
                interfaceAdministrateur.getEleve().setVisible(true);
                interfaceAdministrateur.getProfesseur().setVisible(true);
                etatAjouter = true;
            }
            else{
                interfaceAdministrateur.getEleve().setVisible(false);
                interfaceAdministrateur.getProfesseur().setVisible(false);
                interfaceAdministrateur.getTexteNomUtilisateur().setVisible(false);
                interfaceAdministrateur.getChampsNomUtilisateur().setVisible(false);
                interfaceAdministrateur.getTextePrenomUtilisateur().setVisible(false);
                interfaceAdministrateur.getChampsPrenomUtilisateur().setVisible(false);
                interfaceAdministrateur.getTexteDateDeNaissanceUtilisateur().setVisible(false);
                interfaceAdministrateur.getChampsDateDeNaissance().setVisible(false);
                interfaceAdministrateur.getTexteMotDePasseUtilisateur().setVisible(false);
                interfaceAdministrateur.getChampsMotDePasseUtilisateur().setVisible(false);
                interfaceAdministrateur.getTexteMatiereProf().setVisible(false);
                interfaceAdministrateur.getChampsMatiereProfesseur().setVisible(false);
                interfaceAdministrateur.getTexteClasseEleve().setVisible(false);
                interfaceAdministrateur.getChampsClasseEleve().setVisible(false);
                interfaceAdministrateur.getValiderAjouter().setVisible(false);
                etatAjouter = false;
                etatProfesseur = false;
                etatEleve = false;
            }
        }
    });
    interfaceAdministrateur.getModifierUtilisateur().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(etatModifier == false){
                interfaceAdministrateur.rendreVisibleModifier(true);
                etatModifier = true;
            }
            else{
                interfaceAdministrateur.rendreVisibleModifier(false);
                etatModifier = false;
            }
        }
    });
    interfaceAdministrateur.getSupprimerUtilisateur().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(etatSupprimer == false){
                interfaceAdministrateur.rendreVisibleSupprimer(true);
                etatSupprimer = true;
            }
            else{
                interfaceAdministrateur.rendreVisibleSupprimer(false);
                etatSupprimer = false;
            }
        }
    });
   }
}
