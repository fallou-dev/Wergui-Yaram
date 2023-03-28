
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@include file="inc/header.jsp" %>
 <div id="corps">
 <h1 id="titre-principal">Liste des prescriptions</h1>
<c:choose>
	<c:when test="${empty prescriptions }">
		<p>La liste des prescriptions est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>DATE</th>
		    <th>NOTE</th>
		    <th>NOM</th>
		    <th>PRENOM</th>
		    <th colspan="4">Actions</th>
		  </tr>
		  
		  
		  	<c:forEach var="prescription"  items="${prescriptions }">	  
		  <tr>
	
		       <td><c:out value="${prescription.date_prescription }"/></td>
		   		<td><c:out value="${prescription.note}" /></td> 
		   			
		  	<c:forEach var="patient" items="${patients }">
		    	  <td><c:out value="${patient.nom_patient }" /></td>
		    	  <td><c:out value="${patient.prenom_patient}" /></td>
		  	</c:forEach>
		   <td><a href="updateprescription?id=${prescription.idprescription }">Modifier</a>  </td>
		   <td><a href="detailprescription?id=${prescription.consultation_idconsultation }">Detail</a>  </td>
		   <td><a href="Delete?id=${prescription.idprescription }" >Supprimer</a></td>
		  		
		  	</tr>
		  
		  	</c:forEach>
		  
		  
		  	
		</table>		
	</c:otherwise>
</c:choose>

 </div>
  <%@include file="inc/footer.jsp" %>