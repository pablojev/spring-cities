<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp"/>
<c:choose>
<c:when test="${attractions.size() == 0}">
<div class="row">
	<div class="col-md-offset-3 col-md-6">
	<div class="alert alert-danger">
		<strong>Błąd</strong>
		Brak atrakcji do wyświetlenia.
	</div>
	</div>
</div>
</c:when>
<c:otherwise>
<table class="table table-round">
	<thead>
		<tr>
			<th>#</th>
			<th>Nazwa atrakcji</th>
			<th>Akcje</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${attractions}" var="attraction" varStatus="loop">
		<tr>
			<td>${loop.index + 1}</td>
			<td>
				<strong>${attraction.name}</strong>
				<div>
				<c:forEach items="${attraction.cities}" var="city">
					<span class="label label-success">${city.name}</span>
				</c:forEach>
				</div>
			</td>
			<td>
				<a href="<c:url value='/attraction/edit/${attraction.id}' />" class="btn btn-warning">Edytuj</a>
				<a href="<c:url value='/attraction/delete/${attraction.id}' />" class="btn btn-danger">Usuń</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</c:otherwise>
</c:choose>
<c:import url="../footer.jsp"/>