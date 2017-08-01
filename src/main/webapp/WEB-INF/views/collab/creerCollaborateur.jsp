<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="form-horizontal" method="post" action="">
			<h1>Nouveau Collaborateur</h1>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nom">nom</label>
				<div class="col-md-4 col-md-offset-1">
					<input id="nom" name="nom" placeholder="nom" class="form-control input-md" required="" type="text">
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prenom">prenom</label>
				<div class="col-md-4">
					<input id="prenom" name="prenom" placeholder="prenom" class="form-control input-md" required="" type="text">
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="dateNaissance">date de naissance</label>
				<div class="col-md-4">
					<input id="dateNaissance" name="dateNaissance" placeholder="date de naissance" class="form-control input-md" required="" type="text">
				</div>
			</div>
			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="adresse">adresse</label>
				<div class="col-md-4">
					<textarea class="form-control" id="adresse" name="adresse" required="" ></textarea>
				</div>
			</div>
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="NumSecu">Numéro
					de sécurité sociale</label>
				<div class="col-md-4">
					<input id="NumSecu" name="NumSecu" placeholder="Numéro de sécurité sociale" class="form-control input-md" required="" type="text">
				</div>
			</div>
			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submit"></label>
				<div class="col-md-4">
					<button id="submit" name="submit" class="btn btn-default">Créer</button>
				</div>
			</div>
	</form>
</body>
</html>