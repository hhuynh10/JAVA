<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
</head>
<body>
   <h1>Checkout</h1>
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
			<c:forEach var="bike" items="${myBikes}">
				<tr>
					<td><c:out value="${bike.user.firstName}"/></td>
					<td><a href="bikes/${bike.id}"><c:out value="${bike.brand}"/></a></td>
					<td><c:out value="${bike.color}"/></td>
					<td><c:out value="${bike.user.location}"/></td>
					<td><a href="/bikes/edit/${bike.id}">customize</a> <a href="/checkout/return/${bike.id}">Return Bike</a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="/dashboard">Back to Dashboard</a></p>
</body>
</html>