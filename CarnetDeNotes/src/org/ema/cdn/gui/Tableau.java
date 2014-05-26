/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JFrame;

/**
 *
 * @author eddy
 */
public class Tableau {
    
    static JTabbedPane ongletProf;
    static JTabbedPane ongletEleve;
    
    public Tableau(){
    
        Object[][] dataEleve = null;
        

        for(int i=0;i<2;i++){
            dataEleve[i][0]= " ";
            dataEleve[i][1]= " ";
        }
        String  titleTabEleve[] = {"Epreuve", "Notes", "Coefficient", "Moyenne classe", "Note minimum", "Note maximale"};
        JTable tabEleve = new JTable(dataEleve, titleTabEleve);
        ongletEleve = new JTabbedPane();
        ongletEleve.addTab("Maths", tabEleve);
        ongletEleve.addTab("Anglais", tabEleve);
        ongletEleve.addTab("Réseaux", tabEleve);
    }
    
//    public static void main(String[] args){
//        
//        JFrame frameProf = new JFrame("Professeur");
//        JFrame frameEleve = new JFrame("Elève");
//        frameProf.add(ongletProf);
//        frameEleve.add(ongletEleve);
//        frameProf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frameEleve.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frameProf.setSize(400,300);
//        frameEleve.setSize(400,300);
//        frameProf.setVisible(true);
//        frameEleve.setVisible(true);
//    }
}
