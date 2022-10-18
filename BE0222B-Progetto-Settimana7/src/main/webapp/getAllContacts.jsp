<%@page import="java.util.List"%>
<%@page import="data.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<Contact> contacts = (List<Contact>) session.getAttribute("contacts");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Get All Contacts</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark navbar-expand-lg">
		<div class="container">
			<a class="navbar-brand" href="index.html">Home</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						href="addContact.jsp">Add Contact</a></li>
					<li class="nav-item"><a class="nav-link"
						href="updateContact.jsp">Update Contact</a></li>
					<li class="nav-item"><a class="nav-link"
						href="deleteContact.jsp">Delete Contact</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Get Contacts
					</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="GetAllContactsServlet">Get
									All Contacts</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="getByLastname.jsp">Get
									By Lastname</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="getByNumber.jsp">Get
									By Number</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container my-5F">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Firstname</th>
					<th scope="col">Lastname</th>
					<th scope="col">E-mail</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (contacts != null) {
					for (Contact c : contacts) {
				%>
				<tr>
					<th scope="row"><%=c.getId()%></th>
					<td><%=c.getFirstName()%></td>
					<td><%=c.getLastName()%></td>
					<td><%=c.getEmail()%></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>