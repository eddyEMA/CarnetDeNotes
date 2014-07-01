/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    private final JButton ajouter;
    private final JButton sauvegarder;
    private final JButton deconnexion;
    private final ArrayList<JTable> tableauJTable = new ArrayList<JTable>();
    private final JPanel premierPanel;
    private final JPanel deuxiemePanel;
    private final JPanel troisiemePanel;
    private final JPanel quatriemePanel;
    private ArrayList<Classe> tableauClasse = new ArrayList<Classe>();
    private ArrayList<ArrayList> tableauDeClasseEleve = new ArrayList<ArrayList>();
    private int compteurClasse = 0;
    private JTabbedPane onglets;
    private final ArrayList nombreDeNote = new ArrayList();
    private static final int X3 = 3;
    private static final int SIZEX700 = 700;
    private static final int SIZEY600 = 600;
    private static final String NNULL = "NULL";
    
  public FenetreProfesseur(){
    premierPanel = new JPanel();
    deuxiemePanel = new JPanel();
    troisiemePanel = new JPanel();
    quatriemePanel = new JPanel();
    premierPanel.setLayout(new GridLayout(X3,1));
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
      for(int i=0;i<tableauDeClasseEleve.get(compteurClasse).size();i++){
          nombreNote =0;
          if(tableauDeClasseEleve.get(compteurClasse).get(y).equals(NNULL)){
              y++;
              i++;
          }        
          while(!tableauDeClasseEleve.get(compteurClasse).get(y).equals(NNULL)){
              y++;
              nombreNote ++;
          }
          if (nombreNoteMax < nombreNote){
            nombreNoteMax = nombreNote;
          }
          i+=(nombreNote);
          
      }
      nombreNoteMax = (nombreNoteMax -2)/2;
      nombreDeNote.add(nombreNoteMax);
      for(int i=0;i<nombreNoteMax;i++){
            model.addColumn("Note Epreuve");
            model.addColumn("Note Coefficient"); 
      }

      if(!tableauDeClasseEleve.get(compteurClasse).get(0).equals(NNULL)){
        for(int i=0;i<(tableauDeClasseEleve.get(compteurClasse).size());i++){
              Vector tableau = new Vector();

              while(!tableauDeClasseEleve.get(compteurClasse).get(i).equals(NNULL)){
                  tableau.add(tableauDeClasseEleve.get(compteurClasse).get(i));
                  i++;
              }
              model.addRow(tableau);
        }
      }
      model.addColumn("Moyenne");
      int compteurCoefficient = 0;
      float moyenne = 0;
      for(int k=0;k<model.getRowCount();k++){
        for (int i=2;i<((nombreNoteMax*2)+2);i++){
          if(model.getValueAt(k, i) != null && model.getValueAt(k, i) != null ){
          moyenne += (Integer.parseInt(model.getValueAt(k, i).toString()) * Integer.parseInt(model.getValueAt(k, i+1).toString()));  
          compteurCoefficient += Integer.parseInt(model.getValueAt(k, i+1).toString());
          }
          else{
              compteurCoefficient =0;
          }
          i++;
          
        }
        if(compteurCoefficient != 0){
            moyenne /= compteurCoefficient;
        }
        else{
            moyenne = 0;
        }
        model.setValueAt(moyenne, k, model.getColumnCount()-1);
        moyenne = 0;
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
  public final JTabbedPane creationJTabbedPane(){
      JTabbedPane mesOnglets = new JTabbedPane();
      for(int i=0;i<tableauClasse.size();i++){
          mesOnglets.addTab(tableauClasse.get(i).getLibelleClasse(),creationJScrollPane(i));
      }
      return mesOnglets;
  } 
  public final JButton creationBoutton(String nomBoutton){
      JButton monBoutton = new JButton(nomBoutton);
      return monBoutton;
  }
  public final void initialisationFenetre(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Gestion des elèves");
    this.setSize(SIZEX700, SIZEY600);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  public final void ajouterPanel(JPanel premierPanel, JPanel deuxiemePanel, JPanel troisiemePanel, JPanel quatriemePanel){
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
    
    premierPanel.setLayout(new GridLayout(X3,1));
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
  public void setTableauClasse(ArrayList<Classe> tableauClasse) {
        this.tableauClasse = tableauClasse;
    }
  public void setTableauDeClasseEleve(ArrayList<ArrayList> tableauDeClasseEleve) {
        this.tableauDeClasseEleve = tableauDeClasseEleve;
    }
  public ArrayList<JTable> getTableauJTable() {
        return tableauJTable;
    }
  public JTabbedPane getOnglets() {
        return onglets;
    }   
    public ArrayList getNombreDeNote() {
        return nombreDeNote;
    }
}
