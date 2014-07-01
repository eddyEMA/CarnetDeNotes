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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.ema.cdn.gui.*;
import org.ema.cdn.metier.*;
/**
 *
 * @author eddy
 */
public class GestionProfesseur {
    private final FenetreProfesseur interfaceProf;
    private final ArrayList<Classe> tableauClasse = new ArrayList<Classe>();
    private final ArrayList<ArrayList> tableauDeClasseEleve = new ArrayList<ArrayList>();
    private final Connection connection = AccesBDD.connectionBDD();
    private ResultSet resultat;
    private ResultSet resultat2; 
    private final ArrayList tableauID= new ArrayList();
    private final Professeur monProfesseur;
    private static final int YEAR2 = 1900;
    private static final int MONTH2 = 6;
    private static final int DATE2 = 15;
    private static final int ADD3 = 3;
    
    public GestionProfesseur(final Professeur monProfesseur){
        this.monProfesseur = monProfesseur;
        interfaceProf = new FenetreProfesseur();
        interfaceProf.setNomProfesseur(monProfesseur.getNom());
        interfaceProf.setPrenomProfesseur(monProfesseur.getPrenom());
        
        DAOmatiere daomatiere = new DAOmatiere();
        interfaceProf.setMatiereProfesseur(daomatiere.chercher(monProfesseur.getIdMatiereProfesseur()).getLibelleMatiere());
        
        interfaceProf.actulisationText();
        
        DAOclasse daoClasse = new DAOclasse();
        try {
            resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT idClasseCours FROM cdn.cours WHERE idProfesseurCours='" + monProfesseur.getIdPersonne() + '\'');
            if (resultat.first()){
                while(!resultat.isLast()){
                    tableauClasse.add(daoClasse.chercher(resultat.getInt("idClasseCours")));
                    resultat.next();
                }
               tableauClasse.add(daoClasse.chercher(resultat.getInt("idClasseCours")));
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
        }
        int y=0; 
        for(int i=0;i<tableauClasse.size();i++){
           
            try {
                ArrayList tableauEleve = new ArrayList();
                resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nomPersonne,prenomPersonne,idPersonne FROM personne WHERE idClasseEleve='" + tableauClasse.get(i).getIdClasse() + '\'');
         
                tableauEleve.add("null");
                tableauDeClasseEleve.add(tableauEleve);
                if (resultat.first()){
                    tableauEleve.remove(0);
                    while(!resultat.isLast()){     
                        tableauEleve.add(resultat.getString("nomPersonne"));
                        tableauEleve.add(resultat.getString("prenomPersonne"));
                        tableauID.add(resultat.getInt("idPersonne"));
                        resultat2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idEleveEpreuve='" + tableauID.get(y) + "' AND idMatiereEpreuve='" + monProfesseur.getIdMatiereProfesseur() + '\'');
                        String test = "SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idEleveEpreuve='" + tableauID.get(y) + "' AND idMatiereEpreuve='" + monProfesseur.getIdMatiereProfesseur() + '\'';
                        y++;
                        if(resultat2.first()){
               do{
                  tableauEleve.add(resultat2.getInt("noteEpreuve"));
                  tableauEleve.add(resultat2.getInt("coefficientEpreuve"));
               }
               while(resultat2.next());
                        }
                        resultat.next();
                        tableauEleve.add("null"); 
                    }
               tableauEleve.add(resultat.getString("nomPersonne"));
               tableauEleve.add(resultat.getString("prenomPersonne"));
               tableauID.add(resultat.getInt("idPersonne"));
               
               String requete = "SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idEleveEpreuve='" + tableauID.get(y) + "' AND idMatiereEpreuve='" + monProfesseur.getIdMatiereProfesseur() + '\'';
               resultat2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idEleveEpreuve='" + tableauID.get(y) + "' AND idMatiereEpreuve='" + monProfesseur.getIdMatiereProfesseur() + '\'');
               if(resultat2.first()){
               do{
                  tableauEleve.add(resultat2.getInt("noteEpreuve"));
                  tableauEleve.add(resultat2.getInt("coefficientEpreuve"));
               }
               while(resultat2.next());
               }       
                    tableauEleve.add("null"); 
               }
            y++;    
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);        
        }
           
        }
        
        
        interfaceProf.setTableauClasse(tableauClasse);
        interfaceProf.setTableauDeClasseEleve(tableauDeClasseEleve);
        interfaceProf.actulisationOnglet();
    }
    
    public void ecouteBouton(){
        interfaceProf.getSauvegarder().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {        
          DefaultTableModel monModel = (DefaultTableModel) interfaceProf.getTableauJTable().get(interfaceProf.getOnglets().getSelectedIndex()).getModel();
          DAOepreuve daoEpreuve = new DAOepreuve();
          for(int i=0;i<monModel.getRowCount();i++){
              if(Integer.parseInt(interfaceProf.getNombreDeNote().get(interfaceProf.getOnglets().getSelectedIndex()).toString()) != 0 || (ADD3+(Integer.parseInt(interfaceProf.getNombreDeNote().get(i).toString())*2)) != monModel.getColumnCount()){
              Epreuve monEpreuve = new Epreuve();
              int idEleve = 0;
              int indexOnglet = interfaceProf.getOnglets().getSelectedIndex();
              while( indexOnglet != 0){
                DefaultTableModel monModelTempon = (DefaultTableModel) interfaceProf.getTableauJTable().get(indexOnglet).getModel();
                idEleve += monModelTempon.getRowCount();
                indexOnglet--;
              }
              int idMatiereEpreuve = monProfesseur.getIdMatiereProfesseur();
              for(int y=2+(Integer.parseInt(interfaceProf.getNombreDeNote().get(interfaceProf.getOnglets().getSelectedIndex()).toString())*2);y<monModel.getColumnCount()-1;y++){
                  monEpreuve = new Epreuve((int)tableauID.get(idEleve)+i, idMatiereEpreuve, Integer.parseInt(monModel.getValueAt(i, y).toString()), new Date(YEAR2-YEAR2, MONTH2 -1, DATE2), Integer.parseInt(monModel.getValueAt(i, y+1).toString()));
                  y++;
              }
              daoEpreuve.creer(monEpreuve);
              }
          }
         interfaceProf.getTableauJTable().get(0).setModel(monModel);
         interfaceProf.getTableauJTable().get(0).repaint();
        }
    });
        interfaceProf.getAjouter().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {        
          DefaultTableModel monModel = (DefaultTableModel) interfaceProf.getTableauJTable().get(interfaceProf.getOnglets().getSelectedIndex()).getModel();
          monModel.setColumnCount(monModel.getColumnCount()-1);
          monModel.addColumn("Note Epreuve");
          monModel.addColumn("Coefficient Epreuve");
          monModel.addColumn("Moyenne");
         interfaceProf.getTableauJTable().get(0).setModel(monModel);
         interfaceProf.getTableauJTable().get(0).repaint();
        }
    });
        interfaceProf.getDeconnexion().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            interfaceProf.dispose();
            GestionLogin interfaceLogin = new GestionLogin();
        }
    });
    }
}
