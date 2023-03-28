<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@include file="inc/header.jsp" %>
 <div id="corps">
 <h1 id="titre-principal">Liste des consultations</h1>
<c:choose>
	<c:when test="${empty consultations }">
		<p>La liste des consultations est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>ID Consultation</th>
		    <th>Date Consultation</th>
		    <th>Synthese</th>
		    <th colspan="4">Actions</th>
		  </tr>
		  	<c:forEach var="consultation" items="${consultations }">
		  		<tr>
		    	  <td><c:out value="${ consultation.idconsultation }" /></td>
		    	  <td><c:out value="${ consultation.date_consultation }" /></td>
		    	  <td><c:out value="${ consultation.synthese }" /></td>
		    	  
		    	  <td> <a href="updateconsultation?id=${consultation.idconsultation }">Modifier</a></td>
		    	  <td><a href="deleteconsultation?id=${consultation.idconsultation }">Supprimer</a></td>
		    	  <td><a href="detailsconsultation?id=${consultation.patient_idpatient }">Detail Du Patient</a></td>
		    	  
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>
 <%@include file="inc/footer.jsp" %>