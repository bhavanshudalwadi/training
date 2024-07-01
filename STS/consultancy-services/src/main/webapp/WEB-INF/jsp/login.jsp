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
		<h2>Login</h2>
		<div class="alert alert-danger d-none" id="error-msg" role="alert"></div>
		<div class="alert alert-success d-none" id="success-msg" role="alert"></div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<input class="form-control mt-2" type="email" id="username" name="username" placeholder="Enter your email" />
				<input class="form-control mt-2" type="password" id="password" name="password" placeholder="Enter your password" />
				<input class="btn btn-primary mt-3" type="submit" value="Login" id="login"/>
				<p class="fs-6 mt-3">
					Forget Password? <a class="link" href="/forget-password" >Forget Password</a>
				</p>
				<p class="fs-6 mt-3">
					Not an User? <br />
					<a class="link" href="/student-registration" >Register as Student</a>&nbsp;
					<a class="link" href="/consultant-registration" >Register as Consultant</a>
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
	<script>
		$("#login").on('click', function() {
			let email = $("#username").val();
			let password = $("#password").val();
			
			$.ajax({
				url : "http://localhost:8181/auth/loginHandler",
				type : "POST",
				contentType: "application/json",
				dataType : "json",
				data: JSON.stringify({ email, password }),
				success : function(response) {
					if(response.jwtToken != undefined && response.username != undefined) {						
						$("#success-msg").html("Login Successful");
						$("#success-msg").removeClass("d-none");
						$("#error-msg").addClass("d-none");
						localStorage.setItem("user", JSON.stringify(response));
						setTimeout(() => {
							window.location.href = '/';
						}, 1000);
					}else {
						$("#error-msg").html(response);
						$("#error-msg").removeClass("d-none");
						$("#success-msg").addClass("d-none");
					}
				},
				error : function(xhr, status, error) {
					console.error(xhr.responseText);
					$("#error-msg").html(xhr.responseText);
					$("#error-msg").removeClass("d-none");
					$("#success-msg").addClass("d-none");
				}
			});
		});
	</script>
</body>
</html>