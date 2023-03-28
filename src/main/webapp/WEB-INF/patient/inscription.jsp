<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@include file="inc/newheader.jsp" %>
 <div id="corps">
 <h1 id="titre-principal">Inscription patient</h1>
   <p class="erreur">${statusMessage}</p>

   <form action="insertpatient" method="post">
	  
		    <div class="formItem">
		    <label>Prenom</label>
		    <input type="text" name="prenom_patient" >
		    <span class="erreur">${error.prenom}</span>
		    </div>
		    <div class="formItem">
		    <label>Nom</label>
		    <input type="text" name="nom_patient">
		    <span class="erreur">${error.nom}</span>
		    </div>
		    <div class="formItem">
		    <label>Email</label>
		    <input type="text" name="email">
		    <span class="erreur">${error.email }</span>
		    </div>
		    <div class="formItem">
		   	<label>Telephone</label>
		    <input type="text" name="telephone">
		    <span class="erreur">${error.telephone }</span>
</div>
<div class="formItem">
		    <label>Date de Naissance</label>
		    <input type="text" name="date_de_naissance">
		    <span class="erreur">${error.date_de_naissance }</span>
		    </div>
		    <div class="formItem">
		    <label>Sexe</label>
		    <input type="text" name="sexe">
		    <span class="erreur">${error.sexe }</span>
		    </div>
		    <div class="formItem">
		    <label>Adresse</label>
		    <input type="text" name="adresse">
		    <span class="erreur">${error.adresse }</span>
		    </div>
		    <div class="formItem">
		    <label>Situation matrimoniale</label>
		    <input type="text" name="situation_familliale">
		    <span class="erreur">${error.situation_familliale }</span>
		    
		    </div>
		 <div class="formItem">
		    <label>Personne à prevenir</label>
		    <input type="text" name="personne_a_prevenir">
		    <span class="erreur">${error.personne_a_prevenir }</span>
		    </div>
		    <div class="formItem">
		    <label>Telephone Personne à prevenir</label>
		    <input type="text" name="tel_personne_a_prevenir">
		    <span class="erreur">${error.tel_personne_a_prevenir }</span>
		    </div>
		    <div class="formItem">
		    <label>Mot de passe </label>
		    <input type="password" name="motdepasse" >
		    <span class="erreur">${error.motdepasse }</span>
		    </div>
		    <div class="formItem">
		    <label>Confirmation du Passsword</label>
		    <input type="password" name="passwordBis">
		    <span class="erreur">${error.passwordBis }</span> 
		    </div>
		    <div class="formItem">
		    <label></label>
		    <input type="submit" >
	</div>
  </form>  
  </div>
  <%@include file="inc/footer.jsp" %>
