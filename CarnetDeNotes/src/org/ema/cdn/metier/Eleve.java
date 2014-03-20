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
public class Eleve {
    private int INE;
    private String nomEleve;
    private String prenomEleve;
    private String dateDeNaissanceEleve;
    private Classe classeEleve;
    
    public int getINE() {
        return INE;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public String getDateDeNaissanceEleve() {
        return dateDeNaissanceEleve;
    }

    public void setINE(int INE) {
        this.INE = INE;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public void setDateDeNaissanceEleve(String dateDeNaissanceEleve) {
        this.dateDeNaissanceEleve = dateDeNaissanceEleve;
    }


    
    
}
