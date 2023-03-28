<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@include file="inc/header.jsp" %><br>
 <div id="corps">
<h1 id="titre-principal">Modification d'une consultation</h1>
 <form action="updateconsultation" method="post">
   
            <div class="formItem">
		    <label>Date Consultation</label>
		    <input type="date" name="date_consultation" value="${consultation.date_consultation }">
		    </div>
		     <div class="formItem">
		    <label>Synthese</label>
		    <input type="text" name="synthese" value="${consultation.synthese }">
		    </div>
		     <div class="formItem">
		    <label>Identifiant Medecin</label>
		    <input type="Number" name="medecin_idmedecin" value="${consultation.idconsultation }">
		    </div>
		     <div class="formItem">
		   	<label>Identifiant Patient</label>
		    <input type="Number" name="patient_idpatient" value="${consultation.patient_idpatient }">
             </div>
            <div class="formItem">
		    <label>Service Concerné</label>
		    <input type="text" name="service_nom_service" value="${consultation.service_nomservice }">
		    
		    <c:out value="${conultation.service_nomservice }" />  
		    </div>
		     <div class="formItem">
		     <label></label>
             <input type="submit" >
             </div>
  </form>
</div>

  <%@include file="inc/footer.jsp" %>