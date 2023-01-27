<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <div>
   <p class="erreur">${statusMessage}</p>

   <form action="insertservice" method="post">
	   <fieldset style="width:500px">
		    <legend style="height:-20px">Ajout service</legend>
		    <label>Nom Service</label><br>
		    <input type="text" name="nom_service" >
		    <span class="erreur">${erreurs.nom_service}</span><br><br>
		   
		    
		    <input type="submit" >
	  </fieldset>
  </form>  
  </div>