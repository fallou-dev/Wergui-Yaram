
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 id="titre-principal">Détail de la Prescriptions</h1>
 <div id="corps">

		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>Date Consultation</th>
		    <th>Service</th>	
		    <th>Synthese</th>
		   
		  </tr>
		  		<tr>
		    	  <td><c:out value="${consultation.date_consultation }" /></td>
		    	  <td><c:out value="${consultation.service_nomservice}" /></td>
		    	  <td><c:out value="${consultation.synthese}" /></td>
		  		</tr>
		</table>		
		
		<br><br><br><br><br><br><br>
		<h1>Patient</h1>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>Nom</th>
		    <th>Prenom</th>
		  </tr>
		  		<tr>
		    	  <td><c:out value="${patient.nom_patient }" /></td>
		    	  <td><c:out value="${patient.prenom_patient}" /></td>
		  		</tr>
		</table>		
		
 </div>