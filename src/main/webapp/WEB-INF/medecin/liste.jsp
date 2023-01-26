<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 id="titre-principal">Liste des utilisateurs</h1>
 <div id="corps">
<c:choose>
	<c:when test="${empty medecins }">
		<p>La liste des utilisateurs est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>Nom</th>
		    <th>prenom</th>
		    <th>Service</th>
		    <th>Specialite</th>
		    
		    <th colspan="4">Actions</th>
		  </tr>
		  	<c:forEach var="medecin" items="${medecins }">
		  		<tr>
		    	  <td><c:out value="${medecin.nom_medecin }" /></td>
		    	  <td><c:out value="${medecin.prenom_medecin }" /></td>
		    	  <td><c:out value="${medecin.service_nom_service }" /></td>
		    	  <td><c:out value="${medecin.specialite }" /></td>
		    	  <td> <a href="updatemedecin?id=${medecin.idmedecin }">Modifier</a></td>
		    	  <td><a href="deleteMedecin?id=${medecin.idmedecin }">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>