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
    <form class="d-flex justify-content-between m-1" style="width: 160px" role="search">  
      <a href="/login" class="btn btn-success">Login</a>
      <a href="/userRegistration" class="btn btn-success">Register</a>
    </form>
  </div>
</nav>
		<div class="container mt-5 text-center">
			<h2>Login</h2>
			<c:if test="${msg != null}">
    		 	<div class="alert alert-success" role="alert">
				  	<c:out value="${msg}"/>
				</div>
	    	</c:if>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<form action="/login" method="post" role="form">
						<input class="form-control mt-2" type="email" name="username" placeholder="Enter your email" >
						<input class="form-control mt-2" type="password" name="password" placeholder="Enter your password" >
						<input class="btn btn-primary mt-3" type="submit" value="Login">
						<p class="fs-4 mt-3">Not an User? <a class="link" href="/userRegistration">Register Now</a></p>
					</form>
				</div>
				<div class="col-md-4"></div>
			</div>		
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	</body>
</html>