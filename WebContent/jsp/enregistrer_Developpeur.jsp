<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">@import url(css/styles.css);</style>
<title>
	<s:text name="developpez.pages.infos"/>
</title>	
</head>
<body>
	<center><div>
	<s:url action="saisir_Developpeur" id="langueFr">
		<s:param name="request_locale">fr</s:param>
	</s:url>
	
	<s:url action="saisir_Developpeur" id="langueDe">
		<s:param name="request_locale">de</s:param>
	</s:url>
	
	<s:a href="%{langueFr}"><IMG SRC="./images/pngfr.gif" border="0"></IMG> </s:a>
	<s:a href="%{langueDe}"><IMG SRC="./images/pngde.gif" border="0"></IMG> </s:a>
		<center><h2>
			<s:text name="developpez.message.bienvenue"/>
		</h2></center>
		
		<p></p>

		<s:if test="actionMessages.size()>0">
		   <div id="msg_infos">
				<ul> <s:actionmessage/></ul>
		    </div>
		</s:if>
		
		
		<h3><s:text name="devellopez.message.infosdeveloppeur"/></h3>
		
		<b><s:text name="developpez.form.identifiant"/> :</b>  
		<s:property value ="identifiant"/><br/>	
		
		<b><s:text name="developpez.form.pseudo"/></b>  :
		<s:property value = "pseudo"/><br/>
		
		<b><s:text name="developpez.form.email"/></b> :
		<s:property value ="mail"/><br/>
		
		<b><s:text name="developpez.form.codepostal"/></b> :
		<s:property value ="codePostal"/><br/>
		
		<b><s:text name="developpez.form.dateinscription"/></b> :
		<s:property value="dateInscription"/><br/>
		<p></p>
		<a href="saisir_Developpeur.action"><s:text name="developpez.lien.ajouter"/></a>
		<a href="lister_Developpeur.action"><s:text name="developpez.page.lister"/></a>
		<a href="deconnecter_Developpeur.action"><s:text name="developpez.lien.deconnecter"/></a>
		
		
	</div>
	<s:debug/>
	</center>
	
</body>
</html>