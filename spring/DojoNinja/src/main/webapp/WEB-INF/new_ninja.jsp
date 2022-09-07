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
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
	    <p>
	    	<form:select path="dojo">
	    		<c:forEach var="dojo" items="${dojos}">
	    			<option value="${dojo.id}">${dojo.name}</option>
	    		</c:forEach>
	    	</form:select>
	    </p>
	    <p>
	        <form:label path="firstName">First Name:</form:label>
	        <form:errors path="firstName"/>
	        <form:input path="firstName"/>
	    </p>
	    <p>
	        <form:label path="lastName">Last Name:</form:label>
	        <form:errors path="lastName"/>
	        <form:input path="lastName"/>
	    </p>
	    <p>
        <form:label path="age">Age:</form:label>
        <form:errors path="age"/>     
        <form:input type="number" path="age"/>
    </p>
	    <input type="submit" value="Create"/>
	</form:form>
	<p><a href="/">Dashboard</a></p>
</body>
</html>