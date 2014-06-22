/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;
import java.util.Date;

/**
 *
 * @author Eddy
 */
public class Eleve extends Personne{
    public Eleve(String nomEleve, String prenomEleve, Date datedeNaissanceEleve, String identifiantEleve, String motDePasseEleve, int idMatiereEleve){
        setNom(nomEleve);
        setPrenom(prenomEleve);
        setDateDeNaissancePersonne(datedeNaissanceEleve);
        setIdentifiantPersonne(identifiantEleve);
        setMotDePasse(motDePasseEleve);
        setIdMatiereProfesseur(idMatiereEleve);
        setIdTypePersonne(idMatiereEleve);
    }
}
