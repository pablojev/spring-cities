<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../header.jsp"/>
<div class="thumbnail">
	<h2 class="text-center">${image.name}</h2>
	<img src="${image.url}" class="img img-responsive img-rounded">
</div>
<c:import url="../footer.jsp"/>