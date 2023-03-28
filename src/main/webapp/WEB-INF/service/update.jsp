<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="inc/header.jsp" %><br>


 <div id="corps">
<h1 id="titre-principal">Modification d'un service</h1>
 <form action="updateservice" method="post">
   <fieldset>
     <div class="formItem">
    <label>Nom service</label>
    <input type="text" name="nom_service" value="${service.nom_service }">
    </div>
    
    <div class="formItem">
    <label></label>
    <input type="submit" >
        </div>
  </fieldset>
  </form>
 <%@include file="inc/footer.jsp" %>