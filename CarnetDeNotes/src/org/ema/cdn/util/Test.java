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
}