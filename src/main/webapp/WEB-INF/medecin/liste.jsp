<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>

h1 {
	align: center;
	font-family:"Fira Sans", Arial, sans-serif;
	
}

#ref {
	background-color: orange;
}



</style>
<h1 id="titre-principal">Liste des medecins</h1>
 <div id="corps">
<c:choose>
	<c:when test="${empty medecins }">
		<p>La liste est vide</p>
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
		    	  <td> <a id="ref" href="updatemedecin?id=${medecin.idmedecin }">Modifier</a></td>
		    	  <td><a id="ref" href="deleteMedecin?id=${medecin.idmedecin }">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>
