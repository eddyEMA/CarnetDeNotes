/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import javax.swing.JFrame;

/**
 *
 * @author eddy
 */
public class FenetreProfesseur extends Fenetre{
    public FenetreProfesseur(){
//     TableauProf monTab = new TableauProf();
//     this.add(monTab.CreerJTableProf());
     Onglet monOnglet = new Onglet();
     monOnglet.insererTableau("MonPremierOnglet", null);
     this.setSize(700,400);
     this.setLocationRelativeTo(null);
     this.setUndecorated(false);
     this.setResizable(true);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
    }
}
