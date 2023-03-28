<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="inc/header.jsp" %><br>
 <div id="corps">
 <h1 id="titre-principal">Détails Patients</h1>
<c:choose>
	<c:when test="${empty patient }">
		<p>Info patients</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>Nom</th>
		    <th>prenom</th>
		   
		  </tr> 
		  		<tr>
		    	  <td><c:out value="${patient.nom_patient }" /></td>
		    	  <td><c:out value="${patient.prenom_patient }" /></td>
		  		</tr>
		  
		</table>		
	</c:otherwise>
</c:choose>

 </div>
  <%@include file="inc/footer.jsp" %>