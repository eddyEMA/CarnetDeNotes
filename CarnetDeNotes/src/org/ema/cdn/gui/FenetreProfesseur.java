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

/**
 *
 * @author eddy
 */
public class FenetreProfesseur extends Fenetre{
    private JLabel texteNomProfesseur = new JLabel("Nom Professeur : ");
    private JLabel texteNomMatiere = new JLabel("Matière :");
    private JButton ajouter;
    private JButton sauvegarder;
    private JButton deconnexion;
    private int compteurX = 0;
    private Vector<JTable> tableauJTable = new Vector<JTable>();
     
  public FenetreProfesseur(){
    JPanel premierPanel = new JPanel();
    JPanel deuxiemePanel = new JPanel();
    JPanel troisiemePanel = new JPanel();
    JPanel quatriemePanel = new JPanel();
    creationTableauJTable(3, 30, 3);
    premierPanel.setLayout(new GridLayout(2,1));
    premierPanel.add(texteNomProfesseur);
    
    premierPanel.add(texteNomMatiere);
    
    deuxiemePanel.add(creationJTabbedPane(3, 30, 3));
    
    ajouter = creationBoutton("Ajouter épreuve");
    sauvegarder = creationBoutton("Sauvegarder");
    deconnexion = creationBoutton("Déconnexion");
    
    troisiemePanel.add(ajouter);
    troisiemePanel.add(sauvegarder);  
    quatriemePanel.add(deconnexion);
    

    ajouterPanel(premierPanel, deuxiemePanel, troisiemePanel, quatriemePanel);
    initialisationFenetre();
    
    ajouter.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        //data[compteurX][0] = "EDDY";
            
        tableauJTable.get(0).addColumn(new TableColumn(2));
        tableauJTable.get(0).getTableHeader().resizeAndRepaint(); 
//        for(int i=0;i<10;i++){
////            tableauJTable.get(0).setValueAt(null, i, (tableauJTable.get(0).getColumnCount())-3);
//             tableauJTable.get(0).setValueAt(null, i, tableauJTable.get(0).getColumnModel().getColumnCount()-1);
//        }
        tableauJTable.get(0).setValueAt(null, 1, tableauJTable.get(0).getColumnModel().getColumnCount()-1);
//                .addColumn("Note");
//        for(int i=0;i<40;i++){
//            model.setValueAt(model.getValueAt(i, 2), i, 3);
//        }
//        for(int i=0;i<40;i++){
//            model.setValueAt(null, i, 2);
//        }
//        String nomColonne = model.getColumnName(2);
//        tableauJTable.get(0).getColumnModel().getColumn(2).setHeaderValue(model.getColumnName(3));
//        tableauJTable.get(0).getColumnModel().getColumn(3).setHeaderValue(nomColonne);
//        tableauJTable.get(0).getTableHeader().resizeAndRepaint(); 
        tableauJTable.get(0).getTableHeader().resizeAndRepaint(); 
      }
    });

  }
  Object[][] creationTableau(int ligne, int colone){
      Object[][] monTableau = new Object[ligne][colone];
      for (int i=0;i<ligne;i++){
        monTableau[i][0] = "EDDY";
        monTableau[i][1] = "GHARBI";
        monTableau[i][2] = "CORPORATION";
    }
      return monTableau;
  }
  String[] initialisationTitreTableau(int colone){
    String [] titreTableau = new String[colone];
    titreTableau[0] = "Nom" ;
    titreTableau[1] = "Prenom";
    titreTableau[2] = "Moyenne";
    return titreTableau;
  }
  DefaultTableModel creationModel(int ligne, int colone){
     DefaultTableModel model = new DefaultTableModel(creationTableau(ligne, colone),initialisationTitreTableau(colone));
     return model;
  }
  JTable creationJTable(int ligne, int colone){
      JTable monJTable = new JTable(creationModel(ligne, colone));;
      return monJTable;
  }
  void creationTableauJTable(int nombreOnglet, int ligne, int colone){
      for(int i=0;i<nombreOnglet;i++){
          this.tableauJTable.add(creationJTable(ligne, colone));
      }
  }
  JScrollPane creationJScrollPane(int numeroOnglet, int ligne, int colone){
//    if(numeroOnglet <= tableauJTable.size()){
        JScrollPane tableauScrollPane = new JScrollPane(tableauJTable.get(numeroOnglet));
        return tableauScrollPane;
//    }
//    else{
//        return null;
//    }
  }
  JTabbedPane creationJTabbedPane(int nombreOnglets, int ligne, int colone){
      JTabbedPane mesOnglets = new JTabbedPane();
      for(int i=0;i<nombreOnglets;i++){
          mesOnglets.addTab("Later",creationJScrollPane(i,ligne-i*9, colone));
      }
      return mesOnglets;
  } 
  JButton creationBoutton(String nomBoutton){
      JButton monBoutton = new JButton(nomBoutton);
      return monBoutton;
  }
  void initialisationFenetre(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Gestion des elèves");
    this.setSize(700, 600);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }
  void ajouterPanel(JPanel premierPanel, JPanel deuxiemePanel, JPanel troisiemePanel, JPanel quatriemePanel){
    this.getContentPane().add(premierPanel, BorderLayout.NORTH);
    this.getContentPane().add(deuxiemePanel, BorderLayout.CENTER);
    this.getContentPane().add(troisiemePanel, BorderLayout.SOUTH);
    this.getContentPane().add(quatriemePanel, BorderLayout.EAST); 
  }
}
