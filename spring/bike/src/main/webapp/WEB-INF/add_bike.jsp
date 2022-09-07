<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Bike</title>
</head>
<body>
   <h1>Add a Bike</h1>
	<form:form action="/bikes/add" method="post" modelAttribute="bike">
		<form:errors path="user"/>
		<form:input type="hidden" path="user" value="${userId}"/>
	    <p>
	        <form:label path="brand">Brand:</form:label>
	        <form:errors path="brand"/>
	        <form:input path="brand"/>
	    </p>
	    <p>
	        <form:label path="description">Description:</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
    	</p>
    	<p>
	        <form:label path="color">Color:</form:label>
	        <form:errors path="color"/>
	        <form:input type="color" path="color"/>
	    </p>
		<p>
	        <form:label path="date">Due Date:</form:label>
	        <form:errors path="date"/>
	        <form:input type="date" path="date"/>
	    </p>
	    <input type="submit" value="Add"/>
		</form:form>
		<p><a href="/dashboard">Back to Dashboard</a></p>
</body>
</html>