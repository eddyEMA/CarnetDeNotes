/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author eddy
 */
public class FenetreAdmin extends Fenetre{
    private JLabel texteNomAdministrateur = new JLabel("Nom : ");
    private JLabel textePrenomAdministrateur = new JLabel("Prenom : "); 
    private JLabel texteIdentifiantUtilisateur = new JLabel("Login : "); 
    private JLabel texteIdentifiantUtilisateurModification = new JLabel("Login : ");
    private JLabel texteTypeUtilisateur = new JLabel("Type d'utilisateur : ");
    private JLabel texteNomUtilisateur = new JLabel("Nom : ");
    private JLabel textePrenomUtilisateur = new JLabel("Prenom : ");
    private JLabel texteMotDePasseUtilisateur = new JLabel("Mot de passe : ");
    private JLabel texteClasseEleve = new JLabel("Classe : ");
    private JLabel texteMatiereProf = new JLabel("Matiere : ");
    private JLabel texteDateDeNaissanceUtilisateur = new JLabel("Date de naissance : ");
    private JLabel texte = new JLabel("    ");
    private JButton ajouterUtilisateur;
    private JButton modifierUtilisateur;
    private JButton supprimerUtilisateur;
    private JButton validerAjouter;
    private JButton validerModifier;
    private JButton validerSupprimer;
    private JButton deconnexion;
    private JButton eleve;
    private JButton professeur;
    private JPanel premierPanel = new JPanel();
    private JPanel deuxiemePanel = new JPanel();
    private JPanel troisiemePanel = new JPanel();
    private JPanel quatriemePanel = new JPanel();
    private JPanel cinquiemePanel = new JPanel();
    private JTextField  champsIdentifiant = new JTextField();
    private JTextField  champsIdentifiantModification = new JTextField();
    private JTextField  champsNomUtilisateur = new JTextField();
    private JTextField  champsPrenomUtilisateur = new JTextField();
    private JTextField  champsMotDePasseUtilisateur = new JTextField();
    private JTextField  champsClasseEleve = new JTextField();
    private JTextField  champsMatiereProfesseur = new JTextField();
    private JTextField  champsDateDeNaissance = new JTextField();
    private JTextField  champsModification = new JTextField();
    private JComboBox choixModification = new JComboBox();
    private String nomAdministrateur;
    private String prenomAdministrateur;
    public FenetreAdmin(){

        premierPanel.setLayout(new GridLayout(5,1));
        premierPanel.add(texteNomAdministrateur);
        premierPanel.add(textePrenomAdministrateur);
        
        ajouterUtilisateur = creationBoutton("Ajouter utilisateur");
        modifierUtilisateur = creationBoutton("Modifier utilisateur");
        supprimerUtilisateur = creationBoutton("Supprimer utilisateur");
        deconnexion = creationBoutton("Déconnexion");
        
        deuxiemePanel.setLayout(new GridLayout(20,2));
        troisiemePanel.setLayout(new GridLayout(20,2));
        quatriemePanel.setLayout(new GridLayout(20,2));

        deuxiemePanel.add(ajouterUtilisateur);
        
        troisiemePanel.add(modifierUtilisateur);
        quatriemePanel.add(supprimerUtilisateur);    
        cinquiemePanel.add(deconnexion);
        ajouterUtilisateur();
        supprimerUtilisateur();
        modifierUtilisateur();

        ajouterPanel(premierPanel, deuxiemePanel, troisiemePanel, quatriemePanel, cinquiemePanel);
        initialisationFenetre();
    }
    public JButton creationBoutton(String nomBoutton){
            JButton monBoutton = new JButton(nomBoutton);
            return monBoutton;
  }
    public void initialisationFenetre(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Administrateur");
    this.setSize(700, 600);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
    public void ajouterPanel(JPanel premierPanel, JPanel deuxiemePanel, JPanel troisiemePanel, JPanel quatriemePanel, JPanel cinquiemePanel){
    this.getContentPane().add(premierPanel, BorderLayout.NORTH);
    this.getContentPane().add(deuxiemePanel, BorderLayout.WEST);
    this.getContentPane().add(troisiemePanel, BorderLayout.CENTER);
    this.getContentPane().add(quatriemePanel, BorderLayout.EAST);
    this.getContentPane().add(cinquiemePanel, BorderLayout.SOUTH);
  }
    public void ajouterUtilisateur(){
    validerAjouter = creationBoutton("Valider");
    eleve = creationBoutton("Eleve");
    professeur = creationBoutton("Professeur");
    deuxiemePanel.add(texte);
    deuxiemePanel.add(eleve);
    deuxiemePanel.add(professeur);
    deuxiemePanel.add(texteNomUtilisateur);
    deuxiemePanel.add(champsNomUtilisateur);
    deuxiemePanel.add(textePrenomUtilisateur);
    deuxiemePanel.add(champsPrenomUtilisateur);
    deuxiemePanel.add(texteDateDeNaissanceUtilisateur);
    deuxiemePanel.add(champsDateDeNaissance);
    deuxiemePanel.add(texteMotDePasseUtilisateur);
    deuxiemePanel.add(champsMotDePasseUtilisateur);
    deuxiemePanel.add(texteMatiereProf);
    deuxiemePanel.add(champsMatiereProfesseur);
    deuxiemePanel.add(texteClasseEleve);
    deuxiemePanel.add(champsClasseEleve);
    deuxiemePanel.add(validerAjouter);
    rendreVisibleAjouter(false);
  }
    public void rendreVisibleAjouter(boolean etat){
        validerAjouter.setVisible(etat);
        eleve.setVisible(etat);
        professeur.setVisible(etat);
        texte.setVisible(etat);
        eleve.setVisible(etat);
        professeur.setVisible(etat);
        texteNomUtilisateur.setVisible(etat);
        champsNomUtilisateur.setVisible(etat);
        textePrenomUtilisateur.setVisible(etat);
        champsPrenomUtilisateur.setVisible(etat);
        texteDateDeNaissanceUtilisateur.setVisible(etat);
        champsDateDeNaissance.setVisible(etat);
        texteMotDePasseUtilisateur.setVisible(etat);
        champsMotDePasseUtilisateur.setVisible(etat);
        texteMatiereProf.setVisible(etat);
        champsMatiereProfesseur.setVisible(etat);
        texteClasseEleve.setVisible(etat);
        champsClasseEleve.setVisible(etat);
        validerAjouter.setVisible(etat);
        
    }
    public void modifierUtilisateur(){
    validerModifier = creationBoutton("Valider");
    choixModification.addItem("Nom");
    choixModification.addItem("Prenom");
    choixModification.addItem("Date de naissance");
    choixModification.addItem("Mot de passe");
    choixModification.addItem("Classe");
    choixModification.addItem("Matiere");
    
    troisiemePanel.add(texteIdentifiantUtilisateurModification);
    troisiemePanel.add(champsIdentifiantModification);
    troisiemePanel.add(texte);
    troisiemePanel.add(choixModification);
    troisiemePanel.add(champsModification);
    troisiemePanel.add(validerModifier);
    rendreVisibleModifier(false);
  }
    public void rendreVisibleModifier(boolean etat){
        validerModifier.setVisible(etat);
        choixModification.setVisible(etat);
        texteIdentifiantUtilisateurModification.setVisible(etat);
        champsIdentifiantModification.setVisible(etat);
        texte.setVisible(etat);
        choixModification.setVisible(etat);  
        champsModification.setVisible(etat);   
        validerModifier.setVisible(etat);        
    }
    public void supprimerUtilisateur(){
    validerSupprimer = creationBoutton("Valider");
    quatriemePanel.add(texteIdentifiantUtilisateur);
    quatriemePanel.add(champsIdentifiant);
    quatriemePanel.add(validerSupprimer); 
    rendreVisibleSupprimer(false);
  }
    public void rendreVisibleSupprimer(boolean etat){
        validerSupprimer.setVisible(etat); 
        texteIdentifiantUtilisateur.setVisible(etat); 
        champsIdentifiant.setVisible(etat); 
        validerSupprimer.setVisible(etat);         
    }
    public JButton getAjouterUtilisateur() {
        return ajouterUtilisateur;
    }
    public JButton getModifierUtilisateur() {
        return modifierUtilisateur;
    }
    public JButton getSupprimerUtilisateur() {
        return supprimerUtilisateur;
    }
    public JButton getValiderAjouter() {
        return validerAjouter;
    }
    public JButton getValiderModifier() {
        return validerModifier;
    }
    public JButton getValiderSupprimer() {
        return validerSupprimer;
    }
    public JButton getDeconnexion() {
        return deconnexion;
    }
    public JButton getEleve() {
        return eleve;
    }
    public JButton getProfesseur() {
        return professeur;
    }
    public void actulisationText(){
        premierPanel.removeAll();
        texteNomAdministrateur = new JLabel("Nom : " + nomAdministrateur);
        textePrenomAdministrateur = new JLabel("Prenom : " + prenomAdministrateur);
        premierPanel.setLayout(new GridLayout(5,1));
        premierPanel.add(texteNomAdministrateur);    
        premierPanel.add(textePrenomAdministrateur);
  }
    public void setPrenomAdministrateur(String prenomAdministrateur) {
        this.prenomAdministrateur = prenomAdministrateur;
    }
    public void setNomAdministrateur(String nomAdministrateur) {
        this.nomAdministrateur = nomAdministrateur;
    }
    public JTextField getChampsIdentifiant() {
        return champsIdentifiant;
    }
    public JTextField getChampsIdentifiantModification() {
        return champsIdentifiantModification;
    }
    public JTextField getChampsNomUtilisateur() {
        return champsNomUtilisateur;
    }
    public JTextField getChampsPrenomUtilisateur() {
        return champsPrenomUtilisateur;
    }
    public JTextField getChampsMotDePasseUtilisateur() {
        return champsMotDePasseUtilisateur;
    }
    public JTextField getChampsClasseEleve() {
        return champsClasseEleve;
    }
    public JTextField getChampsMatiereProfesseur() {
        return champsMatiereProfesseur;
    }
    public JTextField getChampsDateDeNaissance() {
        return champsDateDeNaissance;
    }
    public JTextField getChampsModification() {
        return champsModification;
    }  
    public JComboBox getChoixModification() {
        return choixModification;
    }
    public JLabel getTexteNomAdministrateur() {
        return texteNomAdministrateur;
    }
    public JLabel getTextePrenomAdministrateur() {
        return textePrenomAdministrateur;
    }
    public JLabel getTexteIdentifiantUtilisateur() {
        return texteIdentifiantUtilisateur;
    }
    public JLabel getTexteIdentifiantUtilisateurModification() {
        return texteIdentifiantUtilisateurModification;
    }
    public JLabel getTexteTypeUtilisateur() {
        return texteTypeUtilisateur;
    }
    public JLabel getTexteNomUtilisateur() {
        return texteNomUtilisateur;
    }
    public JLabel getTextePrenomUtilisateur() {
        return textePrenomUtilisateur;
    }
    public JLabel getTexteMotDePasseUtilisateur() {
        return texteMotDePasseUtilisateur;
    }
    public JLabel getTexteClasseEleve() {
        return texteClasseEleve;
    }
    public JLabel getTexteMatiereProf() {
        return texteMatiereProf;
    }
    public JLabel getTexteDateDeNaissanceUtilisateur() {
        return texteDateDeNaissanceUtilisateur;
    }
    public JLabel getTexte() {
        return texte;
    }  
}
