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
public class Classe {
    private int idClasse;
    private String libelleClasse;
    private Professeur professeurPrincipal;
    private Eleve effectif[];
    private Cours emploiTemps;
    public int getIdClasse() {
        return idClasse;
    }

    public String getLibelleClasse() {
        return libelleClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public void setLibelleClasse(String libelleClasse) {
        this.libelleClasse = libelleClasse;
    }
    
}
