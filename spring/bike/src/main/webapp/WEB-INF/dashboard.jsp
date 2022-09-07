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
	<h4>All Bikes:</h4>
	<table>
		<thead>
			<tr>
				<th>Seller</th>
				<th>Brand</th>
				<th>Color</th>
				<th>Location</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bike" items="${bikes}">
				<tr>
					<td><c:out value="${bike.user.firstName}"/></td>
					<td><a href="bikes/${bike.id}"><c:out value="${bike.brand}"/></a></td>
					<td><c:out value="${bike.color}"/></td>
					<td><c:out value="${bike.user.location}"/></td>
					<c:if test = "${bike.user.id==userId}">
						<td><a href="/bikes/delete/${bike.id}">Sell</a></td>
					</c:if>
					<c:if test = "${bike.user.id!=userId}">
						<td><a href="/checkout/${bike.id}">Buy</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table> 
	
	<p><a href="/bikes/add">+ new bike</a></p>
	<p><a href="/checkout">Go to Checkout</a></p>
	<p><a href="/logout">Logout</a></p>
</body>
</html>