<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc/header.jsp" %><br>
 <div id="corps">
<h1 id="titre-principal">Ajouter services</h1>
   <p class="erreur">${statusMessage}</p>

   <form action="insertservice" method="post">
	  
		    <div class="formItem">
		    <label>Nom Service</label>
		    <input type="text" name="nom_service" >
		    <span class="erreur">${erreurs.nom_service}</span>
		    </div>
		    
		    <div class="formItem">
		    <label></label>
		    <input type="submit" >
            </div>
  </form>  
  </div>
    <%@include file="inc/footer.jsp" %>