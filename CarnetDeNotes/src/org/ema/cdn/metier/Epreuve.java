/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;

import java.util.Date;

/**
 *
 * @author eddy
 */
public class Epreuve {
    private int idEpreuve;
    private int idEleveEpreuve;
    private int idMatiereEpreuve;
    private int noteEpreuve;
    private Date dateEpreuve;
    private int coefficientEpreuve;
    public Epreuve(){   
    }
    public Epreuve(int idEleveEpreuve, int idMatiereEpreuve, int noteEpreuve, Date dateEpreuve, int coefficientEpreuve){
        this.idEleveEpreuve = idEleveEpreuve;
        this.idMatiereEpreuve = idMatiereEpreuve;
        this.noteEpreuve = noteEpreuve;
        this.dateEpreuve = dateEpreuve;
        this.coefficientEpreuve = coefficientEpreuve;
    }

    public int getIdEpreuve() {
        return idEpreuve;
    }

    public void setIdEpreuve(int idEpreuve) {
        this.idEpreuve = idEpreuve;
    }

    public int getIdEleveEpreuve() {
        return idEleveEpreuve;
    }

    public void setIdEleveEpreuve(int idEleveEpreuve) {
        this.idEleveEpreuve = idEleveEpreuve;
    }

    public int getIdMatiereEpreuve() {
        return idMatiereEpreuve;
    }

    public void setIdMatiereEpreuve(int idMatiereEpreuve) {
        this.idMatiereEpreuve = idMatiereEpreuve;
    }

    public int getNoteEpreuve() {
        return noteEpreuve;
    }

    public void setNoteEpreuve(int noteEpreuve) {
        this.noteEpreuve = noteEpreuve;
    }

    public Date getDateEpreuve() {
        return dateEpreuve;
    }

    public void setDateEpreuve(Date dateEpreuve) {
        this.dateEpreuve = dateEpreuve;
    }

    public int getCoefficientEpreuve() {
        return coefficientEpreuve;
    }

    public void setCoefficientEpreuve(int coefficientEpreuve) {
        this.coefficientEpreuve = coefficientEpreuve;
    }
    
}
