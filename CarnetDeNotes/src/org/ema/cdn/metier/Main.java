/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ema.cdn.metier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eddy
 */
public class Main {
    public static final void main(String[] args) {
        Connection maConnection = AccesBDD.connectionBDD();
        ResultSet resultat = null;
        try {
            resultat = maConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cdn.Personne WHERE idPersonne=1");
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(resultat != null && maConnection != null){
                    resultat.close();
                    maConnection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAOpersonne.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}