<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Contact</title>
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
	<div class="container my-5">
		<form method="POST" action="AddContactServlet">
			<div class="mb-3">
				<label for="firstName" class="form-label">Firstname</label> <input
					type="text" class="form-control" id="firstName"
					aria-describedby="firstName" name="firstName" required>
			</div>
			<div class="mb-3">
				<label for="lastName" class="form-label">Lastame</label> <input
					type="text" class="form-control" id="lastName"
					aria-describedby="lastName" name="lastName" required>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">E-mail</label> <input
					type="email" class="form-control" id="email"
					aria-describedby="email" name="email" required>
			</div>
			<div class="mb-3">
				<label for="phoneNumber1" class="form-label">Number 1</label> <input
					type="tel" class="form-control" id="phoneNumber1"
					aria-describedby="phoneNumber1" name="phoneNumber1" required>
			</div>
			<div class="mb-3">
				<label for="phoneNumber2" class="form-label">Number 2</label> <input
					type="tel" class="form-control" id="phoneNumber2"
					aria-describedby="phoneNumber2" name="phoneNumber2">
			</div>
			<button type="submit" class="btn btn-success text-uppercase">Add
				contact</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
		crossorigin="anonymous"></script>
</body>
</html>