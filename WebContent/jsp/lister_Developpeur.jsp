<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">@import url(css/styles.css);</style>
<title><s:property value="%{getText('developpez.page.lister')}"></s:property>
</title>
</head>
<body>

<center>
<div>
	<s:url action="lister_Developpeur" id="langueFr">
		<s:param name="request_locale">fr</s:param>
	</s:url>
	
	<s:url action="lister_Developpeur" id="langueDe">
		<s:param name="request_locale">de</s:param>
	</s:url>
	
	<s:a href="%{langueFr}"><IMG SRC="./images/pngfr.gif" border="0"></IMG> </s:a>
	<s:a href="%{langueDe}"><IMG SRC="./images/pngde.gif" border="0"></IMG> </s:a>
	
	<center>
		<h2><s:property
			value="%{getText('developpez.message.listedveloppeur')}"></s:property>
		</h2>
	</center>

	<s:if test="%{listDeveloppeurs.size()>0}">
		<table border="1" cellpadding="5" cellspacing="2">
			<tr bgcolor="#DEA254">
				<td><s:text name="developpez.form.identifiant"></s:text></td>
				<td><s:text name="developpez.form.pseudo"></s:text></td>
				<td><s:text name="developpez.form.email"></s:text></td>
				<td><s:text name="developpez.form.codepostal"></s:text></td>
				<td><s:text name="developpez.form.dateinscription"></s:text></td>
				<td><s:text name="developpez.form.iconesupp"></s:text></td>
				
				
				
			</tr>
			<s:iterator value="listDeveloppeurs">		
				<tr>
					<td><s:property value="identifiant" /><br/>
					</td>
					<td><s:property value="pseudo" /><br/>
					</td>
					<td><s:property value="mail" /><br/>
					</td>
					<td><s:property value="codePostal" /><br/>
					</td>
					<td><s:property value="dateInscription" /><br/>
					</td>
					<td align="center"><a href="supprimer1_Developpeur?pseudo=${pseudo}">
						<img src="./images/supprimer.png" border="0"></a></td>
					
				</tr>
			</s:iterator>
		</table>
	</s:if> 
	<s:else>
			<s:text name="developpez.message.listevide"></s:text>
	</s:else>
</div>

<p></p>
<a href="saisir_Developpeur"><s:text name="developpez.lien.ajouter"/></a><br />
<a href="supprimer_Developpeur.action"><s:text name="developpez.lien.supprimer"/></a> <br/>
<a href="rechercher_Developpeur.action"><s:text name="developpez.lien.rechercher"/></a><br/>
<a href="deconnecter_Developpeur.action"><s:text name="developpez.lien.deconnecter"/></a><br/>

<s:debug />
</center>


</body>
</html>