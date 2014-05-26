/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;

/**
 *
 * @author Eddy
 */
public class Matiere {
    private int idMatiere;
    private String libelleMatiere;
    public Matiere(){
    }
    public Matiere(String nomMatiere){
        this.libelleMatiere = nomMatiere;
    }
    public int getIdMatiere() {
        return idMatiere;
    }

    public String getLibelleMatiere() {
        return libelleMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public void setLibelleMatiere(String libelleMatiere) {
        this.libelleMatiere = libelleMatiere;
    }
    
}
