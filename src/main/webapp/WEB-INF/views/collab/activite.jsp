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
				<th class="col-lg-4 col-md-4 col-xs-4">Date & Heure</th>
				<th class="col-lg-8 col-md-8 col-xs-8">Libellé</th>
			</tr>
		</thead>
		<c:forEach var="act" items="${listeActivite}">
		<tbody>
			<tr>
				<td>${act.dateHeure.getDayOfMonth()}/${act.dateHeure.getMonthValue()}/${act.dateHeure.getYear()} ${act.dateHeure.getHour()}:${act.dateHeure.getMinute()}:${act.dateHeure.getSecond()}</td>
				<td>${act.type.libelle} - Matricule : 
				${act.matricule}</td>
			</tr>
		</tbody>		
		</c:forEach>
	</table>
</body>
</html>