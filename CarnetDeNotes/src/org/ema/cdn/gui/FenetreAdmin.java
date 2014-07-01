/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
    private final JLabel texteIdentifiantUtilisateur = new JLabel("Login : "); 
    private final JLabel texteIdentifiantUtilisateurModification = new JLabel("Login : ");
    private final JLabel texteTypeUtilisateur = new JLabel("Type d'utilisateur : ");
    private final JLabel texteNomUtilisateur = new JLabel("Nom : ");
    private final JLabel textePrenomUtilisateur = new JLabel("Prenom : ");
    private final JLabel texteMotDePasseUtilisateur = new JLabel("Mot de passe : ");
    private final JLabel texteClasseEleve = new JLabel("Classe : ");
    private final JLabel texteMatiereProf = new JLabel("Matiere : ");
    private final JLabel texteDateDeNaissanceUtilisateur = new JLabel("Date de naissance : ");
    private final JLabel texte = new JLabel("    ");
    private final JButton ajouterUtilisateur;
    private final JButton modifierUtilisateur;
    private final JButton supprimerUtilisateur;
    private JButton validerAjouter;
    private JButton validerModifier;
    private JButton validerSupprimer;
    private final JButton deconnexion;
    private JButton eleve;
    private JButton professeur;
    private final JPanel premierPanel = new JPanel();
    private final JPanel deuxiemePanel = new JPanel();
    private final JPanel troisiemePanel = new JPanel();
    private final JPanel quatriemePanel = new JPanel();
    private final JPanel cinquiemePanel = new JPanel();
    private final JTextField  champsIdentifiant = new JTextField();
    private final JTextField  champsIdentifiantModification = new JTextField();
    private final JTextField  champsNomUtilisateur = new JTextField();
    private final JTextField  champsPrenomUtilisateur = new JTextField();
    private final JTextField  champsMotDePasseUtilisateur = new JTextField();
    private final JTextField  champsClasseEleve = new JTextField();
    private final JTextField  champsMatiereProfesseur = new JTextField();
    private final JTextField  champsDateDeNaissance = new JTextField();
    private final JTextField  champsModification = new JTextField();
    private final JComboBox choixModification = new JComboBox();
    private String nomAdministrateur;
    private String prenomAdministrateur;
    private static final int X5 = 5;
    private static final int X20 = 20;
    private static final int SIZEWIDTH = 700;
    private static final int SIZEHEIGHT = 600;
    
    public FenetreAdmin(){

        premierPanel.setLayout(new GridLayout(X5,1));
        premierPanel.add(texteNomAdministrateur);
        premierPanel.add(textePrenomAdministrateur);
        
        ajouterUtilisateur = creationBoutton("Ajouter utilisateur");
        modifierUtilisateur = creationBoutton("Modifier utilisateur");
        supprimerUtilisateur = creationBoutton("Supprimer utilisateur");
        deconnexion = creationBoutton("Déconnexion");
        
        deuxiemePanel.setLayout(new GridLayout(X20,2));
        troisiemePanel.setLayout(new GridLayout(X20,2));
        quatriemePanel.setLayout(new GridLayout(X20,2));

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
    public final JButton creationBoutton(String nomBoutton){
            JButton monBoutton = new JButton(nomBoutton);
            return monBoutton;
  }
    public final void initialisationFenetre(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Administrateur");
    this.setSize(SIZEWIDTH, SIZEHEIGHT);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
    public final void ajouterPanel(JPanel premierPanel, JPanel deuxiemePanel, JPanel troisiemePanel, JPanel quatriemePanel, JPanel cinquiemePanel){
    this.getContentPane().add(premierPanel, BorderLayout.NORTH);
    this.getContentPane().add(deuxiemePanel, BorderLayout.WEST);
    this.getContentPane().add(troisiemePanel, BorderLayout.CENTER);
    this.getContentPane().add(quatriemePanel, BorderLayout.EAST);
    this.getContentPane().add(cinquiemePanel, BorderLayout.SOUTH);
  }
    public final void ajouterUtilisateur(){
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
    public final void modifierUtilisateur(){
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
    public final void supprimerUtilisateur(){
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
        premierPanel.setLayout(new GridLayout(X5,1));
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