package com.developpez.actions;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.developpez.dao.AllowAccessModel;
import com.opensymphony.xwork2.ActionSupport;

public class AllowAccessAction extends ActionSupport implements SessionAware{


	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private String compte;
	

	private Map<String, Object> session ;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompte() {
		return compte;
	}
	public void setCompte(String compte) {
		this.compte = compte;
	}	
	
	
	public void setSession(Map<String, Object> map){
		this.session=map;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public String authentifier(){

		System.out.println("dans la methode authentifer........");

		String regex = "^(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])[a-zA-Z0-9]{6,24}$";
		
		//Login et password doivent avoir min 6 caractères et max 24. Il doivent comporter
		//des majuscules, Minscules et chiffre
		
		
		if(!login.matches(regex) || !password.matches(regex)){
			addFieldError("login", getText("developpez.message.authentechouee"));
			return "input";
		}
		
		//Login et password doivent avoir min 6 caractères et max 24. Il ne doit pas
		//avoir de caractères speciaux
		String regexCompte = "^[a-zA-Z0-9]{6,24}$";
		if(!compte.matches(regexCompte)){
			addFieldError("compte", getText("developpez.message.compteerrone"));
			return "input";
		}

	
		AllowAccessModel allowAccessModel = new AllowAccessModel ();
		if (allowAccessModel.authentifier(login, password)){ 
			session=getSession();
			
			//Ici on met le compte saisi lors de l'auhtentification
			session.put("compte", compte);
			session.put("allowAccess", "true");
			return "success";
			}
		else
			{
				addFieldError("login", getText("developpez.message.authentechouee"));
				return "input";
			}

	}

	public String deconnecter (){
		System.out.println("dans la méthode deconnecter.......");
		this.session.clear();
		return "success";

	}



}
