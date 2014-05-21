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
public class Fenetre {
    public Fenetre(){
        JFrame fenetre = new JFrame();
        Onglet classe = new Onglet();
        Onglet matiere = new Onglet();
        
        fenetre.add(classe.tabbedPane);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(400,300);
        fenetre.setVisible(true);
        
        fenetre.add(matiere.tabbedPane);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(400,300);
        fenetre.setVisible(true);
    }
}
