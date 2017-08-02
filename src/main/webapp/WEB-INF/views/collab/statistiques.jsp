<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.css'> </c:url>">
</head>
<body>
	<table style="border : 2px solid black; " class="col-lg-10 col-md-10 col-xs-10 col-lg-offset-1 col-md-offset-1 col-xs-offset-1">
		<thead>
			<tr>
				<th style="text-align: center;" class="col-lg-4 col-md-4 col-xs-4">Chemin</th>
				<th style="text-align: center;" class="col-lg-2 col-md-2 col-xs-2">Nombre de visite</th>
				<th style="text-align: center;" class="col-lg-2 col-md-2 col-xs-2">Min (ms)</th>
				<th style="text-align: center;" class="col-lg-2 col-md-2 col-xs-2">Max (ms)</th>
				<th style="text-align: center;" class="col-lg-2 col-md-2 col-xs-2">Moyenne (ms)</th>
			</tr>
		</thead>
		<c:forEach var="stat" items="${listeVisites}">
		<tbody>
			<tr style="text-align: center;">
				<td>${stat.chemin}</td>
				<td>${stat.nbVisites}</td>
				<td>${stat.tempsMin}</td>
				<td>${stat.tempsMax}</td>
				<td>${stat.tempsMoy}</td>
			</tr>
		</tbody>		
		</c:forEach>
	</table>
</body>
</html>