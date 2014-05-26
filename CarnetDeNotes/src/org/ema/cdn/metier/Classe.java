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
    private int idProfesseurClasse;
    public Classe(){
    }
    public Classe(String libelleClasse, int idProfesseurClasse){
        this.libelleClasse = libelleClasse;
        this.idProfesseurClasse = idProfesseurClasse;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getLibelleClasse() {
        return libelleClasse;
    }

    public void setLibelleClasse(String libelleClasse) {
        this.libelleClasse = libelleClasse;
    }

    public int getIdProfesseurClasse() {
        return idProfesseurClasse;
    }

    public void setIdProfesseurClasse(int idProfesseurClasse) {
        this.idProfesseurClasse = idProfesseurClasse;
    }
    
}
