package org.ema.cdn.util;

import java.sql.*;

public class Test{
    public static void main(String[] args) throws SQLException{
        AccesBDD BDD = new AccesBDD();
        BDD.AfficheRequete();
        int nombreResultat = BDD.NombreLignes();
        System.out.println("\n\nNombre de resultat trouvé : " + nombreResultat);
        BDD.NombreLignes();
    }
}