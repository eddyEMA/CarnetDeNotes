/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author eddy
 */
public class Panneau extends JPanel { 
  private final JButton monBouton = new JButton("Connexion");
  private final JTextField monTexte = new JTextField();
  private final JPasswordField monTexteBis = new JPasswordField();
  private static final int X400 = 400;
  private static final int Y235 = 235;
  private static final int WIDTH120 = 120;
  private static final int HEIGHT60 = 60;
  private static final int SIZE = 15;
  private static final int X150 = 150;
  private static final int Y50 = 50;
  private static final int X300 = 300;
  private static final int Y120 = 120;
  private static final int Y170 = 170;
  private static final int Y20 = 20;
  private static final int X409 = 409;
  private static final int X410 = 410;
  private static final int X105 = 105;
  private static final int X155 = 155;
  private static final int X200 = 200;
  private static final int X90 = 90;
  
  @Override
  public void paintComponent(Graphics g){
      initiliase(g);
  }
  void initiliase(Graphics g){
            super.paintComponent(g);
      
      this.setLayout(null);
      monBouton.setBounds(X400, Y235, WIDTH120, HEIGHT60);
      this.add(monBouton);

      Font font = new Font("Courier", Font.BOLD, SIZE);
      g.setFont(font);
      g.setColor(Color.black);
      g.drawString("Bonjour, veuillez vous identifier pour accéder à l'application", X150, Y50);
      g.drawString("Identifiant  :  ", X300, Y120);
      g.drawString("Mot de passe :  ", X300, Y170);

      monTexte.setBounds(X409,X105,X150,Y20);
      monTexteBis.setBounds(X410, X155, X150, Y20);
      monTexte.setBorder(BorderFactory.createBevelBorder(1));
      monTexteBis.setBorder(BorderFactory.createBevelBorder(1));
      
      this.add(monTexte);
      this.add(monTexteBis);
      
      try {
          Image img = ImageIO.read(new File("logo.jpg"));
          g.drawImage(img, Y50, X90,X200,X200, this);
      } catch (IOException ex) {
          Logger.getLogger(Panneau.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  public JButton getMonBouton(){
      return this.monBouton;
  }

    public JTextField getMonTexte() {
        return monTexte;
    }

    public JPasswordField getMonTexteBis() {
        return monTexteBis;
    }
}
