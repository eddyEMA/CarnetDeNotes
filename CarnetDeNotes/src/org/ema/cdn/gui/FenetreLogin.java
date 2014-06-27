/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author eddy
 */
public class FenetreLogin extends Fenetre{
    private Panneau monPanneau;


    public FenetreLogin(){
        this.setTitle("Connexion à l'application Carnet de Note Electronique");
        this.setSize(700,400);
        this.setLocationRelativeTo(null);
        this.setUndecorated(false);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.red);
        monPanneau = new Panneau();
        
        //monPanneau.setBackground(Color.white);
        this.setContentPane(monPanneau);
    }    
    public Panneau getMonPanneau() {
        return monPanneau;
    }
}
