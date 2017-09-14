<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp"/>
<div class="row">
	<div class="col-md-offset-3 col-md-6">
	<c:choose>
	<c:when test="${cities.size() == 0}">
	<div class="alert alert-info">
		<strong>Informacja</strong>
		Musisz najpierw dodać miasto, aby móc dodać obrazek.
		</div>
	</c:when>
	<c:otherwise>
	<form action="" method="POST">
	<label for="name">Nazwa obrazka</label>
	<input type="text" id="name" name="name" class="form-control" placeholder="Podaj nazwę miasta">
	<label for="url">Adres URL</label>
	<input type="text" id="url" name="url" class="form-control" placeholder="Podaj adres URL obrazka">
	<label for="city">Wybierz miasto</label>
	<select name="city" class="form-control" id="city">
		<c:forEach items="${cities}" var="city">
		<option value="${city.id}">${city.name}</option>
		</c:forEach>
	</select>
	<button type="submit" class="btn btn-lg btn-success pull-right btn-mt-20">Dodaj obrazek</button>
	</form>
	</c:otherwise>
	</c:choose>
	</div>
</div>
<c:import url="../footer.jsp"/>