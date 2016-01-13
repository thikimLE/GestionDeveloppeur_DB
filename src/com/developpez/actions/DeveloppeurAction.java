package com.developpez.actions;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.developpez.beans.Developpeur;
import com.developpez.dao.DeveloppeurModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.profiling.UtilTimerStack;

public class DeveloppeurAction extends ActionSupport implements SessionAware{

	//D�finir Session
	private static final long serialVersionUID = 1L;

	private int identifiant;
	private String pseudo;
	private String mail;
	private String codePostal;
	private java.util.Date dateInscription;

	private ArrayList<Developpeur> listDeveloppeurs = new ArrayList<Developpeur>();
	
	private Map<String, Object> session ;
	
	

	public int getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCodePostal(){
		return codePostal;
	}

	public void setCodePostal(String codePostal){
		this.codePostal=codePostal;
	}
	public java.util.Date getDateInscription() {
		return dateInscription;
	}


	public void setDateInscription(java.util.Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public ArrayList<Developpeur> getListDeveloppeurs (){
		return listDeveloppeurs;
	}


	public String enregistrer() {

		System.out.println("dans la méthode enregistrer()......");
		
		UtilTimerStack.setActive(true);
		
		DeveloppeurModel developpeurModel = new DeveloppeurModel();
		
		boolean isExist = developpeurModel.isDeveloppeurExist(identifiant);
		
		if (isExist)
		{
			addFieldError("identifiant", getText("developpez.message.identifiant.existedeja") );
			return "input";
		}
		
		Developpeur developpeur = new Developpeur ();
		developpeur.setIdentifiant(identifiant);
		developpeur.setPseudo(pseudo);
		developpeur.setMail(mail);
		developpeur.setCodePostal(codePostal);
		developpeur.setDateInscription(dateInscription);

		
		String leCompte = (String) session.get("compte");
		developpeurModel.ajouterDeveloppeur(developpeur, leCompte);
		return "success";

	}

	public String lister(){
		System.out.println("dans la méthode lister().....");
		
		UtilTimerStack.setActive(true);
		DeveloppeurModel developpeurModel = new DeveloppeurModel();
		String leCompte = (String) session.get("compte");
		listDeveloppeurs =  developpeurModel.getAllDeveloppeur(leCompte);

		return "success";
	}

	public String supprimerAll(){
		System.out.println("dans la méthode supprimer().....");
		UtilTimerStack.setActive(true);
		DeveloppeurModel developpeurModel = new DeveloppeurModel();
		String leCompte = (String) session.get("compte");
		developpeurModel.supprimerAllDeveloppeur(leCompte);

		return "success";
	}

	public String supprimer1(){
		System.out.println("dans la méthode supprimer un Développeur().....");
		
		UtilTimerStack.setActive(true);
		DeveloppeurModel developpeurModel = new DeveloppeurModel();
		String leCompte = (String) session.get("compte");
		developpeurModel.supprimerUnDeveloppeur(pseudo,leCompte);

		return "success";
	}
	
	
	
	
	public String rechercher(){
		System.out.println("dans la méthode rechercher().....");

		DeveloppeurModel developpeurModel = new DeveloppeurModel();
		String leCompte = (String) session.get("compte");
		listDeveloppeurs =  developpeurModel.getDeveloppeurByPseudo(pseudo, leCompte);

		return "success";
	}

	public void setSession(Map<String, Object> map) {
		this.session=map;
		
	}



}















