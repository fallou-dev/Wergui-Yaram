<% String APP_ROOT=request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Patients</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div id="entete">Gestion des patients</div>
  <div id="menu">
  
     <ul>
     <li><a href="<%= APP_ROOT  %>/listepatient">Acceuil</a></li>
     <li><a href="<%= APP_ROOT  %>/listepatient">Lister</a></li>
     <li><a href="<%= APP_ROOT  %>/insertpatient">Ajouter</a></li>
     
     </ul>
  </div>
