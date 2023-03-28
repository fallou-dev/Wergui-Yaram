<% String APP_ROOT=request.getContextPath(); %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body
{
	margin: 0px;
	padding: 0px;
	overflow: hidden;
}
#entete, #menu, #pied, #corps
{
	width: 100%;
	margin: 0px;
	/*overflow: hidden;*/
}
#entete, #menu, #pied, #menu li a
{
	color: white;
	text-align: center;
	background-color: #0080c0;
}
#entete
{
	position: absolute;
	height: 11%;
	left: 0px;
	top: 0px;
	padding: 10px;
	font-size: 3em;
	text-transform: uppercase;
	font-family: "serif";
}
#menu
{
	position: absolute;
	height: 6%;
	left: 0px;
	top: 11%;
	border-top: solid 2px white;
}
#menu ul
{
	margin: 0px;
	padding: 0px;
	height: 100%;
	margin: 0px;
}
#menu li
{
	display: inline-block;
	border-left: solid 2px white;
	padding: 10px;
	height: 100%;
}
#menu li:last-child
{
	border-right: solid 2px white;
}
#menu li a
{
	text-decoration: none;
	font-size: 1.2em;
}
#corps
{
	position: absolute;
	height: 80%;
	left: 0px;
	top: 17%;
	padding: 0px 5px;
	overflow: auto;
	/*border: solid 2px;*/
}
#pied
{
	position: absolute;
	height: 6%;
	left: 0px;
	top: 95%;
	padding-top: 5px;
}
#titre-principal
{
	text-align: center;
	font-family: "serif";
}
table,th,td
{
	border: solid 1px;
	padding: 5px;
}
tr:first-child
{
	border: solid 1px green;
	color: white;
	background-color: black;
}
table
{
	width: fit-content;
	margin: auto;
	border-collapse: collapse;
}
form
{
	width: 50%;
	margin: auto;
}
.formItem
{
	text-align: center;
}
.formItem label
{
	margin: 15px;
	display: inline-block;
	width: 15%;
	text-align: right;
	/*font-weight: bold;*/
	font-size: 1.2em;
}
.formItem input
{
	height: 25px;
	border-color: grey;
	padding: 2px;
	border-radius: 10px;
}
.formItem input[type="submit"]
{
	display: inline-block;
	margin-top: 10px;
	color: white;
	width: 100px;
	height: 30px;
	background-color: #000000;
	border: double 3px grey;
	border-radius: 10px;
}
form
{
	padding: 10px;
	border-radius: 20px;
	border: outset 2px grey;
}
.messageBox
{
	/*margin-left: 25%;*/
	width: 50%;
	margin: auto;
	padding-left: 20px;
	padding-bottom: 20px;
	font-size: 1.2em;
}
.succes
{
	color: green;
}
.erreur
{
	color: red;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Liste des Consultations</title>
<link rel="stylesheet" href="/Wergui-Yaram-br/src/main/webapp/css/style.css">
</head>
<body>
  <div id="entete">Wergui-Yaram</div>
  <div id="menu">
  
     <ul>
     <li><a href="<%= APP_ROOT  %>/Acceuil">Acceuil</a></li>
     <li><a href="<%= APP_ROOT  %>/MesRv">Voir Mes Rendez Vous</a></li>
     <li><a href="<%= APP_ROOT  %>/PrendreRv">Prendre un Rendez Vous</a></li>
     <li><a href="<%= APP_ROOT  %>/MesConsultation">Mes Consultations</a></li>
     <li><a href="<%= APP_ROOT  %>/logout">Deconnexion</a></li>
     </ul>
  </div>
