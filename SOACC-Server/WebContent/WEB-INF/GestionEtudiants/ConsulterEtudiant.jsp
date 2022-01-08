<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="/WEB-INF/PagesCore/Header.jsp"  />
<h1>La liste des etudiants</h1>
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
<jsp:include page="/WEB-INF/PagesCore/Footer.jsp" />