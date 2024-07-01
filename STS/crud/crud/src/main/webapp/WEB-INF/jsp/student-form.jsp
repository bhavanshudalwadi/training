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
		<div class="container mt-5 text-center">
			<h2>Add Student Details</h2>
			<c:if test="${msg != null}">
    		 	<div class="alert alert-success" role="alert">
				  	<c:out value="${msg}"/>
				</div>
	    	</c:if>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<form action="/addStudentHendler" method="post">
						<input class="form-control mt-2" type="text" name="name" placeholder="Enter your name" >
						<input class="form-control mt-2" type="text" name="enno" placeholder="Enter your en. no." >
						<input class="form-control mt-2" type="text" name="email" placeholder="Enter your email" >
						<input class="form-control mt-2" type="text" name="phone" placeholder="Enter your phone" >
						<input class="btn btn-primary mt-3" type="submit" value="Add Student Info">
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>		
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	</body>
</html>