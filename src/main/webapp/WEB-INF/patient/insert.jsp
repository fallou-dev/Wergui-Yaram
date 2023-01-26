<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div>
   <p class="erreur">${statusMessage}</p>

   <form action="insertpatient" method="post">
	   <fieldset style="width:500px">
		    <legend style="height:-20px">Ajout utilisateur</legend>
		    
		    <label>Prenom</label><br>
		    <input type="text" name="prenom_patient" >
		    <span class="erreur">${error.prenom}</span><br><br>
		    
		    <label>Nom</label><br>
		    <input type="text" name="nom_patient">
		    <span class="erreur">${error.nom}</span><br><br>
		    
		    <label>Email</label><br>
		    <input type="text" name="email">
		    <span class="erreur">${error.email }</span><br><br>
		    
		   	<label>Telephone</label><br>
		    <input type="text" name="telephone">
		    <span class="erreur">${error.telephone }</span><br><br>

		    <label>Date de Naissance</label><br>
		    <input type="text" name="date_de_naissance">
		    <span class="erreur">${error.date_de_naissance }</span><br><br>
		    
		    
		    <label>Sexe</label><br>
		    <input type="text" name="sexe">
		    <span class="erreur">${error.sexe }</span><br><br>
		    
		    <label>Adresse</label><br>
		    <input type="text" name="adresse">
		    <span class="erreur">${error.adresse }</span><br><br>
		    
		    <label>Situation matrimoniale</label><br>
		    <input type="text" name="situation_familliale">
		    <span class="erreur">${error.situation_familliale }</span><br><br>
		    
		    
		 
		    <label>Personne à prevenir</label><br>
		    <input type="text" name="personne_a_prevenir">
		    <span class="erreur">${error.personne_a_prevenir }</span><br><br>
		    
		    
		    <label>Telephone Personne à prevenir</label><br>
		    <input type="text" name="tel_personne_a_prevenir">
		    <span class="erreur">${error.tel_personne_a_prevenir }</span><br><br>
		    
		    
		    <label>Mot de passe </label><br>
		    <input type="password" name="motdepasse" >
		    <span class="erreur">${error.motdepasse }</span><br><br>
		    
		    <label>Confirmation du Passsword</label><br>
		    <input type="password" name="passwordBis">
		    <span class="erreur">${error.passwordBis }</span> <br><br><br>
		    
		    <input type="submit" >
	  </fieldset>
  </form>  
  </div>