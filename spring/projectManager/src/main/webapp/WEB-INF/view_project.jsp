<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Project</title>
</head>
<body>
	<h1>Project Details</h1>
	<h4>Project: <c:out value="${project.title}"/></h4>
	<h4>Description: <c:out value="${project.description}"/></h4>
	<h4>Due Date: <c:out value="${project.date}"/></h4>
	<a href="/dashboard">Back to Dashboard</a>
</body>
</html>