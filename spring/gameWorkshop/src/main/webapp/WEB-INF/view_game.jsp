<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Game</title>
</head>
<body>
	<h1><c:out value="${game.name}"/></h1>
	<p><a href="/home">Dashboard</a></p>
	<h4>Name: <c:out value="${game.name}"/></h4>
	<h4>Developer: <c:out value="${game.user.userName}"/></h4>
	<h4>Genre: <c:out value="${game.genre}"/></h4>
	<h4>Description: <c:out value="${game.description}"/></h4>
	<c:if test = "${game.user.id==user.id}">
		<p><a href="/games/edit/${game.id}">Edit</a></p>
		<p><a href="/games/delete/${game.id}">Delete</a></p>
	</c:if>
</body>
</html>