<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
 <div id="corps">
<h1 id="titre-principal">Modification d'un utilisateur</h1>
 <form action="updateservice" method="post">
   <fieldset>
     <legend>Modification d'un service</legend>
   
    <label>Nom service</label><br>
    <input type="text" name="nom_service" value="${service.nom_service }"><br>
    
    <input type="submit" >
  </fieldset>
  </form>
   