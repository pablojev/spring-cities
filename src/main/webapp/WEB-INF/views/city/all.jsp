<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp"/>
<c:choose>
<c:when test="${cities.size() == 0}">
<div class="row">
	<div class="col-md-offset-3 col-md-6">
	<div class="alert alert-danger">
		<strong>Błąd</strong>
		Brak miast do wyświetlenia.
	</div>
	</div>
</div>
</c:when>
<c:otherwise>
<table class="table table-round">
	<thead>
		<tr>
			<th>#</th>
			<th>Nazwa miasta</th>
			<th>Akcje</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cities}" var="city" varStatus="loop">
		<tr>
			<td>${loop.index + 1}</td>
			<td>
				<a href="<c:url value='/city/show/${city.id}'/>">${city.name}</a>
				<div>
					<span class="label label-success">${city.cityDescription.president}</span>
				</div>
			</td>
			<td>
				<a href="<c:url value='/city/edit/${city.id}' />" class="btn btn-warning">Edytuj</a>
				<a href="<c:url value='/city/delete/${city.id}' />" class="btn btn-danger">Usuń</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:otherwise>
</c:choose>
<c:import url="../footer.jsp"/>