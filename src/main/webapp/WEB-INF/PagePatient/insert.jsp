<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="inc/header.jsp" %><br>
 <div id="corps">
<h1 id="titre-principal">Ajouter Rendez-vous</h1>
   <form action="PrendreRv" method="post">
   <div class="formItem">
    <label>Date</label>
    <input type="date" name="date">
    </div>   
    
    <div class="formItem">
    <label>Nom Service</label>
    <input type="text" name="service">
    </div>
    <div class="formItem">
    <label></label>
    <input type="submit" >
    </div>
  
  </form>  
</div>   
 <%@include file="inc/footer.jsp" %>