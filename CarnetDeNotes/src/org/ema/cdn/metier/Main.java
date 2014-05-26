/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Eddy
 */
public class Main {
    public static void main(String[] args) {
        DAO<Personne> daoPersonne = new DAOpersonne();
        Personne PersonneTestSelect = daoPersonne.chercher(23);
        System.out.println("Nom personne : " + 
                PersonneTestSelect.getNom() + 
                "\nPrenom : " + 
                PersonneTestSelect.getPrenom() + 
                "\nLogin : " + 
                PersonneTestSelect.getIdentifiantPersonne() +
                "\nDate de naissance : " + 
                PersonneTestSelect.getDateDeNaissancePersonne());
        
//          Date dateDeNaissance = new Date(1900-1900, 6 -1, 15);
//          Personne PersonneTestInsert = new Professeur("Durand", "Jean", dateDeNaissance, "jean.durand", null, 1);
//          daoPersonne.creer(PersonneTestInsert);
//          daoPersonne.supprimer(PersonneTestInsert);
//          PersonneTestInsert.setPrenom("Jeannot");
//          daoPersonne.mettreAjour(PersonneTestInsert);
        
//          DAO<Matiere> daoMatiere = new DAOmatiere();
//          Matiere maMatiereTest = daoMatiere.chercher(5);
//          System.out.println("idMatiere : " + maMatiereTest.getIdMatiere() + "\nLibelle Matiere : " + maMatiereTest.getLibelleMatiere());
//          Matiere maMatiereTestInsert = new Matiere("Java");
//          daoMatiere.creer(maMatiereTestInsert);
//          maMatiereTestInsert.setLibelleMatiere("C++");
//          daoMatiere.mettreAjour(maMatiereTestInsert);
//          daoMatiere.supprimer(maMatiereTestInsert);
        
//        DAO<Epreuve> daoEpreuve = new DAOepreuve();
//        Epreuve monEpreuve = daoEpreuve.chercher(2);
//        Date dateEpreuve = new Date(1900-1900, 6 -1, 15);
//        Epreuve monEpreuveTestInsert = new Epreuve(5, 12, 19, dateEpreuve, 10);
//        daoEpreuve.creer(monEpreuveTestInsert);
//        monEpreuveTestInsert.setCoefficientEpreuve(4);
//        daoEpreuve.mettreAjour(monEpreuveTestInsert);
//        daoEpreuve.supprimer(monEpreuveTestInsert);
        
//        DAO<Classe> daoClasse = new DAOclasse();
//        Classe maClasseTest = daoClasse.chercher(4);
//        Classe maClasseTestInsert = new Classe("2ème", 5);
//        daoClasse.creer(maClasseTestInsert);
//        maClasseTestInsert.setLibelleClasse("1ère");
//        daoClasse.mettreAjour(maClasseTestInsert);
//        daoClasse.supprimer(maClasseTestInsert);
        
          DAO<TypePersonne> daoTypePersonne = new DAOtypePersonne();
          TypePersonne maTypePersonneTest = daoTypePersonne.chercher(2);
          TypePersonne maTypePersonneTestInsert = new TypePersonne("Chien");
          daoTypePersonne.creer(maTypePersonneTestInsert);
          maTypePersonneTestInsert.setLibelleTypePersonne("Chat");
          daoTypePersonne.mettreAjour(maTypePersonneTestInsert);
          daoTypePersonne.supprimer(maTypePersonneTestInsert);
        
    }
}
