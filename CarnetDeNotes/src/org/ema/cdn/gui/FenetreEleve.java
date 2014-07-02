/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
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
    private final JButton deconnexion;
    private final JPanel premierPanel;
    private final JPanel deuxiemePanel;
    private final JPanel troisiemePanel;
    private ArrayList<Matiere> tableauMatiere = new ArrayList<Matiere>();
    private ArrayList<ArrayList> tableauNotes = new ArrayList<ArrayList>();
    private int compteurMatiere = 0;
    private static final int ROWS = 3;
    private static final int WIDTH2 = 700;
    private static final int HEIGHT2 = 650;
    
    public FenetreEleve(){
        premierPanel = new JPanel();
        deuxiemePanel = new JPanel();
        troisiemePanel = new JPanel();
         
        premierPanel.setLayout(new GridLayout(ROWS,1));
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
      
      if((int)tableauNotes.get(compteurMatiere).get(0) != -1){
      for(int i=0;i<(tableauNotes.get(compteurMatiere).size());i++){
          model.addRow(new Object[]{tableauNotes.get(compteurMatiere).get(i), tableauNotes.get(compteurMatiere).get(i+1)});
          i++;
      }
      }

      compteurMatiere ++;
      return monJTable;
  }
  public JScrollPane creationJScrollPane(){
        JScrollPane tableauScrollPane = new JScrollPane(creationJTable());
        return tableauScrollPane;
  }
  public final JTabbedPane creationJTabbedPane(){
      JTabbedPane mesOnglets = new JTabbedPane();
      
      for(int i=0;i<tableauMatiere.size();i++){
          mesOnglets.addTab(tableauMatiere.get(i).getLibelleMatiere(),creationJScrollPane());
      }
      return mesOnglets;
  } 
  public final JButton creationBoutton(String nomBoutton){
      JButton monBoutton = new JButton(nomBoutton);
      return monBoutton;
  }
  public final void initialisationFenetre(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Consultation étudiante");
    this.setSize(WIDTH2, HEIGHT2);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  public final void ajouterPanel(JPanel premierPanel, JPanel deuxiemePanel, JPanel troisiemePanel){
    this.getContentPane().add(premierPanel, BorderLayout.NORTH);
    this.getContentPane().add(deuxiemePanel, BorderLayout.CENTER);
    this.getContentPane().add(troisiemePanel, BorderLayout.SOUTH);
  }
  public void actulisationText(){
    premierPanel.removeAll();
    
    texteNomEleve = new JLabel("Nom : " + nomEleve);
    textePrenomEleve = new JLabel("Prenom : " + prenomEleve);
    texteNomClasse = new JLabel("Classe : " + classeEleve);
    
    premierPanel.setLayout(new GridLayout(ROWS,1));
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

    public void setTableauMatiere(ArrayList<Matiere> tableauMatiere) {
        this.tableauMatiere = tableauMatiere;
    }

    public JButton getDeconnexion() {
        return deconnexion;
    }

    public void setTableauNotes(ArrayList<ArrayList> tableauNotes) {
        this.tableauNotes = tableauNotes;
    }
}
