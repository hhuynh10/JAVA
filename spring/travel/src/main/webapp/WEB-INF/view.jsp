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
	<h2>Travel <c:out value="${travel.id}"/></h2>
	<p>Expense Name: <c:out value="${travel.name}"/></p>
	<p>Vendor: <c:out value="${travel.vendor}"/></p>
	<p>Amount: <c:out value="${travel.amount}"/></p>
	<p>Description: <c:out value="${travel.description}"/></p>
	<a href="/">Back</a>
</body>
</html>