<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<h3>Welcome, <c:out value="${user.userName}"></c:out>!</h3>
	<p>This is your dashboard. Nothing to see here yet.</p>
	<p><a href="/logout">logout</a></p>
</body>
</html>