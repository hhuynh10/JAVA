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
<title>New Book</title>
</head>
<body>
	<h1>Add a Book to Your Shelf!</h1>
	<form:form action="/books/new" method="post" modelAttribute="book">
		<form:errors path="user"/>
		<form:input type="hidden" path="user" value="${userId}"/>
		<p>
	        <form:label path="title">Title:</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
	    </p>
	    <p>
	        <form:label path="author">Author:</form:label>
	        <form:errors path="author"/>
	        <form:input path="author"/>
	    </p>
	    <p>
        <form:label path="thoughts">My Thoughts:</form:label>
        <form:errors path="thoughts"/>
        <form:textarea path="thoughts"/>
    	</p>
    	<input type="submit" value="Submit"/>
	</form:form>
	<p><a href="/books">Back to the shelves</a></p>
</body>
</html>