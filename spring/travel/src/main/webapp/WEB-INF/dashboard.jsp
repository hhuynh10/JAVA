<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table>
    <thead>
        <tr>
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="travel" items="${travels}">
		<tr>
			<td><a href="/travels/${travel.id}/view"><c:out value="${travel.name}"/></a></td>
            <td><c:out value="${travel.vendor}"/></td>
            <td>$<c:out value="${travel.amount}"/></td>
            <td><a href="/travels/${travel.id}/edit">Edit |</a><a href="/travels/${travel.id}/delete">Delete</a></td>
		</tr>
		</c:forEach>
    </tbody>
</table>
	<h2>Add an expense:</h2>
	<form:form action="/travels" method="post" modelAttribute="travel">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>     
        <form:input type="number" path="amount" min="0" pattern="0.00" step="0.01"/>
    </p>    
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>