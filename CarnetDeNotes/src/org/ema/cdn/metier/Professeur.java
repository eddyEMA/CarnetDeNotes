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
    public Professeur(String nomProfesseur, String prenomProfesseur, Date datedeNaissanceProfesseur, String identifiantProfesseur, String motDePasseProfesseur, int idMatiereProfesseur){
        this.nom = nomProfesseur;
        this.prenom = prenomProfesseur;
        this.dateDeNaissancePersonne = datedeNaissanceProfesseur;
        this.identifiantPersonne = identifiantProfesseur;
        this.motDePasse = motDePasseProfesseur;
        this.idMatiereProfesseur = idMatiereProfesseur;
        this.idClasseEleve = 20;
        this.idTypePersonne = 1;
    }
}
