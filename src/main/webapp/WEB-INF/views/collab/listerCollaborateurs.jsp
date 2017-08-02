<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs de DTA</h1>
	<!-- Liste des noms -->
	<div class=".row">
	<ul>
		<%
			List<Collaborateur> listeCollabs = (List<Collaborateur>)request.getAttribute("listeCollabs");
			for (Collaborateur col : listeCollabs) {
		%>
		<li class="thumbnail col-lg-4 col-md-4 col-xs-4" >
		Matricule : <%=col.getMatricule()%> <br/>
		Nom Prénom : <%=col.getNom()%> <%=col.getPrenom()%> <br/> 
		Date de Naissance : <%=col.getDateDeNaissance()%> <br/> 
		Adresse : <%=col.getAdresse()%> <br/> 
		Numéro de sécurité sociale : <%=col.getNumSecuSoc()%> <br/> 
		Email : <%=col.getEmailPro()%> <br/> 
		Date de création du compte : <%=col.getDateHeureCreation()%> <br/> 
		<img src=<%=col.getPhoto()%>></li>
		 
		<%
			}
		%>
		
	</ul>
   </div>
</body>
</html>