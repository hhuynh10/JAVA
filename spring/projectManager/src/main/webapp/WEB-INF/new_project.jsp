<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New Project</title>
</head>
<body>
	<h1>Create a Project</h1>
	<form:form action="/projects/new" method="post" modelAttribute="project">
		<form:errors path="user"/>
		<form:input type="hidden" path="user" value="${userId}"/>
		<p>
	        <form:label path="title">Project Title:</form:label>
	        <form:errors path="title"/>
	        <form:input path="title"/>
	    </p>
	    <p>
	        <form:label path="description">Project Description:</form:label>
	        <form:errors path="description"/>
	        <form:textarea path="description"/>
    	</p>
    	<p>
	        <form:label path="date">Due Date:</form:label>
	        <form:errors path="date"/>
	        <form:input type="date" path="date"/>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
	<button><a href="/dashboard">Cancel</a></button>
</body>
</html>