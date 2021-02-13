<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>BOOKS</h2>
		</div>
	</div>

	<form action="search" method="post">
		<div id="container">
			<div id="content">
				<table border="1" width="100%" align="right">
					<tr>
						<td><b>Book search</b></td>
					</tr>

					<tr>
						<td><label><b>Book Type</b></label> <select id="search"
							name="bookType">
								<option value="Biology">Biology</option>
								<option value="computer_science">Computer science</option>
								<option value="Social">Social</option>
								<option value="Mathematic">Mathematics</option>
						</select></td>

						<td><label><b>BookId</b></label> <input type="text"
							name="bookId" /></td>

						<td><label><b>BookName</b></label> <input type="text"
							name="bookName" /></td>
					</tr>

					<tr>
						<td><input type="submit" value="search" /> <input
							type="button" value="Reset" /></td>

					</tr>


				</table>
			</div>
		</div>
	</form>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<form>
		<div id="wrapper">
			<div id="header">
				<h2>BOOK INFO</h2>
			</div>
		</div>


		<div id="container">
			<div id="content">
				<table border="1" width="100%" align="left">
					<tr>
						<th>Book Type</th>
						<th>Book Id</th>
						<th>Book Name</th>
						<th>Price</th>
						<th>Comments</th>
						<th>No of copies</th>
						<th>Action</th>
						<!-- <th>you want to buy?</th>
						<th>Add one more copy of book</th> -->
					</tr>


					<c:forEach var="tempBook" items="${books}">

						<!-- construct an "update" link with bookId -->
						<c:url var="updateLink" value="/showFormForUpdate">
							<c:param name="bookId" value="${tempBook.bookId}" />
						</c:url>

						<!-- construct an "delete" link with bookId -->
						<c:url var="deleteLink" value="/delete">
							<c:param name="bookId" value="${tempBook.bookId}" />
						</c:url>


						<tr>
							<td>${tempBook.bookType}</td>
							<td>${tempBook.bookId}</td>
							<td>${tempBook.bookName}</td>
							<td>${tempBook.price}</td>
							<td>${tempBook.comments}</td>
							<td>${tempBook.noOfCopies}</td>

							<td>
								<!-- display update Link --> <a href="${updateLink }">Update</a>
								| <a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure yo want to delete this Book?'))) return false">Delete</a>
							</td>

							<!-- <td><input type="button" value="buy" /></td>
							<td><input type="button" value="Add copy" /></td> -->
						</tr>
					</c:forEach>
				</table>

			</div>
		</div>
	</form>

	<input type="button" value="create"
		onclick="window.location.href='showFormForAdd';return false;" />



</body>
</html>