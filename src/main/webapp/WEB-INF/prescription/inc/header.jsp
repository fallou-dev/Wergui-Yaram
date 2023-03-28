<% String APP_ROOT=request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Prescription</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
  <div id="entete">Gestion des Prescription</div>
  <div id="menu">
  
     <ul>
     <li><a href="<%= APP_ROOT  %>/AcceuilAdmin">Acceuil</a></li>
     <li><a href="<%= APP_ROOT  %>/listeprescription">Lister</a></li>
     
     </ul>
  </div>
