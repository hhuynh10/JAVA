<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Game</title>
</head>
<body>
	<h1>New Game</h1>
	<p><a href="/home">Dashboard</a></p>
	<form:form action="/games/new" method="post" modelAttribute="game">
		<form:errors path="user"/>
		<form:input type="hidden" path="user" value="${userId}"/>
		<p>
	        <form:label path="name">Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="genre">Genre:</form:label>
	        <form:errors path="genre"/>
	        <form:input path="genre"/>
	    </p>
	    <p>
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
    	</p>
	 	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>