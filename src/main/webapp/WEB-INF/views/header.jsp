<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>MiastaWidokowe.pl</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
		<link rel="stylesheet" href="<c:url value='/css/style.css'/>">
	</head>
	<body>
		<div class="container">
		<nav class="navbar navbar-inverse">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="<c:url value='/'/>">MiastaWidokowe.pl</a>
		      <ul class="nav navbar-nav">
		      	<li class="dropdown">
		      		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Miasta <span class="caret"></span></a>
		      		<ul class="dropdown-menu">
		      			<li><a href="<c:url value='/city/add'/>"><i class="glyphicon glyphicon-plus"></i> Dodaj</a></li>
		      			<li><a href="<c:url value='/city/all'/>"><i class="glyphicon glyphicon-th-list"></i> Przeglądaj</a></li>
		      		</ul>	
	      		</li>
	      		<li class="dropdown">
		      		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Zdjęcia <span class="caret"></span></a>
		      		<ul class="dropdown-menu">
		      			<li><a href="<c:url value='/image/add'/>"><i class="glyphicon glyphicon-plus"></i> Dodaj</a></li>
		      			<li><a href="<c:url value='/image/all'/>"><i class="glyphicon glyphicon-th"></i> Przeglądaj</a></li>
		      		</ul>	
	      		</li>
	      		<li class="dropdown">
		      		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Państwa <span class="caret"></span></a>
		      		<ul class="dropdown-menu">
		      			<li><a href="<c:url value='/country/add'/>"><i class="glyphicon glyphicon-plus"></i> Dodaj</a></li>
		      			<li><a href="<c:url value='/country/all'/>"><i class="glyphicon glyphicon-th"></i> Przeglądaj</a></li>
		      		</ul>	
	      		</li>
	      		<li class="dropdown">
		      		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Atrakcje <span class="caret"></span></a>
		      		<ul class="dropdown-menu">
		      			<li><a href="<c:url value='/attraction/add'/>"><i class="glyphicon glyphicon-plus"></i> Dodaj</a></li>
		      			<li><a href="<c:url value='/attraction/all'/>"><i class="glyphicon glyphicon-th"></i> Przeglądaj</a></li>
		      		</ul>	
	      		</li>
		      </ul>
		  	</div>
		</nav>
		