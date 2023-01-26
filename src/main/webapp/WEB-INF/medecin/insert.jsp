<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div>
   <p class="erreur">${statusMessage}</p>

   <form action="insertmedecin" method="post">
	   <fieldset style="width:500px">
		    <legend style="height:-20px">Ajout utilisateur</legend>
		    <label>Prenom</label><br>
		    <input type="text" name="prenom_medecin" >
		    <span class="erreur">${erreurs.prenom}</span><br><br>
		    
		    <label>Nom</label><br>
		    <input type="text" name="nom_medecin">
		    <span class="erreur">${erreurs.nom}</span><br><br>
		    
		    <label>Email</label><br>
		    <input type="text" name="email">
		    <span class="erreur">${erreurs.email }</span><br><br>
		    
		   	<label>Telephone</label><br>
		    <input type="Number" name="telephone">
		    <span class="erreur">${erreurs.telephone }</span><br><br>

		    <label>Specialite</label><br>
		    <input type="text" name="specialite">
		    <span class="erreur">${erreurs.specialite }</span><br><br>
		    
		    <label>Nom Service</label><br>
		    <input type="text" name="service_nom_service">
		    <span class="erreur">${erreurs.service_nom_service }</span><br><br>
		    
		    
		    <label>Mot de passe </label><br>
		    <input type="password" name="motdepasse" >
		    <span class="erreur">${erreurs.password }</span><br><br>
		    
		    <label>Confirmation du Passsword</label><br>
		    <input type="password" name="passwordBis">
		    <span class="erreur">${erreurs.passwordBis }</span> <br><br><br>
		    
		    <input type="submit" >
	  </fieldset>
  </form>  
  </div>