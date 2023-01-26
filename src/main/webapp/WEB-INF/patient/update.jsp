<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
 <div id="corps">
<h1 id="titre-principal">Modification d'un utilisateur</h1>
 <form action="" method="post">
   <fieldset>
     <legend>Modification d'un utilisateur</legend>
     <input type="hidden" name="id" value="${medecin.idmedecin }"/>
     
    <label>Prenom</label><br>
    <input type="text" name="prenom" value="${medecin.prenom_medecin }"><br>
    
    <label>Nom</label><br>
    <input type="text" name="nom" value="${medecin.nom_medecin }"><br>
    
    <label>Login</label><br>
    <input type="text" name="email" value="${medecin.email }"><br>
    
    <label>Specialite</label><br>
    <input type="text" name="specialite" value="${medecin.specialite }"><br>
    
    <label>Telephone</label><br>
    <input type="number" name="telephone" value="${medecin.telephone }"><br>
    
    <label>Service</label><br>
    <input type="text" name="service_nom_service" value="${medecin.service_nom_service }"><br>
   
    <label>Passsword</label><br>   
    <input type="password" name="motdepasse" value="${medecin.motdepasse }"><br><br>
    
    <input type="submit" >
  </fieldset>
  </form>
   