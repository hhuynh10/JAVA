<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Team</title>
</head>
<body>	
	<h1>Edit Team</h1>
	<p><a href="/home">Dashboard</a></p>
	<form:form action="/teams/edit/${team.id}" method="post" modelAttribute="team">
	    <input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="name">Team Name:</form:label>
	        <form:errors path="name"/>
	        <form:input path="name"/>
	    </p>
	    <p>
	        <form:label path="skill">Skill Level (1-5):</form:label>
	        <form:errors path="skill"/>
	        <form:input type="number" path="skill"/>
	    </p>
	    <p>
	    	<form:label path="day">Game Day:</form:label>
	    	<form:select path="day">
	    	<form:errors path="day"/>
	    		<option></option>
	    		<option>Monday</option>
	    		<option>Tuesday</option>
	    		<option>Wednesday</option>
	    		<option>Thursday</option>
	    		<option>Friday</option>
	    		<option>Saturday</option>
	    		<option>Sunday</option>
	    	</form:select>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
	<p><a href="/teams/delete/${team.id}">Delete</a></p>
</body>
</html>