/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.ema.cdn.metier.Matiere;

/**
 *
 * @author eddy
 */
public class FenetreEleve extends Fenetre{
    private String nomEleve;
    private String prenomEleve;
    private String classeEleve;
    private JLabel texteNomEleve = new JLabel("Nom : ");
    private JLabel textePrenomEleve = new JLabel("Prenom : ");
    private JLabel texteNomClasse = new JLabel("Classe : ");
    private JButton deconnexion;
    private Vector<JTable> tableauJTable = new Vector<JTable>();
    private Vector<DefaultTableModel> tableauModel = new Vector<DefaultTableModel>();
    private JPanel premierPanel;
    private JPanel deuxiemePanel;
    private JPanel troisiemePanel;
    private Vector<Matiere> tableauMatiere = new Vector<Matiere>();
    private Vector<Vector> tableauNotes = new Vector<Vector>();
    private int compteurMatiere = 0;
    public FenetreEleve(){
        premierPanel = new JPanel();
        deuxiemePanel = new JPanel();
        troisiemePanel = new JPanel();
         
        premierPanel.setLayout(new GridLayout(3,1));
        premierPanel.add(texteNomEleve);    
        premierPanel.add(textePrenomEleve);
        premierPanel.add(texteNomClasse);
    
        deuxiemePanel.add(creationJTabbedPane());
        deconnexion = creationBoutton("Déconnexion"); 
        troisiemePanel.add(deconnexion);

        ajouterPanel(premierPanel, deuxiemePanel, troisiemePanel);
        initialisationFenetre();
    }
  public JTable creationJTable(){
      DefaultTableModel model = new DefaultTableModel();
      JTable monJTable = new JTable(model);
      model.addColumn("Note obtenue");
      model.addColumn("Coefficient épreuve");
      
      if((int)tableauNotes.elementAt(compteurMatiere).elementAt(0) != -1){
      for(int i=0;i<(tableauNotes.elementAt(compteurMatiere).size());i++){
          Object note = tableauNotes.elementAt(compteurMatiere).elementAt(i);
          Object coeff = tableauNotes.elementAt(compteurMatiere).elementAt(i+1);
          model.addRow(new Object[]{tableauNotes.elementAt(compteurMatiere).elementAt(i), tableauNotes.elementAt(compteurMatiere).elementAt(i+1)});
          i++;
      }
      }
//      model.addRow(new Object[]{5,2});
      compteurMatiere ++;
      return monJTable;
  }
  public JScrollPane creationJScrollPane(){
        JScrollPane tableauScrollPane = new JScrollPane(creationJTable());
        return tableauScrollPane;
  }
  public JTabbedPane creationJTabbedPane(){
      JTabbedPane mesOnglets = new JTabbedPane();
      
      for(int i=0;i<tableauMatiere.size();i++){
          mesOnglets.addTab(tableauMatiere.elementAt(i).getLibelleMatiere(),creationJScrollPane());
      }
      return mesOnglets;
  } 
  public JButton creationBoutton(String nomBoutton){
      JButton monBoutton = new JButton(nomBoutton);
      return monBoutton;
  }
  public void initialisationFenetre(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Consultation étudiante");
    this.setSize(700, 600);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  public void ajouterPanel(JPanel premierPanel, JPanel deuxiemePanel, JPanel troisiemePanel){
    this.getContentPane().add(premierPanel, BorderLayout.NORTH);
    this.getContentPane().add(deuxiemePanel, BorderLayout.CENTER);
    this.getContentPane().add(troisiemePanel, BorderLayout.SOUTH);
  }
  public void actulisationText(){
    premierPanel.removeAll();
    
    texteNomEleve = new JLabel("Nom : " + nomEleve);
    textePrenomEleve = new JLabel("Prenom : " + prenomEleve);
    texteNomClasse = new JLabel("Classe : " + classeEleve);
    
    premierPanel.setLayout(new GridLayout(3,1));
    premierPanel.add(texteNomEleve);    
    premierPanel.add(textePrenomEleve);
    premierPanel.add(texteNomClasse);
  }
  public void actulisationOnglet(){
      deuxiemePanel.removeAll();
      deuxiemePanel.add(creationJTabbedPane());
  }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public void setClasseEleve(String classeEleve) {
        this.classeEleve = classeEleve;
    }

    public void setTableauMatiere(Vector<Matiere> tableauMatiere) {
        this.tableauMatiere = tableauMatiere;
    }

    public JButton getDeconnexion() {
        return deconnexion;
    }

    public void setTableauNotes(Vector<Vector> tableauNotes) {
        this.tableauNotes = tableauNotes;
    }
  
}
