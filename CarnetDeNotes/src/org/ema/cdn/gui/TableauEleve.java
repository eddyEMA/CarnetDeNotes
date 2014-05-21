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
public class TableauEleve {
    
    private final Object[][] dataEleve = new Object[4][4];
    private final String[] titreTabEleve;
    
    public TableauEleve(){
        //dataProf = new Object();
        for(int i=0; i<2;i++){
            dataEleve[i][0]= " ";
            dataEleve[i][1]= " ";
        }
        
        titreTabEleve = new String[] {"Epreuve", "Notes", "Coefficient", "Moyenne classe", "Note minimum", "Note maximale"};
        
    }
//------------------------------------------------------------------------------
    public JTable CreerJTableEleve(){
        
        JTable tabEleve = new JTable(dataEleve, titreTabEleve);
        return tabEleve;
    }
}
