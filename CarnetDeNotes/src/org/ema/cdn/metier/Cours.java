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
public class Cours {
    private int idCours;
    private String heureDebutCours;
    private String heureFinCours;
    private Matiere matiereCours;
    private Classe classe;
    private Professeur leProfesseur;
    public int getIdCours() {
        return idCours;
    }

    public String getHeureDebutCours() {
        return heureDebutCours;
    }

    public String getHeureFinCours() {
        return heureFinCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public void setHeureDebutCours(String heureDebutCours) {
        this.heureDebutCours = heureDebutCours;
    }

    public void setHeureFinCours(String heureFinCours) {
        this.heureFinCours = heureFinCours;
    }
    
    
}
