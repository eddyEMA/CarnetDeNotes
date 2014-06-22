/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;
import java.sql.Connection;
import java.sql.ResultSet;
/**
 *
 * @author eddy
 */

/**
 *
 * @author eddy
 * @param <T>
 */
public abstract class DAO<T> {
    private Connection connection = AccesBDD.connectionBDD();
    private ResultSet resultat;
    private String requeteSQL;
    public abstract T chercher(int id);
    public abstract boolean creer(T monObjet);
    public abstract boolean mettreAjour(T monObjet);
    public abstract boolean supprimer(T monObjet);

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResultat() {
        return resultat;
    }

    public void setResultat(ResultSet resultat) {
        this.resultat = resultat;
    }

    public String getRequeteSQL() {
        return requeteSQL;
    }

    public void setRequeteSQL(String requeteSQL) {
        this.requeteSQL = requeteSQL;
    }
    
}
