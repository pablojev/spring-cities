<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp"/>
<div class="row">
	<form action="" method="POST">
	<div class="col-md-offset-3 col-md-6">
		<label for="name">Nazwa miasta</label>
		<input type="text" id="name" name="name" class="form-control" placeholder="Podaj nazwę państwa" value="${country.name}">		
		<button type="submit" class="btn btn-lg btn-success pull-right btn-mt-20">Dodaj państwo</button>
	</div>
	</form>
</div>
<c:import url="../footer.jsp"/>