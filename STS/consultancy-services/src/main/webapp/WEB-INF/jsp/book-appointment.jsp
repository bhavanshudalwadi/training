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
		<nav class="navbar bg-dark border-bottom border-body" style="height: 80px">
  <div class="container" style="height: 80px">
    <span class="navbar-brand mb-0 h1 text-white">Consultancy Service</span>
    <form class="d-flex justify-content-between" style="width: 100px"
				role="search">
				<a href="/logout" class="btn btn-success p-2">Logout</a>
			</form>
  </div>
</nav>
		<div class="container mt-5">
			<h2 class="text-center">Book Appointment with ${consultant.name}</h2>

    		 	<div class="alert alert-danger d-none" id="error-msg" role="alert"></div>
				<div class="alert alert-success d-none" id="success-msg" role="alert"></div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<input type="hidden" name="consultant_id" id="consultant_id" value="${consultant.id}">
					<div class="form-group mt-2">
					    <label for="start_time">Date and time</label>
						<input class="form-control mt-2" type="datetime-local" id="start_time" name="start_time">
					</div>
				  	<div class="form-group mt-2">
					    <label for="duration">Duration</label>
						<select class="form-select" id="duration" name="duration">
						  <option selected>Select Duration</option>
						  <option value="1">1 Hour</option>
						  <option value="2">2 Hour</option>
						  <option value="3">3 Hour</option>
						  <option value="4">4 Hour</option>
						</select>
					</div>
					<div class="form-group mt-2">
					    <label for="description">Description</label>
					    <textarea class="form-control" id="description" name="description" rows="3"></textarea>
				  	</div>
					<input class="btn btn-primary mt-3" value="Book Appointment" id="btn_book">
				</div>
				<div class="col-md-3"></div>
			</div>		
		</div>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$("#btn_book").on('click', function() {
			let start_time = $("#start_time").val();
			let consultant_id = $("#consultant_id").val();
			let duration = $("#duration").val();
			let description = $("#description").val();
			
			$.ajax({
				url : "http://localhost:8181/api/bookConsultant/"+duration,
				type : "POST",
				headers: {
			        'Authorization':'Bearer '+JSON.parse(localStorage.getItem("user")).jwtToken
			    },
				contentType: "application/json",
				dataType : "json",
				data: JSON.stringify({ consultantId: consultant_id, endTime: start_time, createdOn: start_time, startTime: start_time, description: description, modifiedOn: start_time, status: 0 }),
				success : function(response) {
					$("#success-msg").html(response);
					$("#success-msg").removeClass("d-none");
					$("#error-msg").addClass("d-none");
					setTimeout(() => {
						window.location.href = '/';
					}, 1000);
				},
				error : function(xhr, status, error) {
					if(xhr.responseText === "Appointment Booked") {
						$("#success-msg").html(xhr.responseText);
						$("#success-msg").removeClass("d-none");
						$("#error-msg").addClass("d-none");
						setTimeout(() => {
							window.location.href = '/';
						}, 1000);
					}else {						
						$("#error-msg").html(xhr.responseText);
						$("#error-msg").removeClass("d-none");
						$("#success-msg").addClass("d-none");
					}
				}
			});
		});
	</script>	
	</body>
</html>