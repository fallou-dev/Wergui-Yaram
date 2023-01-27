<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div>
   <p class="erreur">${statusMessage}</p>

   <form action="insertconsultation" method="post">
	   <fieldset style="width:500px">
		    <legend style="height:-20px">Ajout Consultation</legend>
		    <label>Date Consultation</label><br>
		    <input type="date" name="date_consultation" >
		    <span class="erreur">${erreurs.consultation}</span><br><br>
		    
		    <label>Synthese</label><br>
		    <input type="text" name="synthese">
		    <span class="erreur">${erreurs.synthese}</span><br><br>
		    
		    <label>Identifiant Medecin</label><br>
		    <input type="Number" name="medecin_idmedecin">
		    <span class="erreur">${erreurs.medecin_idmedecin }</span><br><br>
		    
		   	<label>Identifiant Patient</label><br>
		    <input type="Number" name="patient_idpatient">
		    <span class="erreur">${erreurs.patient_idpatient }</span><br><br>

		    <label>Service Concerné</label><br>
		    <input type="text" name="service_nom_service">
		    <span class="erreur">${erreurs.service_nom_service }</span><br><br>
		        
		    <input type="submit" >
	  </fieldset>
  </form>  
  </div>