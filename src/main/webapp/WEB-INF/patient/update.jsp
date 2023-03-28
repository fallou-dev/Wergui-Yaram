<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


 <%@include file="inc/header.jsp" %>
 <div id="corps">
<h1 id="titre-principal">Modification d'un patient</h1>
 <form action="" method="post">
  
     <input type="hidden" name="id" value="${patient.idpatient }"/>
     
     <div class="formItem">
    <label>Prenom</label>
    <input type="text" name="prenom" value="${patient.prenom_patient }">
     </div>
    <div class="formItem">
    <label>Nom</label>
    <input type="text" name="nom" value="${patient.nom_patient }">
     </div>
    <div class="formItem">
    <label>Email</label><br>
    <input type="text" name="email" value="${patient.email}">
    </div>
    
    
    <div class="formItem">
    <label>Telephone</label>
    <input type="number" name="telephone" value="${patient.telephone }">
     </div>
    
    <div class="formItem">
    <label></label>
    <input type="submit" >
 </div>
  </form>
  </div>
   <%@include file="inc/footer.jsp" %>
