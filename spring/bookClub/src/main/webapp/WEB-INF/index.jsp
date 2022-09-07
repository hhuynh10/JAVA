<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h1>Book Club</h1>
	<h4>A place for friends to share thoughts on books.</h4>
	<h2>Register</h2>
	<form:form action="/register" method="post" modelAttribute="newUser">
	    <p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="email">Email:</form:label>
	        <form:errors path="email"/>
	        <form:input type="email" path="email"/>
	    </p>
	    <p>
	        <form:label path="password">Password:</form:label>
	        <form:errors path="password"/>
	        <form:input type="password" path="password"/>
	    </p>
	    <p>
	        <form:label path="confirm">Confirm PW:</form:label>
	        <form:errors path="confirm"/>
	        <form:input type="password" path="confirm"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
	
	<h2>Log in</h2>
	<form:form action="/login" method="post" modelAttribute="newLogin">
	<p>
	        <form:label path="email">Email:</form:label>
	        <form:errors path="email"/>
	        <form:input type="email" path="email"/>
	    </p>
	    <p>
	        <form:label path="password">Password:</form:label>
	        <form:errors path="password"/>
	        <form:input type="password" path="password"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>