<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="css/style2.css" rel="stylesheet" />
<title>verfication |TP SOACC</title>
</head>
<body>
	<div>
		<h3>Bienvenue, <c:out value="${sessionScope.user}" /> | <a href="LogoutServlet" class="btn btn-danger">Logout</a></h3>
		<h3>Vérifier infomation des étudiants</h3>
		<div class="alert alert-warning" role="alert">
			<p>Cette interrogation (recherche) peut se faire d’au moins par:</p>
			<p>- Un matricule extrait d’une carte d’étudiant;</p>
			<p>- Un nom et prénom d’une personne;</p>
			<p>- Un nom seulement d’une personne</p>
		</div>
		<c:choose>
			<c:when test="${not empty error}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${error}"></c:out>
				</div>
			</c:when>
		</c:choose>
		<form method="POST" action="GardeServlet">
			<div class="mb-3">
				<label for="Matricule" class="form-label">Matricule</label> <input
					name="matricule" type="number" class="form-control" id="Matricule">
			</div>
			<div class="mb-3">
				<label for="Nom" class="form-label">Nom</label> <input name="nom"
					type="text" class="form-control" id="Nom">
			</div>
			<div class="mb-3">
				<label for="Prénom" class="form-label">Prénom</label> <input
					name="prenom" type="text" class="form-control" id="Prénom">
			</div>
			<button type="submit" class="btn btn-success">Vérifier</button>
		</form>
	</div>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>