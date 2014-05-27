/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.File;
import java.io.EOFException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.ema.cdn.metier.AccesBDD;

/**
 *
 * @author eddy
 */
public class Panneau extends JPanel { 
    private JButton monBouton = new JButton("Connexion");
  public void paintComponent(Graphics g){
      super.paintComponent(g);
      
      this.setLayout(null);
      monBouton.setBounds(400, 235, 120, 60);
      this.add(monBouton);

      Font font = new Font("Courier", Font.BOLD, 15);
      g.setFont(font);
      g.setColor(Color.black);
      g.drawString("Bonjour, veuillez vous identifier pour accéder à l'application", 150, 50);
      g.drawString("Identifiant  :  ", 300, 120);
      g.drawString("Mot de passe :  ", 300, 170);
      
      JTextArea monTexte = new JTextArea();
      JTextArea monTexteBis = new JTextArea();
      monTexte.setBounds(410,105,150,20);
      monTexteBis.setBounds(410, 155, 150, 20);
      //monTexte.append("  ");
      //monTexte.setBackground(Color.red);
      this.add(monTexte);
      this.add(monTexteBis);
      
//              Connection maConnection = AccesBDD.connectionBDD();
//        ResultSet resultat;
//        Image maPhoto = null;
//        try {
//            resultat = maConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Personne WHERE idPersonne=1");
//            if(resultat.first()){
//                maPhoto = (Image) resultat.getBlob("photoPersonne");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(org.ema.cdn.metier.Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
      try {
          Image img = ImageIO.read(new File("logo.jpg"));
          g.drawImage(img, 50, 90,200,200, this);
      } catch (IOException ex) {
          Logger.getLogger(Panneau.class.getName()).log(Level.SEVERE, null, ex);
      }
      
  }               
}
