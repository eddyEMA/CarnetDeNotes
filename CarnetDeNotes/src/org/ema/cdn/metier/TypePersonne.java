/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;

/**
 *
 * @author eddy
 */
public class TypePersonne {
    private int idTypePersonne;
    private String libelleTypePersonne;
    public TypePersonne(){
    }
    public TypePersonne(String libelleType){
        this.libelleTypePersonne = libelleType;
    }

    public int getIdTypePersonne() {
        return idTypePersonne;
    }

    public void setIdTypePersonne(int idTypePersonne) {
        this.idTypePersonne = idTypePersonne;
    }

    public String getLibelleTypePersonne() {
        return libelleTypePersonne;
    }

    public void setLibelleTypePersonne(String libelleTypePersonne) {
        this.libelleTypePersonne = libelleTypePersonne;
    }
    
}
