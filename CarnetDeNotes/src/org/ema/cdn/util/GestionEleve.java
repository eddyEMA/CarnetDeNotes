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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ema.cdn.gui.*;
import org.ema.cdn.metier.*;
/**
 *
 * @author eddy
 */
public class GestionEleve {
    private ArrayList<Matiere> tableauMatiere = new ArrayList<Matiere>();
    private final Connection connection = AccesBDD.connectionBDD();
    private ResultSet resultat; 
    private final FenetreEleve interfaceEleve;
    private final ArrayList<ArrayList> tableauNotes = new ArrayList<ArrayList>();
    private final Eleve monEleve;
    
    public GestionEleve(Eleve monEleve){
        this.monEleve = monEleve;
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
                while(!resultat.isLast()){
                    tableauMatiere.add(daomatiere.chercher(resultat.getInt("idMatiereCours")));
                    resultat.next();
                }
               tableauMatiere.add(daomatiere.chercher(resultat.getInt("idMatiereCours")));
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);        
        }
        
        for(int i=0;i<tableauMatiere.size();i++){
            try {
                resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idMatiereEpreuve='" + tableauMatiere.get(i).getIdMatiere() +'\'' + " AND idEleveEpreuve='" + monEleve.getIdPersonne() + '\'');
                ArrayList tableauDeNotes = new ArrayList();                    
                tableauDeNotes.add(-1);
                tableauNotes.add(tableauDeNotes);
                if (resultat.first()){
                    tableauDeNotes.remove(0);
                    while(!resultat.isLast()){
                        
                        tableauDeNotes.add(resultat.getInt("noteEpreuve"));
                        tableauDeNotes.add(resultat.getInt("coefficientEpreuve"));
                        resultat.next();
                    }
               tableauDeNotes.add(resultat.getInt("noteEpreuve"));
               tableauDeNotes.add(resultat.getInt("coefficientEpreuve"));
                }                
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);        
        }
        }
        interfaceEleve.setTableauMatiere(tableauMatiere);
        interfaceEleve.setTableauNotes(tableauNotes);

        interfaceEleve.actulisationOnglet();
        
    }
    public void ecouteBouton(){
        interfaceEleve.getDeconnexion().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            interfaceEleve.dispose();
            tableauMatiere = null;
            GestionLogin interfaceLogin = new GestionLogin();
            
        }
    });
    }
}
