<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.userName}"></c:out>!</h1>
	<p><a href="/logout">Logout</a></p>
	<h2>Current Games</h2>
	<h4>Game</h4>
	<hr>
	<c:forEach var="game" items="${games}">
	<h4><a href="games/${game.id}"><c:out value="${game.name}"/></a></h4>
	<p>Genre: <c:out value="${game.genre}"/></p>
	</c:forEach>
	<hr>
	<p><a href="/games/new">Create New Game</a></p>
</body>
</html>