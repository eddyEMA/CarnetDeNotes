/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import org.ema.cdn.util.AccesBDD;
/**
 *
 * @author eddy
 */
public class Tableau extends JFrame {

  public Tableau(){
//    this.setLocationRelativeTo(null);
//    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    this.setTitle("INFRES 6");
//    this.setSize(500, 500);
//
//    //Les données du tableau
//    Object[][] data = {
//      {"Cysboy", "28 ans", "1.80 m", "1.80 m"},
//      {"BZHHydde", "28 ans", "1.80 m", "1.80 m"},
//      {"IamBow", "24 ans", "1.90 m", "1.80 m"},
//      {"FunMan", "32 ans", "1.85 m", "1.80 m"}
//    };
//    for (int i=0;i<4;i++){
//        data[i][0]= recupNom(i);
//        data[i][1]= recupPrenom(i);
//        data[i][2]= recupNoteEleve(i);
//        data[i][3]= "NOT YET";
//        
//    }
//
//    //Les titres des colonnes
//    String  title[] = {"Nom", "Prenom", "Note", "Moyenne"};
//    JTable tableau = new JTable(data, title);
//    //Nous ajoutons notre tableau à notre contentPane dans un scroll
//    //Sinon les titres des colonnes ne s'afficheront pas !
//    this.getContentPane().add(new JScrollPane(tableau));

  }   
//public String recupNom(int index){
//    AccesBDD bdd = new AccesBDD();
//    String nom = "ERROR";
//      try {
//          nom = (String) bdd.requeteNom().elementAt(index);
//      } catch (SQLException ex) {
//          Logger.getLogger(Tableau.class.getName()).log(Level.SEVERE, null, ex);
//      }
//      return nom;
//}
//public String recupPrenom(int index){
//    AccesBDD bdd = new AccesBDD();
//    String prenom = "ERROR";
//      try {
//          prenom = (String) bdd.requetePrenom().elementAt(index);
//      } catch (SQLException ex) {
//          Logger.getLogger(Tableau.class.getName()).log(Level.SEVERE, null, ex);
//      }
//      return prenom;
//}
//public int recupNoteEleve(int index){
//    AccesBDD bdd = new AccesBDD();
//    int note = -1;
//      try {
//          note =  (int)bdd.requeteNoteEleve().elementAt(index);
//      } catch (SQLException ex) {
//          Logger.getLogger(Tableau.class.getName()).log(Level.SEVERE, null, ex);
//      }
//      return note;
//}
//  static void addIt(JTabbedPane tabbedPane, String text) {
//    JLabel label = new JLabel(text);
//    JButton button = new JButton(text);
//    JPanel panel = new JPanel();
//    panel.add(label);
//    panel.add(button);
//    tabbedPane.addTab(text, panel);
//  }

  public static void main(String[] args){

//--------------------CREATION DU TABLEAU DE DONNEES----------------------------
    Object[][] data = {
      {"Cysboy", "28 ans", "1.80 m", "1.80 m"},
      {"BZHHydde", "28 ans", "1.80 m", "1.80 m"},
      {"IamBow", "24 ans", "1.90 m", "1.80 m"},
      {"FunMan", "32 ans", "1.85 m", "1.80 m"}
    };
    for (int i=0;i<4;i++){
        data[i][0]= "NOT YET";
        data[i][1]= "NOT YET";
        data[i][2]= "NOT YET";
        data[i][3]= "NOT YET";
        
    }
    String  title[] = {"Nom", "Prenom", "Note", "Moyenne"};
    
    JTable tableau = new JTable(data, title);
    JTable tableau2 = new JTable(data, title);
    JTable tableau3 = new JTable(data, title);
    
//---------------------CREATION DE L'ONGLET-------------------------------------   
    JTabbedPane jtp = new JTabbedPane();
    jtp.addTab("INFRES 6", tableau);
    jtp.addTab("INFRES 5", tableau2);
    jtp.addTab("INFRES 4", tableau3);
    
//---------------------CREATION DE LA FRAME-------------------------------------
    JFrame frame = new JFrame("Professeur");
    frame.add(jtp);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);
    frame.setVisible(true);
          
  }   
}
