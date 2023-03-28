<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="inc/header.jsp" %><br>
 <div id="corps">
<h1 id="titre-principal">Ajouter Consultation</h1>
   <p class="erreur">${statusMessage}</p>

   <form action="insertconsultation" method="post">
	          <div class="formItem">
		    <label>Date Consultation</label>
		    <input type="date" name="date_consultation" >
		    <span class="erreur">${erreurs.consultation}</span>
		    </div>
		     <div class="formItem">
		    <label>Synthese</label>
		    <input type="text" name="synthese">
		    <span class="erreur">${erreurs.synthese}</span>
		    </div>
		     <div class="formItem">
		    <label>Identifiant Medecin</label>
		    <input type="Number" name="medecin_idmedecin">
		    <span class="erreur">${erreurs.medecin_idmedecin }</span>
		    </div>
		     <div class="formItem">
		   	<label>Identifiant Patient</label>
		    <input type="Number" name="patient_idpatient">
		    <span class="erreur">${erreurs.patient_idpatient }</span>
             </div>
              <div class="formItem">
		    <label>Service Concerné</label>
		    <input type="text" name="service_nom_service">
		    <span class="erreur">${erreurs.service_nom_service }</span>
		        </div>
		       <div class="formItem">
		    <label></label> 
		    <input type="submit" >
		    </div>
	
  </form>  
  </div>
   <%@include file="inc/footer.jsp" %>