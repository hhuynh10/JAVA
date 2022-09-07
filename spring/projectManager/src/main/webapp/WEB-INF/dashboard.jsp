<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.firstName}"></c:out>!</h1>
	<h4>All Projects:</h4>
	<table>
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="project" items="${projects}">
				<tr>
					<td><a href="projects/${project.id}"><c:out value="${project.title}"/></a></td>
					<td><c:out value="${project.user.firstName}"/></td>
					<td><c:out value="${project.date}"/></td>
			       	<td><a href="/dashboard/${project.id}">Join Team</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<h4>Your Projects:</h4>
	<table>
		<thead>
			<tr>
				<th>Project</th>
				<th>Team Lead</th>
				<th>Due Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach var="project" items="${myProjects}">
				<tr>
					<td><a href="projects/${project.id}"><c:out value="${project.title}"/></a></td>
					<td><c:out value="${project.user.firstName}"/></td>
					<td><c:out value="${project.date}"/></td>
					<c:if test = "${project.user.id==userId}">
			       		<td><a href="/projects/edit/${project.id}">edit</a> <a href="/projects/delete/${project.id}">delete</a></td>
			    	</c:if>
					<c:if test = "${project.user.id!=user.id}">
			       		<td><a href="/dashboard/leave/${project.id}">Leave Team</a></td>
			    	</c:if>
		</c:forEach>
		</tbody>
	</table>
	
	<p><a href="/projects/new">+ new project</a></p>
	<p><a href="/logout">Logout</a></p>
</body>
</html>