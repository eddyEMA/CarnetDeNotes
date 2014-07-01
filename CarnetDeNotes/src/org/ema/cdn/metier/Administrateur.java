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
public class Administrateur extends Personne{
    private static final int IDCLASSEELEVE = 20;
    private static final int IDCLASSEPROFESSEUR = 20;
    private static final int IDTYPEPERSONNE = 3;
    public Administrateur(String nomProfesseur, String prenomProfesseur, Date datedeNaissanceProfesseur, String identifiantProfesseur, String motDePasseProfesseur){
        setNom(nomProfesseur);
        setPrenom(prenomProfesseur);
        setDateDeNaissancePersonne(datedeNaissanceProfesseur);
        setIdentifiantPersonne(identifiantProfesseur);
        setMotDePasse(motDePasseProfesseur);
        setIdMatiereProfesseur(IDCLASSEPROFESSEUR);
        setIdClasseEleve(IDCLASSEELEVE);
        setIdTypePersonne(IDTYPEPERSONNE);
    }
}
