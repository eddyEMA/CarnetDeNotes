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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ema.cdn.gui.*;
import org.ema.cdn.metier.*;
/**
 *
 * @author eddy
 */
public class GestionEleve {
    private Vector<Matiere> tableauMatiere = new Vector<Matiere>();
    private Connection connection = AccesBDD.connectionBDD();
    private ResultSet resultat;
    private String requeteSQL;  
    private FenetreEleve interfaceEleve;
    private Vector<Vector> tableauNotes = new Vector<Vector>();
    
    public GestionEleve(Eleve monEleve){
        interfaceEleve = new FenetreEleve();
        interfaceEleve.setNomEleve(monEleve.getNom());
        interfaceEleve.setPrenomEleve(monEleve.getPrenom());

        DAOclasse daoClasse = new DAOclasse();
        
        interfaceEleve.setClasseEleve(daoClasse.chercher(monEleve.getIdClasseEleve()).getLibelleClasse());
        interfaceEleve.actulisationText();
        
        DAOmatiere daomatiere = new DAOmatiere();
        
        try {
            resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idMatiereCours FROM cdn.cours WHERE idClasseCours='" + monEleve.getIdClasseEleve() + '\'');
            if (resultat.first()){
                while(resultat.isLast() == false){
                    tableauMatiere.addElement(daomatiere.chercher(resultat.getInt("idMatiereCours")));
                    resultat.next();
                }
               tableauMatiere.addElement(daomatiere.chercher(resultat.getInt("idMatiereCours"))); 
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);        
        }
        
        for(int i=0;i<tableauMatiere.size();i++){
            try {
                resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idMatiereEpreuve='" + tableauMatiere.elementAt(i).getIdMatiere() +'\'' + " AND idEleveEpreuve='" + monEleve.getIdPersonne() + '\'');
                Vector tableauDeNotes = new Vector();                    
                tableauDeNotes.addElement(-1);
                tableauNotes.addElement(tableauDeNotes);
                if (resultat.first()){
                    tableauDeNotes.remove(0);
                    while(resultat.isLast() == false){
                        
                        tableauDeNotes.addElement(resultat.getInt("noteEpreuve"));
                        tableauDeNotes.addElement(resultat.getInt("coefficientEpreuve"));
                        resultat.next();
                    }
               tableauDeNotes.addElement(resultat.getInt("noteEpreuve"));
               tableauDeNotes.addElement(resultat.getInt("coefficientEpreuve"));
               //tableauNotes.addElement(tableauDeNotes);
                }                
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);        
        }
        }
        interfaceEleve.setTableauMatiere(tableauMatiere);
        interfaceEleve.setTableauNotes(tableauNotes);

        interfaceEleve.actulisationOnglet();
        interfaceEleve.getDeconnexion().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            interfaceEleve.dispose();
            tableauMatiere = null;
            GestionLogin interfaceLogin = new GestionLogin();
            
        }
    });
    }
    
}
