<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
</head>
<body>
	<h1>Les collaborateurs de DTA</h1>

	<form class="form-horizontal">

		<!-- Search input-->
		<div class="form-group">
			<label class="col-md-4 control-label" for="searchinput">Rechercher
				un nom ou un prenom qui commence par : </label>
			<div class="col-md-4">
				<input id="searchinput" name="searchinput" placeholder=""
					class="form-control input-md" type="search">
			</div>
		</div>
		<!-- Select Basic -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="selectbasic">Filtrer
				par département</label>
			<div class="col-md-4">
				<select id="selectbasic" name="selectbasic" class="form-control">
					<c:forEach var="depart" items="${listeDepart}">
						<option value="${depart.id}">${depart.nom}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<!-- Button -->
		<div class="form-group">
			<label class="col-md-4 control-label" for="submit"></label>
			<div class="col-md-4">
				<button id="submit" name="submit" class="btn btn-default">Rechercher</button>
			</div>
		</div>
	</form>




	<div class="row">
		<ul>
			<c:forEach var="collab" items="${listeCollabs}">
				<li class="thumbnail col-lg-4 col-md-4 col-sm-4 col-xs-4">
					<div class="row">
						<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 text-center"
							style="font-size: 20px;">${collab.nom} ${collab.prenom}</div>
					</div>
					<div class="row">
						<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 text-center">
							<img src="${collab.photo}" style="width: 50%;">
						</div>
						<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7">
							<strong>Matricule : </strong>${collab.matricule} <br /> <strong>Date
								de Naissance :</strong> ${collab.dateDeNaissance} <br /> <strong>Adresse
								: </strong>${collab.adresse} <br /> <strong>Numéro de sécurité
								sociale : </strong>${collab.numSecuSoc} <br /> <strong>Email :</strong>
								${collab.emailPro} <br /> <strong>Date de création du
								compte :</strong> ${collab.dateHeureCreation} <br /> <strong>Poste
								: </strong>${collab.intitulePoste}<br /> <strong>Département :
							</strong>${collab.departement.nom}
						</div>
					</div>
				</li>
			</c:forEach>

		</ul>
	</div>
</body>
</html>