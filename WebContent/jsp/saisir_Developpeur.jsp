<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">@import url(css/styles.css);</style>
<title>
	<s:property value="%{getText('developpez.page.saisir')}"/>
</title>
</head>
<body>
<center>

	<s:url action="saisir_Developpeur" id="langueFr">
		<s:param name="request_locale">fr</s:param>
	</s:url>
	
	<s:url action="saisir_Developpeur" id="langueDe">
		<s:param name="request_locale">de</s:param>
	</s:url>
	
	<s:a href="%{langueFr}"><IMG SRC="./images/pngfr.gif" border="0"></IMG> </s:a>
	<s:a href="%{langueDe}"><IMG SRC="./images/pngde.gif" border="0"></IMG> </s:a>


	<h2><s:property value="%{getText('developpez.message.bienvenue')}"/></h2>
		
	<s:if test="errorMessages.size()>0">
		<div id="msg_erreur">
			<label><s:property value="%{getText('developpez.erreur.msgerror')}"/></label>
			<s:actionerror/>
		</div>
	</s:if>
	<s:if test="errors.size()>0">
	  <div id="msg_erreur">
		<label><s:property value="%{getText('developpez.erreur.msgerror')}"/></label>
		<s:fielderror/>
	   </div>
	</s:if>
	
		

	<div id="formulaire">
	<p align="right"><a href="deconnecter_Developpeur.action"><s:text name="developpez.lien.deconnecter"/></a></p>
			
			<h5><s:property value="%{getText('developpez.message.saisirdeveloppeur')}"></s:property></h5>
			<s:form method ="post" action="enregistrer_Developpeur">
		
			<s:textfield name="identifiant" id="identifiant"
				         label="%{getText('developpez.form.identifiant')}" labelposition="left">
			</s:textfield>
			
			<s:textfield name="pseudo" id="pseudo"
				         label="%{getText('developpez.form.pseudo')}" labelposition="left">
			</s:textfield>	
			
			<s:textfield name="mail" id="mail" 
				        label="%{getText('developpez.form.email')}" labelposition="left">
			</s:textfield>
			
			<s:textfield name="codePostal" id="codePostal" 
				         label="%{getText('developpez.form.codepostal')}" labelposition="left">
			</s:textfield>
		
			<s:textfield name="dateInscription" id="dateInceription" 
				         label="%{getText('developpez.form.dateinscription')}" labelposition="left">
			</s:textfield>
			
			<s:submit value = "%{getText('developpez.form.submit')}"></s:submit>
		
		</s:form>

	</div>
	<p></p>
		<center>
			<a href="lister_Developpeur.action"><s:text name="developpez.lien.lister"/></a><br/>
			<a href="supprimer_Developpeur.action"><s:text name="developpez.lien.supprimer"/></a><br/>
			<a href="rechercher_Developpeur.action"><s:text name="developpez.lien.rechercher"/></a><br/>
		</center>
	
	<s:debug/>
	</center>
</body>
</html>