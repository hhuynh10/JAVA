<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>
	<h2>Language <c:out value="${language.id}"/></h2>
	<p>Name: <c:out value="${language.name}"/></p>
	<p>Creator: <c:out value="${language.creator}"/></p>
	<p>Version: <c:out value="${language.version}"/></p>
	<p><a href="/languages">Dashboard</a></p>
	<p><a href="/languages/${language.id}/edit">Edit</a></p>
	<p><a href="/languages/${language.id}/delete">Delete</a></p>
</body>
</html>