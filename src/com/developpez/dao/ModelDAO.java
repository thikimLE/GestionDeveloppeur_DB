package com.developpez.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ModelDAO {

	DataSource dataSource = null;
	Connection conn=null;
	
//	public Connection getConnection(){
//		 try  {
//			Context initCtx =   new   InitialContext();
//			Context envCtx = (Context) initCtx.lookup( "java:comp/env"  ) ;
//			DataSource ds  = (DataSource) envCtx.lookup("jdbc/ConnectDB");
//			conn = ds.getConnection();  
//			 
// 
//		}  catch  (NamingException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
//	
//	public void setConnection2 (DataSource dataSource){
//		this.dataSource=dataSource;
//	}

	//Utilisation de la connection via DriverManager ex. HSQLDB 
//	public Connection getConnection1(){
//		try
//		{
//	    // Chargement du pilote ok
//	    Class.forName("org.hsqldb.jdbcDriver");
//		}
//		catch(Exception ex)
//		{
//	    System.out.println(" Erreur pilote de "+ ex.getMessage());
//		}
//		
//		try
//		{        	
//			conn = (Connection) DriverManager.getConnection("jdbc:hsqldb:hsql://localhost","developpez.com","java");
//			
//		}
//		catch(SQLException exc)
//	   {
//		    System.out.println("Erreur de connection " + exc.toString());
//	   }
//
//		return conn;
//	}	
	
	
	
	//Utilisation de la connection via DriverManager ex. mysql
	public Connection getConnection(){
	//public Connection getConnection2(){
		try
		{
	    // Chargement du pilote ok
	    Class.forName("com.mysql.jdbc.Driver");
	    
		}
		catch(Exception ex)
		{
	    System.out.println(" Erreur pilote de "+ ex.getMessage());
		}
		
		try
		{        	
			//conn = DriverManager.getConnection("jdbc:mysql://hostname:port/dbname","username", "password");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd_sdzee","java","SdZ_eE");
		}
		catch(SQLException exc)
	   {
		    System.out.println("Erreur de connection " + exc.toString());
	   }
			 

		return conn;
	}
	
	
	
	
	
	
	
	
}
