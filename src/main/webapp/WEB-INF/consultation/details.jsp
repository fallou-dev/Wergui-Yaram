<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div>
   <p class="erreur">${statusMessage}</p>

	   <fieldset style="width:500px">
		    <legend style="height:-20px">Infos Patients</legend>
		    
		    <label>Prenom</label><br>
			<c:out value="${patient.prenom_patient }" /><br><br>
			
		    <label>Nom</label><br>
		    <c:out value="${patient.nom_patient }" /><br><br>
		    
		    <label>Email</label><br>
		    <c:out value="${patient.email }" /><br><br>
		    
		   			    
		    <label>Adresse</label><br>
		    <c:out value="${patient.adresse }" /><br><br>
		    
		    <label>Situation matrimoniale</label><br>
		    <c:out value="${patient.situation_familliale }" /><br><br>
		    
		    
		 
		    <label>Personne à prevenir</label><br>		    
		    <c:out value="${patient.personne_a_prevenir }" /><br><br>
		    
		    
		    <label>Telephone Personne prevenir</label><br>
		    <c:out value="${patient.tel_Personne_a_prevenir }" /><br><br>
		    
	
  </form>  
  </div>