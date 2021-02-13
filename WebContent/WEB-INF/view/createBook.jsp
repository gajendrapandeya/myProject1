<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>save Book</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>BOOKS</h2>
		</div>
	</div>

	<div id="wrapper">
		<div id="header">
			<table border="1" width="100%" align="center">
				<tr>
					<td>
						<!-- header -->
						<h3>Book Details</h3>
					</td>
				</tr>
			</table>
		</div>
	</div>



	<form:form action="saveBook" modelAttribute="books" method="POST" autocomplete="false">

		<!--need to associate this data with Book Id  -->
		<form:hidden path="bookId" />

		<table border="1" width="100%" align="center">
			<tbody>
				<tr>
					<td><label>Book Type</label><br> <select 
						name="bookType">
							<option value="Biology">Biology</option>
							<option value="Computer_science">Computer science</option>
							<option value="Social">Social</option>
							<option value="Mathematic">Mathematics</option>
					</select></td>


					<td><label>Book ID</label><br> <form:input path="bookId" /></td>

					<td><label>Book Name</label><br> <form:input
							path="bookName" /></td>
					<td><label>Price</label><br> <form:input path="price" />
					</td>
					<td><label>comments</label><br> <form:input
							path="comments" /></td>

					<td><label>No of Copies</label><br> <form:input
							path="noOfCopies" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Submit"> <input
						type="submit" value="Cancel"
						onclick="window.location.href='display';return false;"></input></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</body>

</html>