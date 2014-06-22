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
public class Professeur extends Personne{
    private static final int IDCLASSEELEVE = 20;
    public Professeur(String nomProfesseur, String prenomProfesseur, Date datedeNaissanceProfesseur, String identifiantProfesseur, String motDePasseProfesseur, int idMatiereProfesseur){
        setNom(nomProfesseur);
        setPrenom(prenomProfesseur);
        setDateDeNaissancePersonne(datedeNaissanceProfesseur);
        setIdentifiantPersonne(identifiantProfesseur);
        setMotDePasse(motDePasseProfesseur);
        setIdMatiereProfesseur(idMatiereProfesseur);
        setIdClasseEleve(IDCLASSEELEVE);
        setIdTypePersonne(1);
    }
}
