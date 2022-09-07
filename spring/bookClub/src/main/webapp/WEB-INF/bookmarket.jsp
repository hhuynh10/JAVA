<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Market</title>
</head>
<body>
<h4>Hello <c:out value="${user.name}"></c:out>! Welcome to...</h4>
<h1>The Book Broker!</h1>
<h4>Available books to borrow:</h4>
<hr>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
	</thead>
    <tbody>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><c:out value="${book.user.name}"></c:out></td>
				<c:if test = "${book.user.id==userId}">
			       <td><a href="/books/edit/${book.id}">edit</a> <a href="/books/delete/${book.id}">delete</a></td>
			    </c:if>
				<c:if test = "${book.user.id!=user.id}">
			       <td><a href="/bookmarket/${book.id}">borrow</a></td>
			    </c:if>
			</tr>	
		</c:forEach>
    </tbody>
</table>
<p>Books I'm borrowing..</p>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
	</thead>
    <tbody>
		<c:forEach var="book" items="${myBooks}">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><c:out value="${book.user.name}"></c:out></td>
				<td><a href="/bookmarket/return/${book.id}">return</a></td>
			</tr>	
		</c:forEach>
    </tbody>
</table>
<a href="/books">Back to shelves</a>
</body>
</html>