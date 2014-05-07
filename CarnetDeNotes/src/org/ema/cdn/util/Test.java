package org.ema.cdn.util;

import java.sql.*;




public class Test
{



public static void main(String[] args)
{


try
{

Class.forName("com.mysql.jdbc.Driver").newInstance();

}

catch(Exception e)
{
e.printStackTrace();
}

try
{
//Connection conn = DriverManager.getConnection("jdbc:mysql://?user=root[localhost]/[testJDBC]");
Connection conn = DriverManager.getConnection("jdbc:mysql:///");

Statement stat = conn.createStatement();
stat.executeUpdate("testJDBC");
}
catch(SQLException e){
    System.out.println("sql exception");
    while (e!=null){
      System.out.println(e.getErrorCode());
      System.out.println(e.getMessage());
      System.out.println(e.getSQLState());
      e.printStackTrace();
      e=e.getNextException();}
    }
catch(Exception e)
	{
	e.printStackTrace();
	}
}

}