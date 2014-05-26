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
public class Personne {
    protected String nom;
    protected String prenom;
    protected int idPersonne;
    protected String identifiantPersonne;
    protected Date dateDeNaissancePersonne;
    protected String motDePasse = null;
    protected int idMatiereProfesseur = -1;
    protected int idClasseEleve = -1;
    protected int idTypePersonne;

    public Personne(){
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getIdentifiantPersonne() {
        return identifiantPersonne;
    }

    public void setIdentifiantPersonne(String identifiantPersonne) {
        this.identifiantPersonne = identifiantPersonne;
    }

    public Date getDateDeNaissancePersonne() {
        return dateDeNaissancePersonne;
    }

    public void setDateDeNaissancePersonne(Date dateDeNaissancePersonne) {
        this.dateDeNaissancePersonne = dateDeNaissancePersonne;
    }
    
    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public int getIdMatiereProfesseur() {
        return idMatiereProfesseur;
    }

    public void setIdMatiereProfesseur(int idMatiereProfesseur) {
        this.idMatiereProfesseur = idMatiereProfesseur;
    }

    public int getIdClasseEleve() {
        return idClasseEleve;
    }

    public void setIdClasseEleve(int idClasseEleve) {
        this.idClasseEleve = idClasseEleve;
    }

    public int getIdTypePersonne() {
        return idTypePersonne;
    }

    public void setIdTypePersonne(int idTypePersonne) {
        this.idTypePersonne = idTypePersonne;
    }
    
}
