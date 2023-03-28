<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@include file="inc/header.jsp" %>
 <div id="corps">
 <h1 id="titre-principal">Ajouter medecin</h1>
   <p class="erreur">${statusMessage}</p>

   <form action="insertmedecin" method="post">
	    <div class="formItem">
		    <label>Prenom</label>
		    <input type="text" name="prenom_medecin" >
		    <span class="erreur">${erreurs.prenom}</span>
		     </div>
		     <div class="formItem">
		    <label>Nom</label>
		    <input type="text" name="nom_medecin">
		    <span class="erreur">${erreurs.nom}</span>
		     </div>
		     <div class="formItem">
		    <label>Email</label>
		    <input type="text" name="email">
		    <span class="erreur">${erreurs.email }</span>
		     </div>
		     <div class="formItem">
		   	<label>Telephone</label>
		    <input type="Number" name="telephone">
		    <span class="erreur">${erreurs.telephone }</span>
           </div>
          <div class="formItem">
		    <label>Specialite</label>
		    <input type="text" name="specialite">
		    <span class="erreur">${erreurs.specialite }</span>
		     </div>
		     <div class="formItem">
		    <label>Nom Service</label>
		    <input type="text" name="service_nom_service">
		    <span class="erreur">${erreurs.service_nom_service }</span>
		     </div>
		    
		     <div class="formItem">
		    <label>Mot de passe </label>
		    <input type="password" name="motdepasse" >
		    <span class="erreur">${erreurs.password }</span>
		     </div>
		     <div class="formItem">
		    <label>Confirmation du Passsword</label>
		    <input type="password" name="passwordBis">
		    <span class="erreur">${erreurs.passwordBis }</span> 
		     </div>
		     
		     <div class="formItem">
		    <label></label>
		    <input type="submit" >
		    </div>

  </form>  
  </div>
    <%@include file="inc/footer.jsp" %>
