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
public class Professeur {
    private int idProfesseur;
    private String nomProfesseur;
    private String prenomProfesseur;

    public int getIdProfesseur() {
        return idProfesseur;
    }

    public String getNomProfesseur() {
        return nomProfesseur;
    }

    public String getPrenomProfesseur() {
        return prenomProfesseur;
    }

    public void setIdProfesseur(int idProfesseur) {
        this.idProfesseur = idProfesseur;
    }

    public void setNomProfesseur(String nomProfesseur) {
        this.nomProfesseur = nomProfesseur;
    }

    public void setPrenomProfesseur(String prenomProfesseur) {
        this.prenomProfesseur = prenomProfesseur;
    }
    
}
