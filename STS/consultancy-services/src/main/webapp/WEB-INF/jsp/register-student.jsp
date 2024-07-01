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
		<jsp:include page="./components/navbar.jsp" />
		<div class="container mt-5 text-center">
			<h2>Student Registration</h2>
			<c:if test="${msg != null}">
    		 	<div class="alert alert-success" role="alert">
				  	<c:out value="${msg}"/>
				</div>
	    	</c:if>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form action="/handleStudentRegistration" method="post">
						<input class="form-control mt-2" type="text" name="name" placeholder="Enter your name" >
						<input class="form-control mt-2" type="email" name="email" placeholder="Enter your email" >
						<input class="form-control mt-2" type="password" name="password" placeholder="Enter your password" >
						<input class="form-control mt-2" type="text" name="specification" placeholder="Enter your specification" >
						<input class="btn btn-primary mt-3" type="submit" value="Register">
						<p class="fs-4 mt-3">Already an User? <a class="link" href="/login">Login Now</a></p>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>		
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	</body>
</html>