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

public abstract class DAO {
    public Connection connection = AccesBDD.connectionBDD();
    public abstract Object chercher(int id);
    public abstract Object creer(String nom, String prenom, int typePersonne);
    public abstract Object mettreAjour(int id);
    public abstract Object supprimer(int id);
}
