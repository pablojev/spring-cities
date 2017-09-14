<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp"/>
<h3>Opis</h3>
<hr>
<div class="well">
	<strong>${city.name}</strong> - ${city.description}
</div>
<c:if test="${city.images.size() > 0}">
<h3>Galeria</h3>
<hr>
<div class="row">
<c:forEach items="${city.images}" var="image" varStatus="loop">
<div class="col-md-3">
<div class="thumbnail">
	<a href="<c:url value="/image/show/${image.id}" />">
		<img src="${image.url}" alt="obrazek" width="242px" class="img">
	</a>
	<div class="caption">
		<h4 class="text-center">
			<a href="<c:url value="/image/show/${image.id}" />">${image.name}</a>
		</h4>
	</div>
</div>
</div>
<c:if test="${(loop.index + 1) % 4 == 0}">
</div>
<div class="row">
</c:if>
</c:forEach>
</div>
</c:if>
<c:import url="../footer.jsp"/>