<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@include file="inc/header.jsp" %>
 <div id="corps">
<h1 id="titre-principal">Modification d'un medecin</h1>
 <form action="" method="post">
		    
     <input type="hidden" name="id" value="${medecin.idmedecin }"/>
     
       <div class="formItem">
    <label>Prenom</label>
    <input type="text" name="prenom" value="${medecin.prenom_medecin }">
      </div>
      <div class="formItem">
    <label>Nom</label>
    <input type="text" name="nom" value="${medecin.nom_medecin }">
      </div>
      <div class="formItem">
    <label>Login</label>
    <input type="text" name="email" value="${medecin.email }">
      </div>
      <div class="formItem">
    <label>Specialite</label>
    <input type="text" name="specialite" value="${medecin.specialite }">
      </div>
      <div class="formItem">
    <label>Telephone</label>
    <input type="number" name="telephone" value="${medecin.telephone }">
      </div>
      <div class="formItem">
    <label>Service</label>
    <input type="text" name="service_nom_service" value="${medecin.service_nom_service }">
     </div>
     <div class="formItem">
    <label>Passsword</label> 
    <input type="password" name="motdepasse" value="${medecin.motdepasse }">
      </div>
      <div class="formItem">
      <label></label>
    <input type="submit" >
    </div>
  
  </form>
  </div>
       <%@include file="inc/footer.jsp" %>
