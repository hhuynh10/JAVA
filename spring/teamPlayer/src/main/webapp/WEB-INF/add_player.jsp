<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Player</title>
</head>
<body>
	<form:form action="/players/new" method="post" modelAttribute="player">
		<form:errors path="team"/>
		<form:input type="hidden" path="team" value="${team.id}"/>
		<p>
	        <form:label path="playerName">Player Name:</form:label>
	        <form:errors path="playerName"/>
	        <form:input path="playerName"/>
	    </p>
	    <input type="submit" value="Add"/>
	</form:form>
</body>
</html>