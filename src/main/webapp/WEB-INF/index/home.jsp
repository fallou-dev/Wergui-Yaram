<% String APP_ROOT=request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Acceuil</title>
</head>
<body>
	<h1>Bienvenue dans Wergui Yaram </h1>
	  <div id="entete">Gestion des Medecin</div>
  <div id="menu">
  
     <ul>
     <li><a href="<%= APP_ROOT  %>/loginmedecin">Espace Medecin</a></li>
     <li><a href="<%= APP_ROOT  %>/loginpatient">Espace Patient</a></li>
     </ul>
  </div>
	
</body>
</html>