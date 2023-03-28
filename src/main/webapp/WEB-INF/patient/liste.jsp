<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@include file="inc/header.jsp" %>
 <div id="corps">
 <h1 id="titre-principal">Liste des patients</h1>
<c:choose>
	<c:when test="${empty patients }">
		<p>La liste des patients est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>Nom</th>
		    <th>prenom</th>
		    <th>Email</th>
		    <th>Telephone</th>
		    
		    <th colspan="4">Actions</th>
		  </tr>
		  	<c:forEach var="patient" items="${patients }">
		  		<tr>
		    	  <td><c:out value="${patient.nom_patient }" /></td>
		    	  <td><c:out value="${patient.prenom_patient }" /></td>
		    	  <td><c:out value="${patient.email }" /></td>
		    	  <td><c:out value="${patient.telephone }" /></td>
		    	  <td> <a href="updatepatient?id=${patient.idpatient }">Modifier</a></td>
		    	  <td><a href="deletepatient?id=${patient.idpatient }">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>
 <%@include file="inc/footer.jsp" %>
