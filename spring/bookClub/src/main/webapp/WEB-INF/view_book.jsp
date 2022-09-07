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
<title>View Book</title>
</head>
<body>
	<h1><c:out value="${book.title}"/></h1>
	<p><c:out value="${book.user.name}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/></p>
	<p>Here are <c:out value="${book.user.name}"/>'s thoughts:</p>
	<hr>
	<p><c:out value="${book.thoughts}"/></p>
	<hr>
	<c:if test="${book.user.id==userId}" >  
	<p><a href="/books/edit/${book.id}">Edit</a></p>
	<p><a href="/books/delete/${book.id}">Delete</a></p>
	</c:if>
	<p><a href="/books">Back to the shelves</a></p>
</body>
</html>