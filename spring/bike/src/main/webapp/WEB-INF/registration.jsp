<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Registration</title>
</head>
<body>
	<h1>Welcome to a Place for Bike Lovers</h1>
	<h4>A place for you to buy and sell bikes.</h4>
	<h2>Register</h2>
	<form:form action="/register" method="post" modelAttribute="newUser">
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
	        <form:label path="location">Location:</form:label>
	        <form:errors path="location"/>
	        <form:input path="location"/>
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