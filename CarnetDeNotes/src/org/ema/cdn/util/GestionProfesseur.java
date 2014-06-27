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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.ema.cdn.gui.*;
import org.ema.cdn.gui.*;
import org.ema.cdn.metier.*;
/**
 *
 * @author eddy
 */
public class GestionProfesseur {
    private FenetreProfesseur interfaceProf;
    private Vector<Classe> tableauClasse = new Vector<Classe>();
    private Vector<Vector> tableauDeClasseEleve = new Vector<Vector>();
    private Connection connection = AccesBDD.connectionBDD();
    private ResultSet resultat;
    private ResultSet resultat2;
    private String requeteSQL;  
    private Vector tableauID= new Vector();
    Professeur monProfesseur;
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
                while(resultat.isLast() == false){
                    tableauClasse.addElement(daoClasse.chercher(resultat.getInt("idClasseCours")));
                    resultat.next();
                }
               tableauClasse.addElement(daoClasse.chercher(resultat.getInt("idClasseCours"))); 
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);        
        }
        int y=0; 
        for(int i=0;i<tableauClasse.size();i++){
           
            try {
                Vector tableauEleve = new Vector();
                resultat = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT nomPersonne,prenomPersonne,idPersonne FROM personne WHERE idClasseEleve='" + tableauClasse.elementAt(i).getIdClasse() + '\'');
         
                tableauEleve.addElement("null");
                tableauDeClasseEleve.addElement(tableauEleve);
                if (resultat.first()){
                    tableauEleve.remove(0);
                    while(resultat.isLast() == false){     
                        tableauEleve.addElement(resultat.getString("nomPersonne"));
                        tableauEleve.addElement(resultat.getString("prenomPersonne"));
                        tableauID.addElement(resultat.getInt("idPersonne"));
                        resultat2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idEleveEpreuve='" + tableauID.get(y) + "' AND idMatiereEpreuve='" + monProfesseur.getIdMatiereProfesseur() + '\'');
                        String test = "SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idEleveEpreuve='" + tableauID.get(y) + "' AND idMatiereEpreuve='" + monProfesseur.getIdMatiereProfesseur() + '\'';
                        y++;
                        if(resultat2.first()){
//                            do{
//                                tableauEleve.addElement(resultat2.getInt("noteEpreuve"));
//                                tableauEleve.addElement(resultat2.getInt("coefficientEpreuve"));
//                                if(resultat2.isLast() != true){
//                                    resultat2.next();  
//                                }
//                            }
//                            while(resultat2.isLast() == false);
//                            tableauEleve.addElement(resultat2.getInt("noteEpreuve"));
//                            tableauEleve.addElement(resultat2.getInt("coefficientEpreuve"));
               do{
                  tableauEleve.addElement(resultat2.getInt("noteEpreuve"));
                  tableauEleve.addElement(resultat2.getInt("coefficientEpreuve"));
                  //if(resultat2.isLast() != true)
                       
               }
               while(resultat2.next() == true);
                        }
                        
                        resultat.next();
                        tableauEleve.addElement("null"); 
                    }
               tableauEleve.addElement(resultat.getString("nomPersonne"));
               tableauEleve.addElement(resultat.getString("prenomPersonne"));
               tableauID.addElement(resultat.getInt("idPersonne"));
               
               String requete = "SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idEleveEpreuve='" + tableauID.get(y) + "' AND idMatiereEpreuve='" + monProfesseur.getIdMatiereProfesseur() + '\'';
               resultat2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT noteEpreuve,coefficientEpreuve FROM cdn.epreuve WHERE idEleveEpreuve='" + tableauID.get(y) + "' AND idMatiereEpreuve='" + monProfesseur.getIdMatiereProfesseur() + '\'');
               if(resultat2.first()){
               do{
                  tableauEleve.addElement(resultat2.getInt("noteEpreuve"));
                  tableauEleve.addElement(resultat2.getInt("coefficientEpreuve"));
                  //if(resultat2.isLast() != true)
                       
               }
               while(resultat2.next() == true);
               }       
                    tableauEleve.addElement("null"); 
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

        interfaceProf.getSauvegarder().addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {        
          DefaultTableModel monModel = (DefaultTableModel) interfaceProf.getTableauJTable().get(interfaceProf.getOnglets().getSelectedIndex()).getModel();
          DAOepreuve daoEpreuve = new DAOepreuve();
          for(int i=0;i<monModel.getRowCount();i++){
              if(Integer.parseInt(interfaceProf.getNombreDeNote().elementAt(interfaceProf.getOnglets().getSelectedIndex()).toString()) != 0 || (3+(Integer.parseInt(interfaceProf.getNombreDeNote().elementAt(i).toString())*2)) != monModel.getColumnCount()){
              Epreuve monEpreuve = new Epreuve();
              int idEleve = 0;
              int indexOnglet = interfaceProf.getOnglets().getSelectedIndex();
              while( indexOnglet != 0){
                DefaultTableModel monModelTempon = (DefaultTableModel) interfaceProf.getTableauJTable().get(indexOnglet).getModel();
                idEleve += monModelTempon.getRowCount();
                indexOnglet--;
              }
//              idEleve = (int)tableauID.elementAt(i);
              int idMatiereEpreuve = monProfesseur.getIdMatiereProfesseur();
              int test = 2+(Integer.parseInt(interfaceProf.getNombreDeNote().elementAt(interfaceProf.getOnglets().getSelectedIndex()).toString())*2);
              int test2 = monModel.getColumnCount()-1;
              Vector test3 = interfaceProf.getNombreDeNote();
              for(int y=2+(Integer.parseInt(interfaceProf.getNombreDeNote().elementAt(interfaceProf.getOnglets().getSelectedIndex()).toString())*2);y<monModel.getColumnCount()-1;y++){
                  monEpreuve = new Epreuve((int)tableauID.elementAt(idEleve)+i, idMatiereEpreuve, Integer.parseInt(monModel.getValueAt(i, y).toString()), new Date(1900-1900, 6 -1, 15), Integer.parseInt(monModel.getValueAt(i, y+1).toString()));
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
        public void actionPerformed(ActionEvent e) {
            interfaceProf.dispose();
            GestionLogin interfaceLogin = new GestionLogin();
            
        }
    });
    }
}
