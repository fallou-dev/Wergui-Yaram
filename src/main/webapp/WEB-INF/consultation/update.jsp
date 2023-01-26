<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
 <div id="corps">
<h1 id="titre-principal">Modification d'une consultation</h1>
 <form action="updateconsultation" method="post">
   <fieldset>
     <legend>Modification d'une consultation</legend>
   
		    <label>Date Consultation</label><br>
		    <input type="date" name="date_consultation" value="${consultation.date_consultation }"><br>
		    
		    <label>Synthese</label><br>
		    <input type="text" name="synthese" value="${consultation.synthese }"><br>
		    <p><p>
		    
		    <label>Identifiant Medecin</label><br>
		    <input type="Number" name="medecin_idmedecin" value="${conultation.idconsultation }"><br>
		    
		   	<label>Identifiant Patient</label><br>
		    <input type="Number" name="patient_idpatient" value="${consultation.patient_idpatient }"><br>

		    <label>Service Concerné</label><br>
		    <input type="text" name="service_nom_service" value="${consultation.service_nomservice }"><br>
		    
		    <c:out value="${conultation.service_nomservice }" /><br><br>    
    <input type="submit" >
  </fieldset>
  </form>