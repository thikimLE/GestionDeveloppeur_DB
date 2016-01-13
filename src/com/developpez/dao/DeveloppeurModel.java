package com.developpez.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.developpez.beans.*;

public class DeveloppeurModel extends ModelDAO{

	Connection connection =null;
	ResultSet resultSet = null; 
	private ArrayList<Developpeur> allDeveloppeurs = new ArrayList<Developpeur>();

	public int ajouterDeveloppeur(Developpeur developpeur, String compte){

		PreparedStatement prepStat = null;
		String laRequete = null;
		int valErreur = 0;

		try{
			connection = super.getConnection();
			laRequete = "INSERT INTO developpeur (identifiant, pseudo, mail, codePostal, " +
			"dateInscription, compte) VALUES(?,?,?,?,?,?)";
			prepStat = connection.prepareStatement(laRequete);


			prepStat.setInt(1, developpeur.getIdentifiant());
			prepStat.setString(2, developpeur.getPseudo());
			prepStat.setString(3, developpeur.getMail());
			prepStat.setString(4, developpeur.getCodePostal());

			java.sql.Date dateSql = new java.sql.Date(developpeur.getDateInscription().getTime());
			prepStat.setDate(5, dateSql);
			prepStat.setString(6, compte);

			valErreur = prepStat.executeUpdate();

		}catch(Exception ex)
		{
			valErreur = 0;
			System.out.println("Erreur lors del'insertion d'un objet");
			ex.printStackTrace();
		}

		try{
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return valErreur;
	}

	public Developpeur getDeveloppeur(int identifiant,String compte){
		PreparedStatement prepStat = null;
		Developpeur developpeur = null;
		String laRequete = null;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM developpeur WHERE IDENTIFIANT=? and COMPTE=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setInt(1, identifiant);
			prepStat.setString(2, compte);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				if (resultSet.next()){
					developpeur = mapperDeveloppeur(resultSet);

				}
			}else
				System.out.println("Developpeur introuvable dans la base");

		}catch(Exception ex){
			developpeur =null;
			System.out.println("erreur dans la requette" + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return developpeur;
	}
	
	//Rechercher par pseudo en ignorant la casse
	public ArrayList<Developpeur> getDeveloppeurByPseudo(String pseudo,String compte){
		PreparedStatement prepStat = null;
		Developpeur developpeur = null;
		String laRequete = null;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM developpeur WHERE UPPER(PSEUDO) LIKE UPPER(?) and COMPTE=?";
			prepStat =connection.prepareStatement(laRequete);

			prepStat.setString(1, "%"+pseudo+"%");
			prepStat.setString(2, compte);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				while (resultSet.next()){
					developpeur = mapperDeveloppeur(resultSet);
					allDeveloppeurs.add(developpeur);

				}
			}else
				System.out.println("Developpeur introuvable dans la base");

		}catch(Exception ex){
			developpeur =null;
			System.out.println("erreur dans la requette" + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return allDeveloppeurs;
	}
	
	
	public Developpeur mapperDeveloppeur(ResultSet resultSet){
		Developpeur developpeur = new Developpeur();

		try
		{
			if(resultSet.getString("identifiant")==null){
				developpeur.setIdentifiant(0);
			}
			else
			{
				developpeur.setIdentifiant(resultSet.getInt("identifiant"));
			}

			if(resultSet.getString("pseudo")==null){
				developpeur.setPseudo("");
			}
			else
			{
				developpeur.setPseudo(resultSet.getString("pseudo"));
			}

			if(resultSet.getString("mail")==null){
				developpeur.setMail("");
			}
			else
			{
				developpeur.setMail(resultSet.getString("mail"));
			}
			if(resultSet.getString("codePostal")==null){
				developpeur.setCodePostal("");
			}
			else
			{
				developpeur.setCodePostal(resultSet.getString("codePostal"));
			}

			if(resultSet.getString("dateInscription")==null){
				developpeur.setDateInscription(null);
			}
			else
			{
				developpeur.setDateInscription(resultSet.getDate("dateInscription"));
			}



		}catch(Exception ex)
		{
			developpeur = null;
			System.out.println("Erreur lors du mapping des attributs"+ex);
		}
		return developpeur;
	}

	public int supprimerAllDeveloppeur(String compte){

		PreparedStatement prepStat = null;
		String laRequete = null;
		int valErreur = 0;

		try{
			connection = super.getConnection();
			laRequete = "DELETE FROM developpeur WHERE COMPTE=?";
			prepStat = connection.prepareStatement(laRequete);
			prepStat.setString(1, compte);

			valErreur = prepStat.executeUpdate();
		}catch(Exception ex)
		{
			valErreur = 0;
			System.out.println("Erreur lors de l'insertion d'un objet");
			ex.printStackTrace();
		}

		try{
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return valErreur;
	}


	public int supprimerUnDeveloppeur(String pseudo, String compte){

		PreparedStatement prepStat = null;
		String laRequete = null;
		int valErreur = 0;

		try{
			connection = super.getConnection();
			laRequete = "DELETE FROM developpeur WHERE PSEUDO = ? AND COMPTE=?";
			prepStat = connection.prepareStatement(laRequete);
			prepStat.setString(1, pseudo);
			prepStat.setString(2, compte);

			valErreur = prepStat.executeUpdate();
		}catch(Exception ex)
		{
			valErreur = 0;
			System.out.println("Erreur lors de l'insertion d'un objet");
			ex.printStackTrace();
		}

		try{
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return valErreur;
	}
	
	
	
	
	public ArrayList<Developpeur> getAllDeveloppeur(String compte){
		PreparedStatement prepStat = null;
		Developpeur developpeur = null;
		String laRequete = null;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM developpeur where COMPTE=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setString(1, compte);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				while (resultSet.next()){
					developpeur = mapperDeveloppeur(resultSet);
					allDeveloppeurs.add(developpeur);
				}
			}else
				System.out.println("Aucun developpeur dans la base");

		}catch(Exception ex){
			developpeur =null;
			System.out.println("erreur dans la requette " + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return allDeveloppeurs;
	}	


	public boolean isDeveloppeurExist(String pseudo){
		PreparedStatement prepStat = null;
		String laRequete = null;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM developpeur WHERE PSEUDO=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setString(1, pseudo);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				if (resultSet.next()){
					return true;

				}
			}else
				System.out.println("Developpeur introuvable dans la base");

		}catch(Exception ex){
			System.out.println("erreur dans la requette" + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return false;
	}
	
	
	public boolean isDeveloppeurExist(int identifiant){
		PreparedStatement prepStat = null;
		String laRequete = null;
		boolean isExist = false;

		try{
			connection = super.getConnection();
			laRequete = "SELECT * FROM developpeur WHERE IDENTIFIANT=?";
			prepStat =connection.prepareStatement(laRequete);
			prepStat.setInt(1, identifiant);
			resultSet=prepStat.executeQuery();

			if (resultSet!=null){
				if (resultSet.next()){
					isExist = true;

				}
			}

		}catch(Exception ex){
			System.out.println("erreur dans la requette" + ex);
		}

		try{
			resultSet.close();
			prepStat.close();
			connection.close();
		}catch(Exception ex){
			System.out.println("Impossible de fermer un objet");
			ex.printStackTrace();
		}

		return isExist;
	}



}































