<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring Boot Hello World Practical</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">	
	</head>
	<body>
		<nav class="navbar bg-dark border-bottom border-body">
  <div class="container">
    <span class="navbar-brand mb-0 h1 text-white">CRUD App With Spring Security</span>
    <form class="d-flex" role="search">
      <a href="/logout" class="btn btn-success">Logout</a>
    </form>
  </div>
</nav>
		<div class="container mt-5 text-center">
			<h2>Your Profile Details</h2>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					
						<input class="form-control mt-2" type="text" value="${ user.name }" disabled>
						<input class="form-control mt-2" type="text" value="${ user.email }" disabled>
						<input class="form-control mt-2" type="text" value="${ user.phone }" disabled>
						<input class="form-control mt-2" type="text" value="${ user.roles }" disabled>
					
				</div>
				<div class="col-md-3"></div>
			</div>		
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	</body>
</html>