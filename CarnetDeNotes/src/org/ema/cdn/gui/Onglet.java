/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author eddy
 */
public class Onglet {
    JTabbedPane tabbedPane;
    
    public Onglet(int typePersonne){
        if (typePersonne == 1){
            creerOngletProf();
        }else if (typePersonne == 2) {
            creerOngletEleve();
        }else{
            System.out.println("ERROR");
        }
    }
 //------------------------------------------------------------------------------   
    void creerOngletProf(){
        
        TableauProf tabProf = new TableauProf();
        JTable tabProfbis = tabProf.CreerJTableProf();
        JTable tabProfbis2 = tabProf.CreerJTableProf();
        JTable tabProfbis3 = tabProf.CreerJTableProf();
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("INFRES 6", tabProfbis);
        tabbedPane.addTab("INFRES 5", tabProfbis2);
        tabbedPane.addTab("INFRES 4", tabProfbis3);
    }
//------------------------------------------------------------------------------
    void creerOngletEleve(){
        
        TableauEleve tabEleve = new TableauEleve();
        JTable tabElevebis = tabEleve.CreerJTableEleve();
        JTable tabElevebis2 = tabEleve.CreerJTableEleve();
        JTable tabElevebis3 = tabEleve.CreerJTableEleve();
        
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("INFRES 6", tabElevebis);
        tabbedPane.addTab("INFRES 5", tabElevebis2);
        tabbedPane.addTab("INFRES 4", tabElevebis3);
    }
}
