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
    private String jourCours;
    private int heureDebutCours;
    private int heureFinCours;
    private int idMatiereCours;
    private int idClasseCours;
    private int idProfesseurCours;
    
    public Cours(){
    }
    public Cours(String jourCours, int heureDebutCours, int heureFinCours, int idMatiereCours, int idClasseCours, int idProfesseurCours){
        this.jourCours = jourCours;
        this.heureDebutCours = heureDebutCours;
        this.heureFinCours = heureFinCours;
        this.idMatiereCours = idMatiereCours;
        this.idClasseCours = idClasseCours;
        this.idProfesseurCours = idProfesseurCours;
    }
    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public String getJourCours() {
        return jourCours;
    }

    public void setJourCours(String jourCours) {
        this.jourCours = jourCours;
    }

    public int getHeureDebutCours() {
        return heureDebutCours;
    }

    public void setHeureDebutCours(int heureDebutCours) {
        this.heureDebutCours = heureDebutCours;
    }

    public int getHeureFinCours() {
        return heureFinCours;
    }

    public void setHeureFinCours(int heureFinCours) {
        this.heureFinCours = heureFinCours;
    }

    public int getIdMatiereCours() {
        return idMatiereCours;
    }

    public void setIdMatiereCours(int idMatiereCours) {
        this.idMatiereCours = idMatiereCours;
    }

    public int getIdClasseCours() {
        return idClasseCours;
    }

    public void setIdClasseCours(int idClasseCours) {
        this.idClasseCours = idClasseCours;
    }

    public int getIdProfesseurCours() {
        return idProfesseurCours;
    }

    public void setIdProfesseurCours(int idProfesseurCours) {
        this.idProfesseurCours = idProfesseurCours;
    }
    
}
