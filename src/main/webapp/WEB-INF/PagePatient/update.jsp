<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="inc/header.jsp" %><br>
 <div id="corps">
<h1 id="titre-principal">Modification d'un Rendez-vous</h1>
<form action="miseajourRv" method="post">

<input type="hidden" name="id" value="${rendezvous.idRendezvous }"/>

   <div class="formItem">
		    <label>Date Rendez-vous</label>
		    <input type="date" name="date" value="${rendezvous.date_rv }">
		    </div>
		       
		     <div class="formItem">
		     <label></label>
             <input type="submit" >
             </div>
  </form>
</div>

  <%@include file="inc/footer.jsp" %>