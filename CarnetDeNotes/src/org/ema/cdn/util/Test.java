<<<<<<< HEAD
package org.ema.cdn.util;

import java.sql.*;
import java.util.*;
public class Test{
    public static void main(String[] args) throws SQLException{
        AccesBDD BDD = new AccesBDD();
        for(int i =0; i<16 ; i++){
            System.out.println(BDD.Requete().elementAt(i));
        }
    }
=======
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
>>>>>>> 58642f4aaff55d99bdbc2f4656e321daddd1ef14
}