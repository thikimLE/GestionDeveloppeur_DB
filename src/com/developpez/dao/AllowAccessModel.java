package com.developpez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AllowAccessModel extends ModelDAO{

	Connection connection =null;
	ResultSet resultSet = null; 
	
	public boolean authentifier(String login, String password){
		PreparedStatement prepStat = null;
		String laRequete = null;
		
		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM utilisateur WHERE login=? and password=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setString(1, login);
			prepStat.setString(2, password);
			
			resultSet=prepStat.executeQuery();
			
			if (resultSet!=null){
				if (resultSet.next()){
					return true;
				}
			}else
				System.out.println("non authentifié");
			
		}catch(Exception ex){
			System.out.println("erreur dans la requette" + ex);
		}
			return false;
	}

}































