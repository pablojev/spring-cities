<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp"/>
<c:choose>
<c:when test="${images.size() == 0}">
<div class="row">
	<div class="col-md-offset-3 col-md-6">
	<div class="alert alert-danger">
		<strong>Błąd</strong>
		Brak zdjęć do wyświetlenia.
	</div>
	</div>
</div>
</c:when>
<c:otherwise>
<div class="row">
<c:forEach items="${images}" var="image" varStatus="loop">
	<div class="col-md-3">
	<div class="thumbnail">
		<a href="<c:url value="/image/show/${image.id}" />">
			<img src="${image.url}" alt="obrazek" width="242px" class="img">
		</a>
		<div class="caption text-right">
			<a href="<c:url value="/image/show/${image.id}" />"><h5>${image.name}</h5></a>
			<p>
				<a href="<c:url value='/image/delete/${image.id}'/>" class="btn btn-danger">Usuń</a>
			</p>
		</div>	
	</div>
	</div>
<c:if test="${(loop.index + 1) % 4 == 0}">
</div>
<div class="row">
</c:if>
</c:forEach>
</div>
</c:otherwise>
</c:choose>
<c:import url="../footer.jsp"/>