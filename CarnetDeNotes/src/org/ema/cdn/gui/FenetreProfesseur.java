/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.JTextComponent;
import org.ema.cdn.metier.Classe;

/**
 *
 * @author eddy
 */
public class FenetreProfesseur extends Fenetre{
    private String nomProfesseur;
    private String prenomProfesseur;
    private String matiereProfesseur;
    private JLabel texteNomProfesseur = new JLabel("Nom : ");
    private JLabel textePrenomProfesseur = new JLabel("Prenom : ");
    private JLabel texteNomMatiere = new JLabel("Matière :");
    private JButton ajouter;
    private JButton sauvegarder;
    private JButton deconnexion;
    private int compteurX = 0;
    private Vector<JTable> tableauJTable = new Vector<JTable>();
    private Vector<DefaultTableModel> tableauModel = new Vector<DefaultTableModel>();
    private int nombreColone = 3;
    private JPanel premierPanel;
    private JPanel deuxiemePanel;
    private JPanel troisiemePanel;
    private JPanel quatriemePanel;
    private Vector<Classe> tableauClasse = new Vector<Classe>();
    private Vector<Vector> tableauDeClasseEleve = new Vector<Vector>();
    private int compteurClasse = 0;
    private JTabbedPane onglets;
    private Vector nombreDeNote = new Vector();
  public FenetreProfesseur(){
    premierPanel = new JPanel();
    deuxiemePanel = new JPanel();
    troisiemePanel = new JPanel();
    quatriemePanel = new JPanel();
    premierPanel.setLayout(new GridLayout(3,1));
    premierPanel.add(texteNomProfesseur);
    premierPanel.add(textePrenomProfesseur);
    premierPanel.add(texteNomMatiere);
    
    deuxiemePanel.add(creationJTabbedPane());
    
    ajouter = creationBoutton("Ajouter épreuve");
    sauvegarder = creationBoutton("Sauvegarder");
    deconnexion = creationBoutton("Déconnexion");
    
    troisiemePanel.add(ajouter);
    troisiemePanel.add(sauvegarder);  
    quatriemePanel.add(deconnexion);
    

    
    ajouterPanel(premierPanel, deuxiemePanel, troisiemePanel, quatriemePanel);
    initialisationFenetre();

    

  }

