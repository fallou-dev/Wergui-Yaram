<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="inc/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes Rendez Vous</title>
</head>
<body>
	 <div id="corps">
 <h1 id="titre-principal">Liste des Rendez Vous</h1>
<c:choose>
	<c:when test="${empty rv }">
		<p >La liste des RendezVous est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>Date Rendez Vous</th>
		    
		    <th colspan="4">Actions</th>
		  </tr>
		  	<c:forEach var="rve" items="${rv}">
		  		<tr>
		    	  <td><c:out value="${rve.date_rv }" /></td>
		 
		    	  <td> <a href="miseajourRv?id=${rve.idRendezvous}">Modifier Rendez-vous</a></td>
		    	  <td><a href="SupprimerRv?id=${rve.idRendezvous }">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>
</body>
</html>