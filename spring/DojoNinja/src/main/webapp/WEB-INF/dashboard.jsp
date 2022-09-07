<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos</title>
</head>
<body>
	<h1>All Dojos</h1>
	<c:forEach var="dojo" items="${dojos}">
		<p><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></p>
	</c:forEach>
	<hr>
	<p><a href="/dojos/new">New Dojo</a></p>
	<p><a href="/ninjas/new">New Ninja</a></p>
</body>
</html>