  public JTable creationJTable(){
      DefaultTableModel model = new DefaultTableModel();
      JTable monJTable = new JTable(model);
      model.addColumn("Nom");
      model.addColumn("Prenom");
      int nombreNoteMax = 0;
      int nombreNote;
      int y=0; 
      for(int i=0;i<tableauDeClasseEleve.elementAt(compteurClasse).size();i++){
          nombreNote =0;
          if(tableauDeClasseEleve.elementAt(compteurClasse).elementAt(y) == "null"){
              y++;
              i++;
          }        
          while(tableauDeClasseEleve.elementAt(compteurClasse).elementAt(y) != "null"){
              y++;
              nombreNote ++;
          }
          if (nombreNoteMax < nombreNote){
            nombreNoteMax = nombreNote;
          }
          i+=(nombreNote);
          
      }
      nombreNoteMax = (nombreNoteMax -2)/2;
      nombreDeNote.addElement(nombreNoteMax);
      for(int i=0;i<nombreNoteMax;i++){
            model.addColumn("Note Epreuve");
            model.addColumn("Note Coefficient"); 
      }

      if(tableauDeClasseEleve.elementAt(compteurClasse).elementAt(0) != "null"){
      for(int i=0;i<(tableauDeClasseEleve.elementAt(compteurClasse).size());i++){
            Vector tableau = new Vector();
//            if(tableauDeClasseEleve.elementAt(compteurClasse).elementAt(i) == "null"){
//              i++;
//           }
            while(tableauDeClasseEleve.elementAt(compteurClasse).elementAt(i) != "null"){
                tableau.addElement(tableauDeClasseEleve.elementAt(compteurClasse).elementAt(i));
                i++;
            }
            model.addRow(tableau);
            //i++;
      }
      }
      model.addColumn("Moyenne");
      int compteurCoefficient = 0;
      int Moyenne = 0;
      for(int k=0;k<model.getRowCount();k++){
        for (int i=2;i<((nombreNoteMax*2)+2);i++){
          if(model.getValueAt(k, i) != null && model.getValueAt(k, i) != null ){
          Moyenne += (Integer.parseInt(model.getValueAt(k, i).toString()) * Integer.parseInt(model.getValueAt(k, i+1).toString()));  
          compteurCoefficient += Integer.parseInt(model.getValueAt(k, i+1).toString());
          }
          else{
              compteurCoefficient =0;
          }
          i++;
          
        }
        if(compteurCoefficient != 0){
            Moyenne /= compteurCoefficient;
        }
        else{
            Moyenne = 0;
        }
        model.setValueAt(Moyenne, k, model.getColumnCount()-1);
        Moyenne = 0;
        compteurCoefficient = 0;
      }
      
      compteurClasse ++;
      return monJTable;
  }
  public void creationTableauJTable(){
      for(int i=0;i<tableauClasse.size();i++){
          this.tableauJTable.add(creationJTable());
      }
  }
  public JScrollPane creationJScrollPane(int numeroOnglet){
        JScrollPane tableauScrollPane = new JScrollPane(tableauJTable.get(numeroOnglet));
        return tableauScrollPane;
  }
  public JTabbedPane creationJTabbedPane(){
      JTabbedPane mesOnglets = new JTabbedPane();
      for(int i=0;i<tableauClasse.size();i++){
          mesOnglets.addTab(tableauClasse.elementAt(i).getLibelleClasse(),creationJScrollPane(i));
      }
      return mesOnglets;
  } 
  public JButton creationBoutton(String nomBoutton){
      JButton monBoutton = new JButton(nomBoutton);
      return monBoutton;
  }
  public void initialisationFenetre(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Gestion des elèves");
    this.setSize(700, 600);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  public void ajouterPanel(JPanel premierPanel, JPanel deuxiemePanel, JPanel troisiemePanel, JPanel quatriemePanel){
    this.getContentPane().add(premierPanel, BorderLayout.NORTH);
    this.getContentPane().add(deuxiemePanel, BorderLayout.CENTER);
    this.getContentPane().add(troisiemePanel, BorderLayout.SOUTH);
    this.getContentPane().add(quatriemePanel, BorderLayout.EAST); 
  }
  public void actulisationText(){
    premierPanel.removeAll();
    
    texteNomProfesseur = new JLabel("Nom : " + nomProfesseur);
    textePrenomProfesseur = new JLabel("Prenom : " + prenomProfesseur);
    texteNomMatiere = new JLabel("Matière : " + matiereProfesseur);
    
    premierPanel.setLayout(new GridLayout(3,1));
    premierPanel.add(texteNomProfesseur);    
    premierPanel.add(textePrenomProfesseur);
    premierPanel.add(texteNomMatiere);
  }
  public void actulisationOnglet(){
      deuxiemePanel.removeAll();
      creationTableauJTable();
      onglets = creationJTabbedPane();
      deuxiemePanel.add(onglets);
  }
  public void setNomProfesseur(String nomProfesseur) {
        this.nomProfesseur = nomProfesseur;
    }
  public void setPrenomProfesseur(String prenomProfesseur) {
        this.prenomProfesseur = prenomProfesseur;
    }
  public void setMatiereProfesseur(String matiereProfesseur) {
        this.matiereProfesseur = matiereProfesseur;
    }
  public JButton getAjouter() {
        return ajouter;
    }
  public JButton getSauvegarder() {
        return sauvegarder;
    }
  public JButton getDeconnexion() {
        return deconnexion;
    }
  public void setTableauClasse(Vector<Classe> tableauClasse) {
        this.tableauClasse = tableauClasse;
    }
  public void setTableauDeClasseEleve(Vector<Vector> tableauDeClasseEleve) {
        this.tableauDeClasseEleve = tableauDeClasseEleve;
    }
  public Vector<JTable> getTableauJTable() {
        return tableauJTable;
    }
  public JTabbedPane getOnglets() {
        return onglets;
    }   
    public Vector getNombreDeNote() {
        return nombreDeNote;
    }
  
}
