<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Bike</title>
</head>
<body>
   <h1>Product Info</h1>
   <h4>Brand: <c:out value="${bike.brand}"/></h4>
   <h4>Description: <c:out value="${bike.description}"/></h4>
   <h4>Color: <c:out value="${bike.color}"/></h4>
   <h4>Date: <c:out value="${bike.date}"/></h4>
   <p><a href="/checkout">Go to Checkout</a></p>
   <p><a href="/dashboard">Back to Dashboard</a></p>
</body>
</html>