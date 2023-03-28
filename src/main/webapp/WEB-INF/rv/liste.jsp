<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



 <%@include file="inc/header.jsp" %>
 <div id="corps">
 <h1 id="titre-principal">Liste des Rendez Vous</h1>
<c:choose>
	<c:when test="${empty rv }">
		<p >La liste des RendezVous est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>Date Rendez Vous</th>
		    <th>ID Patient</th>
		    
		    <th colspan="4">Actions</th>
		  </tr>
		  	<c:forEach var="rve" items="${rv}">
		  		<tr>
		    	  <td><c:out value="${rve.date_rv }" /></td>
		    	  <td><c:out value="${rve.patient_idpatient }" /></td>
		    	  
		    	  <td> <a href="detailRv?id=${rve.patient_idpatient}">Detail Rendez-vous</a></td>
		    	  <td> <a href="updaterv?id=${rve.idRendezvous}">Modifier Rendez-vous</a></td>
		    	  <td><a href="deleteRv?id=${rve.idRendezvous }">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>
<%@include file="inc/footer.jsp" %>