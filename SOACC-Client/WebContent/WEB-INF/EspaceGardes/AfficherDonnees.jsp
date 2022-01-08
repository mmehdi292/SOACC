<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="css/style2.css" rel="stylesheet"/>
<title>Affichage |TP SOACC</title>
</head>
<body>
<h3>Bienvenue, <c:out value="${sessionScope.user}" /> | <a href ="GardeServlet" class="btn btn-warning">Recharche</a> | <a href="LogoutServlet" class="btn btn-danger">Logout</a></h3>
<h3>Resultant</h3>

<c:choose>
	<c:when test="${type eq 'Matricule'}">
	
	<c:choose>
  <c:when test="${not empty etudiant.getEtudiant().getMatricule()}">
  <div class="table-responsive">
    <table class="table table-hover align-middle responvise">
  <thead>
    <tr>
      <th scope="col">Matricule</th>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">Sexe</th>
      <th scope="col">Date de naissance</th>
      <th scope="col">Prenom de pere</th>
      <th scope="col">Nom de mere</th>
      <th scope="col">Prenom de mere</th>
      <th scope="col">Faculte</th>
      <th scope="col">Departement</th>
      <th scope="col">Formation</th>
      <th scope="col">Niveau</th>
      <th scope="col">Specialite</th>
      <th scope="col">Annee de derniere inscription</th>
    </tr>
  </thead>
  <tbody>
  	
    <tr>
      <td><c:out value="${etudiant.getEtudiant().getMatricule()}"/></td>
      <td><c:out value="${etudiant.getEtudiant().getNom()}"/></td>
      <td><c:out value="${etudiant.getEtudiant().getPrenom()}"/></td>
      <td><c:out value="${etudiant.getEtudiant().getSexe()}"/></td>
      <td><c:out value="${etudiant.getEtudiant().getDateNaissance()}"/></td>
      <td><c:out value="${etudiant.getEtudiant().getPrenomPere()}"/></td>
      <td><c:out value="${etudiant.getEtudiant().getNomMere()}"/></td>
      <td><c:out value="${etudiant.getEtudiant().getPrenomMere()}"/></td>
      <td><c:out value="${etudiant.getFormation().getSpecialite().getDepartement().getFaculte().getNomFaculte()}"/></td>
      <td><c:out value="${etudiant.getFormation().getSpecialite().getDepartement().getNomDepartement()}"/></td>
      <td><c:out value="${etudiant.getFormation().getNomFormation()}"/></td>
      <td><c:out value="${etudiant.getFormation().getNiveau()}"/></td>
      <td><c:out value="${etudiant.getFormation().getSpecialite().getNomSpecialite()}"/></td>
      <td><c:out value="${etudiant.getAnneeDerniereInscription()}"/></td>
    </tr>

  </tbody>
</table>
</div>
  </c:when>
  <c:otherwise>
    Pas d'etudiant avec ce matricle
  </c:otherwise>
</c:choose>
	
	
	</c:when>
	<c:otherwise>
	<c:choose>
  		<c:when test="${not empty etudiants}">
  		<div class="table-responsive">
<table class="table table-hover align-middle responvise">
  <thead>
    <tr>
      <th scope="col">Matricule</th>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">Sexe</th>
      <th scope="col">Date de naissance</th>
      <th scope="col">Prenom de pere</th>
      <th scope="col">Nom de mere</th>
      <th scope="col">Prenom de mere</th>
      <th scope="col">Faculte</th>
      <th scope="col">Departement</th>
      <th scope="col">Formation</th>
      <th scope="col">Niveau</th>
      <th scope="col">Specialite</th>
      <th scope="col">Annee de derniere inscription</th>
    </tr>
  </thead>
  <tbody>
  
  
  	<c:forEach var="value" items="${etudiants}">
  	
  	
  	<tr>
      <td><c:out value="${value.getEtudiant().getMatricule()}"/></td>
      <td><c:out value="${value.getEtudiant().getNom()}"/></td>
      <td><c:out value="${value.getEtudiant().getPrenom()}"/></td>
      <td><c:out value="${value.getEtudiant().getSexe()}"/></td>
      <td><c:out value="${value.getEtudiant().getDateNaissance()}"/></td>
      <td><c:out value="${value.getEtudiant().getPrenomPere()}"/></td>
      <td><c:out value="${value.getEtudiant().getNomMere()}"/></td>
      <td><c:out value="${value.getEtudiant().getPrenomMere()}"/></td>
      <td><c:out value="${value.getFormation().getSpecialite().getDepartement().getFaculte().getNomFaculte()}"/></td>
      <td><c:out value="${value.getFormation().getSpecialite().getDepartement().getNomDepartement()}"/></td>
      <td><c:out value="${value.getFormation().getNomFormation()}"/></td>
      <td><c:out value="${value.getFormation().getNiveau()}"/></td>
      <td><c:out value="${value.getFormation().getSpecialite().getNomSpecialite()}"/></td>
      <td><c:out value="${value.getAnneeDerniereInscription()}"/></td>
    </tr>
    
    
 	</c:forEach>
 	
    
    
  </tbody>
</table>
</div>
  		
  		</c:when>
  		<c:otherwise>
  		Pas d'etudiant avec ce nom
  		</c:otherwise>
  
  </c:choose>
	</c:otherwise>
</c:choose>


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