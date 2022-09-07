<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Demo</title>
</head>
<body>
	<h1>Hello World</h1>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<% for (int i = 0; i < 5; i ++) { %>
		<h1><%= i %></h1>
	<% } %>
	
	<h3>The time is: <%= new Date() %></h3>
</body>
</html>