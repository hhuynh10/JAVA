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
	<table>
		<thead>
			<tr>
				<th>Team Name</th>
				<th>Skill Level</th>
				<th>Game Day</th>
			</tr>
		</thead>
			<tbody>
			<c:forEach var="team" items="${teams}">
				<tr>
					<td><a href="teams/${team.id}"><c:out value="${team.name}"/></a></td>
					<td><c:out value="${team.skill}"/></td>
					<td><c:out value="${team.day}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="/teams/new">Create New Team</a></p>
</body>
</html>