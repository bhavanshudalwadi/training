<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Boot Hello World Practical</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="./components/navbar.jsp" />
	<div class="container mt-5 text-center">
		<h2>Reset Password</h2>
		<div class="alert alert-danger d-none" id="error-msg" role="alert"></div>
		<div class="alert alert-success d-none" id="success-msg" role="alert">${msg}</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<form action="/changePassword" method="post">
					<input class="form-control mt-2" type="text" id="username" name="username" placeholder="Enter username" />
					<input class="form-control mt-2" type="text" id="username" name="oldPassword" placeholder="Enter old password" />
					<input class="form-control mt-2" type="password" id="password" name="newPassword" placeholder="Enter new password" />
					<input class="btn btn-primary mt-3" type="submit" value="Reset password" id="reset"/>
				</form>
				<p class="fs-5 mt-3">
					Know Password? <a class="link" href="/login" >Login</a>
				</p>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>