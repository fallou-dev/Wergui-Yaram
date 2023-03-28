<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="inc/header.jsp" %><br>
 <div id="corps">
<h1 id="titre-principal">Modification d'une Prescription</h1>
<form action="updateprescription" method="post">

<input type="hidden" name="id" value="${prescription.idprescription }"/>

   <div class="formItem">
		    <label>Date Prescription</label>
		    <input type="date" name="date_prescription" value="${prescription.date_prescription }">
		    </div>
		     <div class="formItem">
		    <label>Note</label>
		    <input type="text" name="note" value="${prescription.note }">
		    </div>
		     <div class="formItem">
		    <label>Idconsultation</label>
		    <input type="Number" name="idconsultation" value="${prescription.consultation_idconsultation  }">
		    </div>
		     
           
		     <div class="formItem">
		     <label></label>
             <input type="submit" >
             </div>
  </form>
</div>

  <%@include file="inc/footer.jsp" %>