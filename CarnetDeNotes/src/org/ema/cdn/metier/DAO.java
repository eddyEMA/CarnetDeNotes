/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
/**
 *
 * @author eddy
 */

public abstract class DAO<Type> {
    public Connection connection = AccesBDD.connectionBDD();
    protected ResultSet resultat;
    protected String requeteSQL;
    public abstract Type chercher(int id);
    public abstract boolean creer(Type monObjet);
    public abstract boolean mettreAjour(Type monObjet); //DAO obj
    public abstract boolean supprimer(Type monObjet);
}
