<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Team</title>
</head>
<body>
	<h1><c:out value="${team.name}"/></h1>
	<p><a href="/home">Dashboard</a></p>
	<h4>Team name: <c:out value="${team.name}"/></h4>
	<h4>Skill Level: <c:out value="${team.skill}"/></h4>
	<h4>Game Day: <c:out value="${team.day}"/></h4>
	<h4>Players:</h4>
	<c:forEach var="player" items="${team.players}">
		<ul>
			<li><c:out value="${player.playerName}"/></li>
		</ul>
	</c:forEach>
	<hr>
	<h3>Add Players:</h3>
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
	<p><a href="/teams/edit/${team.id}">edit</a></p>
	<p><a href="/teams/delete/${team.id}">Delete</a></p>
</body>
</html>