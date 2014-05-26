/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 *
 * @author eddy
 */
public class Fenetre extends JFrame{
    public Fenetre(){
        this.setTitle("Connexion à l'application Carnet de Note Electronique");
        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        this.setUndecorated(false);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.red);
        Panneau monPanneau = new Panneau();
        monPanneau.setBackground(Color.white);
        this.setContentPane(monPanneau);
        
        this.setVisible(true);
        
    }
}
