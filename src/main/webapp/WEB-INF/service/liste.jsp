<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="inc/header.jsp" %>

 <div id="corps">
 <h1 id="titre-principal">Liste des Services</h1>
<c:choose>
	<c:when test="${empty services }">
		<p>La liste des service est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>Nom Service</th>
		    
		    <th colspan="4">Actions</th>
		  </tr>
		  	<c:forEach var="service" items="${services}">
		  		<tr>
		    	  <td><c:out value="${service.nom_service }" /></td>
		    	  <td> <a href="updateservice?id=${service.nom_service }">Modifier</a></td>
		    	  <td><a href="deleteservice?id=${service.nom_service }">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>
  <%@include file="inc/footer.jsp" %>