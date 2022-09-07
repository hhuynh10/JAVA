<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><c:out value="${user.name}"></c:out></title>
</head>
<body>
	<h1>Welcome, <c:out value="${user.name}"></c:out>!</h1>
	<h4>Books from everyone's shelves:</h4>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${books}">
				<tr>
					<td><c:out value="${book.id}"/></td>
					<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
					<td><c:out value="${book.author}"/></td>
					<td><c:out value="${book.user.name}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<p><a href="/books/new">+ Add a book to my shelf</a></p>
	<p><a href="/bookmarket">Book Market</a></p>
	<p><a href="/logout">Logout</a></p>
</body>
</html>