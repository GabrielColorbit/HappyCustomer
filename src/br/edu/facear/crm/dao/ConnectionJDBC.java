package br.edu.facear.crm.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionJDBC {
		
	  public Connection connectToDatabaseOrDie()
	  {
		  Connection conn = null;
		    try
		    {
		      Class.forName("org.postgresql.Driver");
		      String url = "jdbc:postgresql://localhost:5432/CRM_Feliz";
		      conn = DriverManager.getConnection(url,"postgres", "123");
		    }
		    catch (ClassNotFoundException e)
		    {
		      e.printStackTrace();
		      System.exit(1);
		    }
		    catch (SQLException e)
		    {
		      e.printStackTrace();
		      System.exit(2);
		    }
		    return conn;
	  }
}