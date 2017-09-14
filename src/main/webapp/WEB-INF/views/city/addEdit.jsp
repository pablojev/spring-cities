<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:import url="../header.jsp"/>
<div class="row">
	<div class="col-md-offset-3 col-md-6">
	<c:choose>
	<c:when test="${countries.size() == 0}">
		<div class="alert alert-danger">
			<strong>Błąd</strong>
			Musisz najpierw dodać Państwo, aby móc dodać miasto.
		</div>
	</c:when>
	<c:otherwise>
		<form action="" method="POST">
		<h4>Dane podstawowe</h4>
		<hr>
		<label for="name">Nazwa miasta</label>
		<input type="text" id="name" name="name" class="form-control" placeholder="Podaj nazwę miasta" value="${city.name}">
		<label for="zip">Kod pocztowy</label>
		<input type="text" id="zip" name="zip" class="form-control" placeholder="Podaj kod pocztowy" value="${city.zip}">
		<label for="population">Populacja</label>
		<div class="input-group">
		  <input type="text" id="population" name="population" class="form-control" placeholder="Podaj populację" value="${city.population}">
		  <span class="input-group-addon">tysięcy</span>
		</div>
		<label for="description">Opis miasta</label>
		<textarea type="text" id="description" name="description" class="form-control" placeholder="Podaj opis miasta">${city.description}</textarea>
		<h4 class="btn-mt-20">Dane dodatkowe</h4>
		<hr>
		<label for="country">Państwo</label>
		<select name="country" id="country" class="form-control">
		<c:forEach items="${countries}" var="country">
			<option value="${country.id}">${country.name}</option>
		</c:forEach>
		</select>
		<label for="president">Prezydent</label>
		<input type="text" id="president" name="president" class="form-control" placeholder="Podaj imię i nazwisko prezydenta" value="${city.cityDescription.president}">
		<label for="president">Powierzchnia</label>
		<input type="text" id="area" name="area" class="form-control" placeholder="Podaj powierzchnię miasta" value="${city.cityDescription.area}">
		<label for="year">Rok założenia</label>
		<input type="text" id="year" name="year" class="form-control" placeholder="Podaj rok założenia miasta" value="${city.cityDescription.year}">
		<label for="averageSalary">Średnia płaca</label>
		<input type="text" id="averageSalary" name="averageSalary" class="form-control" placeholder="Podaj kod pocztowy" value="${city.cityDescription.averageSalary}">
		<c:if test="${attractions.size() > 0}">
		<label>Atrakcje w mieście</label>
		<c:forEach items="${attractions}" var="attraction">
		<div class="checkbox">
	    		<label>
	    			<c:forEach items="${city.attractions}" var="cityAttraction">
	    			<c:choose>
	    			<c:when test="${cityAttraction.id eq attraction.id}">
	    			<c:set var="checked" value="checked='checked'"/>
	    			</c:when>
	    			<c:otherwise>
	    			<c:set var="checked" value=""/>
	    			</c:otherwise>
	    			</c:choose>
	    			</c:forEach>
				<input type="checkbox" name="attractions" value="${attraction.id}" ${checked}/>${attraction.name}
			</label>
	  	</div>
	  	</c:forEach>
	  	</c:if>
		<button type="submit" class="btn btn-lg btn-success pull-right btn-mt-20">Dodaj miasto</button>
	</form>
	</c:otherwise>
	</c:choose>
	</div>
</div>
<c:import url="../footer.jsp"/>