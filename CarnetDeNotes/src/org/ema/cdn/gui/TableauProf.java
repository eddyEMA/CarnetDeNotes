/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.gui;

import javax.swing.JTable;

/**
 *
 * @author Dorian
 */
public class TableauProf {
    
    private final Object[][] dataProf = new Object[4][4];
    private final String[] titreTabProf;
    
    public TableauProf(){
        //dataProf = new Object();
        for(int i=0; i<2;i++){
            dataProf[i][0]= " ";
            dataProf[i][1]= " ";
        }
        
        titreTabProf = new String[] {"Nom", "Prénom", "Epreuve", "Moyenne"};
        
    }
//------------------------------------------------------------------------------
    public JTable CreerJTableProf(){
        
        JTable tabProf = new JTable(dataProf, titreTabProf);
        return tabProf;
    }
}
