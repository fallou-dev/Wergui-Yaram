<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="inc/header.jsp" %><br>
 <div id="corps">
<h1 id="titre-principal">Detail Consultation</h1>
   <p class="erreur">${statusMessage}</p>

	   
		    <form action="" >
		    
		    <label>Prenom</label><br>
			<c:out value="${patient.prenom_patient }" /><br>
			
		    <label>Nom</label><br>
		    <c:out value="${patient.nom_patient }" /><br>
		    
		    <label>Email</label><br>
		    <c:out value="${patient.email }" /><br>
		    
		   			    
		    <label>Adresse</label><br>
		    <c:out value="${patient.adresse }" /><br>
		    
		    <label>Situation matrimoniale</label><br>
		    <c:out value="${patient.situation_familliale }" /><br>
		    
		 
		    <label>Personne à prevenir</label><br>		    
		    <c:out value="${patient.personne_a_prevenir }" /><br>
		    
		    
		    <label>Telephone Personne prevenir</label><br>
		    <c:out value="${patient.tel_Personne_a_prevenir }" /><br>
		    
	
  </form>  
  </div>
   <%@include file="inc/footer.jsp" %>